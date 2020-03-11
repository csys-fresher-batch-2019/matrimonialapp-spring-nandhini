<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@include file="header.jsp" %>
     <%@ page import="com.nandhini.matrimonyapp.dao.impl.RequestStatusImpl" %>
    <%@ page import="com.nandhini.matrimonyapp.dao.RequestStatusDAO" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>

<table  align="left" cellpadding="7" >
<tr>
<td><h3 >Update Status:</h3>
</td><br>
<td><input type="radio" name="sts" value="accepted"> Accepted<br></td>
  <td><input type="radio" name="sts" value="rejected"> Rejected<br>
</td>
</tr>
<tr>
<td><h3 >Enter Requestor Mail Id:</h3>
</td>
<td><input type="email" name="mail" required/>
</td>
</tr>
<tr>
<td align="right">
<input type="submit" name="update" value="submit" >
<td>
</tr>
</table>
</form>
<% 
String sts=request.getParameter("sts");
String acc=(String)session.getAttribute("semail");

RequestStatusImpl p=new RequestStatusImpl();
String req=request.getParameter("mail");
String status=request.getParameter("sts");
try
{
		p.updateStatus(req,acc,status);
		//response.sendRedirect("Acceptor.jsp");
}
catch(Exception e)
{
	e.printStackTrace();
}
%>


</body>
</html>