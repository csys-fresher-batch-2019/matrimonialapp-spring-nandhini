<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="header.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String n=(String)session.getAttribute("semail");
out.print("<h2>Welcome </h2>"+n);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body style="background-image:url('images/123.jpg')">
<div align="left">
<form action="ChangePasswordServlet" method="post">
<h1>CHANGE PASSWORD</h1>
<hr>
<h3 >Enter Mail-Id:</h3>
<input type="email" name="mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/>

<h3 >Enter Old Password:</h3>
<input type="text" name="opass" required/>

<h3 >Enter New Password:</h3>
<input type="text" name="npass" required/>
<br/>
<br/>
<input type="submit" name="cpass" value="submit" >


</form>
</div>
</body>
</html>