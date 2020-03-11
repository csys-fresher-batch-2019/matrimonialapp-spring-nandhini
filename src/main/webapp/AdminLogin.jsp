<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body style="background-image:url('images/img1.jpg')">
<div align="center">

<form action="AdminLoginServlet" method="post">
<h1><p style = "font-family:georgia,garamond,serif;font-size:25px;font-style:italic;">
     Shyloo Matrimony
      </p></h1> 
<h1>LOGIN</h1>
<hr>
<h3 align="center">Enter User Name:</h3><input type="text" name="userName" required/>
<br/>
<br/>
<br/>
<h3 align="center">Enter Password:</h3><input type="password" name="password" required/>
<br/>
<br/>
<input type="submit" name="login" value="login" >
<br/>
</form>
</body>
</html>