<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body style="background-image:url('images/img4.jpg')">
<div align="center">
<form action="UserLoginServlet" method="post">
<h1><p style ="font-family:georgia,garamond,serif;font-size:25px;font-style:italic;">
        Welcome to Shyloo Matrimony
      </p></h1> 
<h1>LOGIN</h1>
<hr>
<marquee><h2><p style = "font-family:georgia,garamond,serif;font-size:16px;font-style:italic;">
     Every love story is beautiful, but yours should be unique....
      </p></h2>
</marquee>
<h3 align="center">Enter Mail-Id:</h3><input type="email" name="mail" required/>
<br/>
<br/>
<br/>
<h3 align="center">Enter Password:</h3><input type="password" name="pass" required/>
<br/>
<br/>
<input type="submit" name="login" value="login" >
</form>
</div>
</body>
</html>