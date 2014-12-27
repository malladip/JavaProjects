<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
var number_regex = /[0-9]/;
if (!number_regex.test(document.form.number.value)){
alert ( "Please enter number." );
return false;
}
if (document.form.source.value == ""){
alert ( "Please enter source" );
return false;
}
if (document.form.destination.value == ""){
alert ( "Please enter destination" );
return false;
}
var time_regex = /^(?:2[0-3]|[01]?[0-9]):[0-5][0-9]:[0-5][0-9]$/;
if (!time_regex.test(document.form.time.value)){
alert ( "Please enter time in HH:MM:SS format" );
return false;
}
return true;
}
</script>

</head>
<body style = "border: 2px solid black; background-color:lightblue; padding: 10px 10px 10px 10px;  ">
<center>
<form action ="providerController" method ="post" name ="form" onsubmit="return validate();">
<table>
<tr>
<td>Number</td><td><input type ="text" name ="number" value=<%out.println(request.getAttribute("number"));%>></td>
</tr>
<tr>
<td>Source</td><td><input type ="text" name ="source" value=<%out.println(request.getAttribute("source"));%>></td>
</tr>
<tr>
<td>Destination</td><td><input type ="text" name ="destination" value=<%out.println(request.getAttribute("destination"));%>></td>
</tr>
<tr>
<td>Origin time</td><td><input type ="text" name ="time" value=<%out.println(request.getAttribute("time"));%>></td>
</tr>
<tr><td><input type = "submit" name = "updateTransport" value = "Update"></td></tr>
<tr>
<td>
<a href ="updateTransport.jsp">update other recordes</a>
</td>
</tr>
</table>
<input type = "hidden" name= "id" value = <%out.println(request.getAttribute("id"));%>>
</form>
</center>
</body>
</html>