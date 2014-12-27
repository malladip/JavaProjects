package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseManager;
import domain.RegisteredUser;
import domain.Transport;

public class UserHomeController extends HttpServlet{

	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException{
		RequestDispatcher rd = null;
		DatabaseManager  db = null;
		String editButton = hreq.getParameter("edit");
		String bookmarkButton =  hreq.getParameter("bookmark");
		String logOutButton = hreq.getParameter("logout");
		HttpSession session = hreq.getSession();

		if(editButton != null){

			db = new DatabaseManager();

			String username = (String)session.getAttribute("username");

			RegisteredUser r = db.findRegisteredUserByUserName(username);
			System.out.println(username);
			rd = hreq.getRequestDispatcher("/userDetailsUpdate.jsp");

			hreq.setAttribute("name",r.getName());

			System.out.println(r.getName());
			hreq.setAttribute("email",r.getEmail());
			hreq.setAttribute("phone",r.getPhoneNumber());
			hreq.setAttribute("aptno",r.getAddress().getAptno());
			hreq.setAttribute("street",r.getAddress().getStreet());
			hreq.setAttribute("city",r.getAddress().getCity());
			hreq.setAttribute("state",r.getAddress().getState());
			hreq.setAttribute("pincode",r.getAddress().getPincode());

			try {
				rd.forward(hreq,hresp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(bookmarkButton != null){

			db = new DatabaseManager();

			List<Transport> transports = new ArrayList<Transport>();

			String username = (String)session.getAttribute("username");

			try {
				transports = db.findBookmarkTransportsOfUser(username);


				hreq.setAttribute("transports",transports);

				rd = hreq.getRequestDispatcher("/bookmarks.jsp");

				rd.forward(hreq,hresp);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(logOutButton != null){

			session.invalidate();
			try {
				hresp.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
