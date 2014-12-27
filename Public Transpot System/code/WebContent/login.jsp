<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){

if (document.form.user_id.value == ""){
alert ( "Please enter User ID" );
return false;
}
if (document.form.user_pass.value == ""){
alert ( "Please enter Password" );
return false;
}
return true;
}
</script>
</head>

<body style = "border: 2px solid black; background-color:lightblue; padding: 10px 10px 10px 10px;  ">
<center>
<form action="login" target="_parent" method="post" name ="form" onsubmit="return validate();">
		<table class="table">
		<center>
			<tr>
				<th>Login</th>
			</tr>
			<tr>
				<td>User ID :</td><td><input name="user_id" class="form-control"></td>
			</tr>
			<tr>
				<td>Password :</td><td> <input name="user_pass" type ="password" class="form-control"></td>
			</tr>
			<tr>
				<td><input type="radio" name="login_as" value="user" checked>User</td>
			</tr>
			<tr>
				<td><input type="radio" name="login_as" value="provider">Provider</td>
			</tr>
			<tr>
				<td><input type="submit" value="login" ></td>
			</tr>
		</table>
		
		<table>
		<tr><td><a href="register.jsp">Not registered as a user?</a></td></tr>
      		</table>
	</form>
	</center>

</body>
</html>