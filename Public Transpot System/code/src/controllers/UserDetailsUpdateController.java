package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseManager;
import domain.Address;
import domain.RegisteredUser;

public class UserDetailsUpdateController extends HttpServlet{

	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException{

		Address a = new Address();
		RegisteredUser r = new RegisteredUser();
		DatabaseManager manager = new DatabaseManager();

		HttpSession session = hreq.getSession();
		String username = (String)session.getAttribute("username");

		r.setUserid(username);
		r.setName(hreq.getParameter("name"));
		r.setEmail(hreq.getParameter("email"));
		r.setPhoneNumber( hreq.getParameter("phoneNumber"));
		
		int aptno = Integer.parseInt(hreq.getParameter("aptno"));
		String street = hreq.getParameter("street");
		String city = (hreq.getParameter("city"));
		String state = hreq.getParameter("state");
		int pincode = Integer.parseInt(hreq.getParameter("pincode"));

		a.setAptno(aptno);
		a.setStreet(street);
		a.setCity(city);
		a.setState(state);
		a.setPincode(pincode);

		try {
			
			RequestDispatcher rd =  null;
			manager.updateUserDetails(a,r);
			
			PrintWriter out;
			try {
				out = hresp.getWriter();
				out.println ("<html><body><script>alert('Profile updated!!');</script></body></html>");
				rd = hreq.getRequestDispatcher("/userHome.jsp");
				rd.include(hreq,hresp);
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			RequestDispatcher rd =  null;

			PrintWriter out;
			try {
				e.printStackTrace();
				out = hresp.getWriter();
				out.println ("<html><body><script>alert('Update Failed!');</script></body></html>");
				rd = hreq.getRequestDispatcher("/userDetailsUpdate.jsp");
				rd.include(hreq,hresp);
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
