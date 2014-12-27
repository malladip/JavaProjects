<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="domain.Transport,dao.TransportDAO,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "border: 2px solid black; background-color:lightblue; padding: 10px 10px 10px 10px;  ">
<center>
<table border = 1.5>
<tr>
<th>Type</th>
<th>Number</th>
<th>Source</th>
<th>Destination</th>
<th>Origin Time</th>
</tr>
<% 
List<Transport> transports;
transports = (List<Transport>) request.getAttribute("transports");

if(transports != null) {
Iterator it = transports.iterator();

while (it.hasNext()) {
Transport t = (Transport)it.next();
%>
<tr>
<td><%out.println(t.getType().getName());
%></td>
<td>
<%out.println(t.getNumber());%>
</td>
<td><%out.println(t.getSource());%></td>
<td><%out.println(t.getDestination());%></td>
<td><%out.println(t.getOriginTime());%></td>
</tr>
<%}}%>
</table>
</center>
</body>
</html>