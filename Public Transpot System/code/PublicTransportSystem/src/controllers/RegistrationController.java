package controllers;

import java.io.*;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.DatabaseManager;
import domain.Address;
import domain.RegisteredUser;

public class RegistrationController extends HttpServlet{

	public void RegistrationController(){};

	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException{


		Address a = new Address();
		RegisteredUser r = new RegisteredUser();

		r.setUserid(hreq.getParameter("userid"));
		r.setPassword(hreq.getParameter("password"));
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

		DatabaseManager manager = new DatabaseManager();
		ResultSet registered = manager.registerUser(a,r);

		try {
			if (registered != null){	
				hresp.sendRedirect("login.jsp");
			}
			else{	
				hresp.sendRedirect("register.jsp");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
