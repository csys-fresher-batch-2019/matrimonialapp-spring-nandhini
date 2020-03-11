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
<form action="UpdateExpiryDate" method="post">
<h1>Extend Expiry validity</h1>
<table  align="left" cellpadding="7" >
<tr>
<td><h3 >Enter UserID:</h3>
</td>
<td><input type="number" name="userid" required/>
</td>
</tr>
<tr>
<td><h3 >Enter PlanId:</h3>
</td>
<td><input type="number" name="planid" required/>
</td>
</tr>
<tr>
<td><h3 >Enter Month Validity:</h3>
</td>
<td><input type="number" name="month" required/>
</td>
</tr>
<tr>
<td align="right">
<input type="submit" name="expiry" value="submit" >
<td>
</tr>
</table>
</form>
</div>

</body>
</html>