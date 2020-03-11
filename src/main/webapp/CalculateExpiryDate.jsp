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
<form action="CalculateExpiryDate" method="post">
<h1>Calculate Expiry Date</h1>
<h3>Id(1)-12 Months</h3>
<h3>ID(2)-6 Months</h3>
<h3>ID(3)-3 Months</h3>
<table  align="left" cellpadding="7" >
<!-- <tr>
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
</tr>-->
<tr>
<td><h3 >Enter Month To be Added:</h3>
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