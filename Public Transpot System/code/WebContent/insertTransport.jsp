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
<form action = "providerController" method = "post" name ="form" onsubmit="return validate();">
<table>
<tr>
<td>Number</td><td><input type = "text" name ="number"></td>
</tr>
<tr>
<td>Source</td><td><input type = "text" name ="source"></td>
</tr>
<tr>
<td>Destination</td><td><input type = "text" name ="destination"></td>
</tr>
<tr>
<td>Origin Time</td><td><input type = "text" name ="time"></td>
</tr>
<tr>
<td><input type = "submit" name = "insert" value = "Insert"></td>
</tr>
</table>
</form>
</center>
</body>
</html>