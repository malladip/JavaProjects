package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
import domain.Bookmark;
import domain.Transport;

public class UserSearchController extends HttpServlet{

	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException{

		RequestDispatcher rd = null;

		DatabaseManager manager = new DatabaseManager();
		List<Transport> transports = new ArrayList<Transport>();

		HttpSession session = hreq.getSession(false);

		String searchSubmit = hreq.getParameter("search");
		
		String bookmarkSubmit = hreq.getParameter("bookmark");
		int transportNum = -1; 
		if (bookmarkSubmit != null){
			transportNum = Integer.parseInt(bookmarkSubmit.split(" ",4)[1]);
		}
		String from =hreq.getParameter("from");
		String to = hreq.getParameter("to");
		int type = Integer.parseInt(hreq.getParameter("transport_type"));

		try{

			if(searchSubmit != null) {

				if (from.equals("") && to.equals("")){
					transports = manager.searchedTransportsByType(type);
				}else if(to.equals("")){
					transports = manager.searchedTransportsByFrom(from,type);
				}else if(from.equals("")){
					transports = manager.searchedTransportsByTo(to,type);
				}else {
					transports = manager.searchedTransports(from,to,type);
				}

				hreq.setAttribute("transports",transports);

				rd = hreq.getRequestDispatcher("/userSearch.jsp");

				rd.forward(hreq,hresp);

			}
			else if(transportNum != -1){

				if(session.getAttribute("username") == null){
					PrintWriter out = hresp.getWriter();

					out.println("<div><p style = \"color:red\">Please login</p></div>");
					rd = hreq.getRequestDispatcher("/login.jsp");
					rd.include(hreq,hresp);
				}
				else
				{
					Bookmark b = manager.findBookmark(transportNum,(String)session.getAttribute("username"));
					
					if (b == null){
						manager.insertBookmark(transportNum,(String)session.getAttribute("username"));
						PrintWriter out = hresp.getWriter();

						out.println("<div><p style = \"color:green\">"+ transportNum+" bookmarked</p></div>");
						rd = hreq.getRequestDispatcher("/userSearch.jsp");
						rd.include(hreq,hresp);

					}
					else{
						PrintWriter out = hresp.getWriter();

						out.println("<div><p style = \"color:red\">Already bookmarked</p></div>");
						rd = hreq.getRequestDispatcher("/userSearch.jsp");
						rd.include(hreq,hresp);
					}
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
