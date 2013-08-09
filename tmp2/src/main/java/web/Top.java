package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
		
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/top.jsp");
		rd.forward(req, res);
		return;
		
	}
}