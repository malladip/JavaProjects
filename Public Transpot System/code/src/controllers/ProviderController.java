package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseManager;
import domain.Transport;

public class ProviderController extends HttpServlet{

	protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) throws ServletException{
		DatabaseManager manager = null;
		RequestDispatcher rd = null;
		String insertButton = hreq.getParameter("insert");
		String deleteButton = hreq.getParameter("delete");
		String searchButton = hreq.getParameter("search");
		String updateButton = hreq.getParameter("update");
		String updateTransportButton = hreq.getParameter("updateTransport");
		String logoutButton = hreq.getParameter("logout");
		HttpSession session = hreq.getSession(false);

		if (session.getAttribute("providertype") != null)
		{
			int type = (int)session.getAttribute("providertype");		
			if(insertButton != null){
				try {
					int num = Integer.parseInt(hreq.getParameter("number"));
					String source = hreq.getParameter("source");
					String destination = hreq.getParameter("destination");
					Time time = java.sql.Time.valueOf(hreq.getParameter("time"));

					manager = new DatabaseManager();

					int id =manager.insertTransport(type,num,source,destination,time);

					if(id == 0){
						PrintWriter out;
						out = hresp.getWriter();
						out.println("<div><p style = \"color:red\">Insertion failed</p></div>");
						rd = hreq.getRequestDispatcher("/insertTransport.jsp");
						rd.include(hreq,hresp);

					}

					else{
						PrintWriter out;
						out = hresp.getWriter();
						out.println("<div><p style = \"color:green\">Inserted transport</p></div>");
						rd = hreq.getRequestDispatcher("/insertTransport.jsp");
						rd.include(hreq,hresp);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			else if(searchButton != null){

				manager = new DatabaseManager();
				List<Transport> transports = new ArrayList<Transport>();

				String from =hreq.getParameter("from");
				String to = hreq.getParameter("to");

				try {	

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

					rd = hreq.getRequestDispatcher("/updateTransport.jsp");

					rd.forward(hreq,hresp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if(deleteButton!= null){

				manager = new DatabaseManager();
				List<Integer> transportNums = new ArrayList<Integer>();
				String[] deleteTransports =  hreq.getParameterValues("deleteTransport");

				try 
				{
					if (deleteTransports != null ){
						for(String t :deleteTransports){
							if(t != null){
								int transportNum = Integer.parseInt(t);
								transportNums.add(transportNum);
							}
						}}
					int effected_rows = manager.deleteTransportsByNumbers(transportNums);

					PrintWriter out;
					out = hresp.getWriter();

					out.println("<div><p style = \"color:green\">Deleted "+effected_rows+" rows</p></div>");
					rd = hreq.getRequestDispatcher("/updateTransport.jsp");
					rd.include(hreq,hresp);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}

			else if(updateButton != null){
				int transportNum = Integer.parseInt(updateButton.split(" ",2)[1]);
				manager = new DatabaseManager();
				Transport transport = manager.findTransportByNum(transportNum);
				hreq.setAttribute("id",transport.getId());
				hreq.setAttribute("number",transport.getNumber());
				hreq.setAttribute("source",transport.getSource());
				hreq.setAttribute("destination",transport.getDestination());
				hreq.setAttribute("time",transport.getOriginTime());
				rd = hreq.getRequestDispatcher("/transportDetailsUpdate.jsp");
				try {
					rd.forward(hreq,hresp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if(updateTransportButton != null){
				try{
					Transport t = new Transport();
					manager = new DatabaseManager();
					int id = Integer.parseInt(hreq.getParameter("id"));
					int number = Integer.parseInt(hreq.getParameter("number"));
					System.out.println(id);
					String source = hreq.getParameter("source");
					String destination = hreq.getParameter("destination");
					Time time =  java.sql.Time.valueOf(hreq.getParameter("time"));
					int count = manager.updateTransport(id,type,number,source,destination,time);

					if(count != 0){
						PrintWriter out;
						out = hresp.getWriter();
						out.println("<div><p style = \"color:green\">Updated the record</p></div>");
						rd = hreq.getRequestDispatcher("/updateTransport.jsp");
						rd.include(hreq,hresp);
					}
				}
				catch(Exception e){
					PrintWriter out;
					try {
						out = hresp.getWriter();

						out.println("<div><p style = \"color:red\">Error updating the record</p></div>");
						rd = hreq.getRequestDispatcher("/transportDetailsUpdate.jsp");
						rd.include(hreq,hresp);
					}catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			else if(logoutButton != null){
				session.invalidate();
				try {
					hresp.sendRedirect("home.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else //not logged in
		{
			PrintWriter out;
			try {
				out = hresp.getWriter();

				out.println("<div><p style = \"color:red\">Please login</p></div>");
				rd = hreq.getRequestDispatcher("/login.jsp");
				rd.include(hreq,hresp);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
