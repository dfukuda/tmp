package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kwanzoo.recurly.Base;

import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * top画面を表示する。
 * @author dfukuda
 *
 */
@WebServlet(name="top",urlPatterns={"/top"})
public class Top extends ActionBase {




	@Override
	public void action(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, SQLException {
		
		recurly();
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/top.jsp");
		rd.forward(req, res);
		return;
		
	}
	
	void recurly(){
		Base.setAuth("daisuke.fukuda.fz@hitachi-solutions.com", "dnasis2000");
		
	}
}