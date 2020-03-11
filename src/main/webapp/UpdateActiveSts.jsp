<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@include file="a_header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body>
<div>
<form action="UpdateActiveStatus" method="post">
<h1>Update Active Status</h1>
<table  align="left" cellpadding="7" >
<tr>
<td><h3 >Enter UserID:</h3>
</td>
<td><input type="number" name="userid" required/>
</td>
</tr>
<tr>
<td><h3 >Enter Active Status:</h3>
</td>
<td><input type="radio" name="activests" value="1"> Active<br><br>
  <input type="radio" name="activests" value="0"> InActive<br>
</td>
</tr>
<tr>
<td align="right">
<input type="submit" name="active" value="submit" >
<td>
</tr>
</table>
</form>
</div>
</body>
</html>