<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file="a_header.jsp" %>
   <%@ page import="com.nandhini.matrimonyapp.dao.impl.MembershipDurationImpl" %>
    <%@ page import="com.nandhini.matrimonyapp.dao.MembershipDurationDAO" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body>
<form action="RemainingDays" method="post">
<h3>Enter the User's Id to get their Remaining Days</h3>
<input type="text" name="userid" required/>
<input type="submit" name="submit" value="submit" >
</form>

</body>
</html>