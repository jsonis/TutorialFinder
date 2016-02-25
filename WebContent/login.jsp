
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Form:</title>
	</head>
	<body>
		<form action="process-Login.html" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			<tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"></td>
			<tr>	
			<tr>
				<td><input type="submit" value="login"></td>
			<tr>
		</table>
		</form>	
		<%
			String message =(String) request.getAttribute("message");
			if(!(message == null)){
				out.println(message);
			}else{
				message = "";
				out.println(message);
			}
		%>
	</body>
</html>
