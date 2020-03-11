<%@page import="com.nandhini.matrimonyapp.factory.DAOFactory"%>
<%@page import="com.nandhini.matrimonyapp.domain.RequestStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<%@ page import="com.nandhini.matrimonyapp.dao.impl.RequestStatusImpl"%>
<%@ page import="com.nandhini.matrimonyapp.dao.RequestStatusDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body>

	<%
		String n = (String) session.getAttribute("semail");
			out.print("<h2>Welcome </h2>" + n + "<h2> to our Matrimonial Site</h2>");
			List<RequestStatus> d = new ArrayList<RequestStatus>();
			RequestStatusDAO a = DAOFactory.getRequestStatusDAO();
			try {
		d = a.findByRequestorList(n);
			} catch (Exception e) {
		e.printStackTrace();
			}

			out.print(
			"<table  cellpadding=8 border=5 align=center><tr><th>Interested Profiles</th><th>Status</th></tr>");

			for (RequestStatus pi : d) {
		out.print("<tr><td>" + pi.getAcceptor() + "</td><td>" + pi.getStatus() + "</td></tr>");
			}

			out.print("</table>");
	%>




</body>
</html>