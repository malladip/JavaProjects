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
<form  action ="userSearch" target="iframe" method ="post">
<table>
<tr>
<td>From</td>
<td><input name="from" class="form-control"></td>
</tr>

<tr>
<td>To</td>
<td><input name="to" class="form-control"></td>
</tr>

<tr>
<td><input type="radio" name="transport_type" value="1" checked = true>Bus</td> 
<td><input type="radio" name="transport_type" value="2">Train</td>
</tr>

<tr>
<td><input type="submit" name ="search" value="search"></td>
</tr>
</table>

<table border = 1.5>
<tr>
<th>Number</th>
<th>Source</th>
<th>Destination</th>
<th>Origin Time</th>
<th>Bookmark</th>
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
<td>
<%out.println(t.getNumber());%>
</td>
<td><%out.println(t.getSource());%></td>
<td><%out.println(t.getDestination());%></td>
<td><%out.println(t.getOriginTime());%></td>
<td>
<%
out.println("<input type=\"submit\" name = \"bookmark\"  value= \"Mark "+t.getNumber()+" as bookmark\">");
%>
</td>
</tr>
<%}}%>
</table>
</form>
</center>
</body>
</html>