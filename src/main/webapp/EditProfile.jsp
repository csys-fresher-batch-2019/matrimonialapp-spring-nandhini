<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String n = (String) session.getAttribute("semail");
	out.print("<h2>Welcome </h2>" + n);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body>
	<div>
		<form action="EditProfileServlet" method="post">
			<h1>Update Profile</h1>
			<table align="left" cellpadding="7">
				<tr>
					<td><h3>Enter User Name:</h3></td>
					<td><input type="text" name="username" required /></td>
				</tr>
				<tr>
					<td><h3>Enter Mobile.No:</h3></td>
					<td><input type="text" name="mob" required /></td>
				</tr>
				<tr>
					<td><h3>Enter Mail:</h3></td>
					<td><input type="text" name="mail" value="<%out.print(n);%>"
						readonly /></td>
				</tr>
				<tr>
					<td><h3>Enter Occupation:</h3></td>
					<td><input type="text" name="occupation" required /></td>
				</tr>
				<tr>
					<td><h3>Enter salary:</h3></td>
					<td><input type="text" name="salary" required /></td>
				</tr>
				<tr>
					<td align="right"><input type="submit" name="update"
						value="submit">
					<td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>