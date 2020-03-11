<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@include file="a_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
<form action="UpdatePlan" method="post">
<h1>Update Plan Amount</h1>
<table  align="left" cellpadding="7" >
<tr>
<td><h3 >Enter PlanID:</h3>
</td>
<td><input type="number" name="planid" required/>
</td>
</tr>
<tr>
<td><h3 >Enter Amount:</h3>
</td>
<td><input type="amount" name="amount" required/>
</td>
</tr>
<tr>
<td align="right">
<input type="submit" name="amount" value="submit" >
<td>
</tr>
</table>
</form>
</div>

</body>
</html>