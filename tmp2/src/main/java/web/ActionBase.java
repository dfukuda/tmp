package web;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * すべてのアクションのベース。
 * 文字コードをUTFにセットし、エラー時（不正な操作が行われたか、DBが落ちている等の異常時）の挙動として、セッションを無効にしてエラーページに飛ばす。
 * @author dfukuda
 *
 */
public abstract class ActionBase  extends HttpServlet {

	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			action(req, res);
			return;
		} catch(Exception ex) {
			HttpSession session = req.getSession(false);
			if(session != null){
				session.invalidate();
			}
			
			ex.printStackTrace();
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(req, res);
		}
	}
	
	public abstract void action(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException;
}


