package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseManager;
import domain.Address;
import domain.Provider;
import domain.RegisteredUser;
import domain.TransportType;

public class LoginController extends HttpServlet{

	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException{

		DatabaseManager manager = new DatabaseManager();

		ResultSet loggedId;
		RequestDispatcher rd = null;

		try{
			if(hreq.getParameter("login_as").equals("user")){

				loggedId = manager.loginUser(hreq.getParameter("user_id"),hreq.getParameter("user_pass"));

				if (loggedId.next()){
					HttpSession session = hreq.getSession(true);
					session.setAttribute("username",hreq.getParameter("user_id"));
					hresp.sendRedirect("userHome.jsp");
				}
				else{
					PrintWriter out = hresp.getWriter();
					out.println ("<html><body><script>alert('Incorrect Details!');</script></body></html>");
					//out.println("<%alert('Incorrect details')%>;");
					rd = hreq.getRequestDispatcher("/home.jsp");
					rd.include(hreq,hresp);
				}
			}
			else if(hreq.getParameter("login_as").equals("provider"))
			{
				Provider p = manager.loginProvider(hreq.getParameter("user_id"),hreq.getParameter("user_pass"));

				if (p != null){
					HttpSession session = hreq.getSession(true);
					System.out.println(p);
					session.setAttribute("providername",hreq.getParameter("user_id"));
					session.setAttribute("providertype",p.getTypeId().getId());
					hresp.sendRedirect("providerHome.jsp");
				}
				else{
					PrintWriter out = hresp.getWriter();
					out.println ("<html><body><script>alert('Incorrect Details!');</script></body></html>");
					
					//out.println("<div><p style = \"color:red\">Incorrect details</p></div>");
					rd = hreq.getRequestDispatcher("/home.jsp");
					rd.include(hreq,hresp);
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
