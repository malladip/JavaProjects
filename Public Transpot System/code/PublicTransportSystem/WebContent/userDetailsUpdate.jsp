<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
if (document.form.name.value == ""){
	alert ( "Please enter name" );
	return false;
}

var phone_regex = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
if (!phone_regex.test(document.form.phoneNumber.value)){
	alert ( "Please enter valid phone number" );
	return false;
}

var number_regex = /[0-9]/;
if (!number_regex.test(document.form.aptno.value)){
	alert ( "Please enter valid aptno" );
	return false;
}
if (document.form.street.value == ""){
	alert ( "Please enter street" );
	return false;
}
if (document.form.city.value == ""){
	alert ( "Please enter city" );
	return false;
}
if (document.form.state.value == ""){
	alert ( "Please enter state" );
	return false;
}
var pincode_regex = /(^\d{5}$)|(^\d{5}-\d{4}$)/;
if (!pincode_regex.test(document.form.pincode.value)){
	alert ( "Please enter valid pincode" );
	return false;
}
var email = document.form.email.value;
var atpos = email.indexOf("@");
var dotpos = email.lastIndexOf(".");
if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
    alert("Please enter a valid e-mail address");
    return false;
}

return true;	
}
</script>
</head>
<body style = "border: 2px solid black; background-color:lightblue; padding: 10px 10px 10px 10px;  ">
<center>
<h2>Edit details</h2>
	<hr>
	
	<form action="userDetailsUpdate" target="_parent" method="post" name ="form" onsubmit="return validate();">
	
		<table>

			<tr>
				<td>Name
				<td><input type="text" name="name" size=30 value = <%out.println(request.getAttribute("name"));%>>
			</tr>

			<tr>
				<td>Email
				<td><input type="text" name="email" size=30 value = <%out.println(request.getAttribute("email"));%>>
			</tr>

			<tr>
				<td>Phone
				<td><input type="text" name=phoneNumber size=30 value = <%out.println(request.getAttribute("phone"));%>>
			</tr>

			<tr>
				<td>apartment no
				<td><input type="text" name=aptno size=30 value = <%out.println(request.getAttribute("aptno"));%> >
			</tr>
			<tr>
				<td>street
				<td><input type="text" name=street size=30 value = <%out.println(request.getAttribute("street"));%>>
			</tr>
			<tr>
				<td>city
				<td><input type="text" name=city size=30 value = <%out.println(request.getAttribute("city"));%>>
			</tr>
			<tr>
				<td>state
				<td><input type="text" name=state size=30 value = <%out.println(request.getAttribute("state"));%>>
			</tr>
			<tr>
				<td>pincode
				<td><input type="text" name=pincode size=30 value = <%out.println(request.getAttribute("pincode"));%>>
			</tr>
		</table>
		<p>
			<input type=submit value="Update">
		
	</form>
	</center>
</body>
</html>