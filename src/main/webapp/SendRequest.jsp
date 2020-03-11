<%@page import="com.nandhini.matrimonyapp.factory.DAOFactory"%>
<%@page import="com.nandhini.matrimonyapp.domain.RequestStatus"%>
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
<%
	RequestStatus r=new RequestStatus();
r.setRequestor((String)session.getAttribute("semail"));
r.setAcceptor(request.getParameter("mail"));
RequestStatusDAO a=DAOFactory.getRequestStatusDAO ();
a.saveRequest(r);
response.sendRedirect("search.jsp");
%>
</form>
</body>
</html>