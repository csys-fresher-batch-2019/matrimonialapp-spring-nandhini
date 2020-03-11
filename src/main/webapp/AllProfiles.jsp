<%@page import="com.nandhini.matrimonyapp.factory.DAOFactory"%>
<%@page import="com.nandhini.matrimonyapp.domain.Profiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="a_header.jsp"%>
<%@ page import="com.nandhini.matrimonyapp.dao.impl.ProfilesImpl"%>
<%@ page import="com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<form action="AllProfilesServlet" method="post">
	<%
		List<Profiles> d = new ArrayList<Profiles>();
			ProfilesInterfaceDAO p = DAOFactory.getProfilesInterfaceDAO();
			try {
		d = p.findByFullProfile();
			} catch (Exception e) {
		e.printStackTrace();
			}
			out.print("<center><h3>User Profiles</h3></center>");
			out.print(
			"<table class='table' border=5 align=center><tr><th>User Id</th><th>Name</th><th>Picture</th><th>DOB</th><th>Gender</th><th>Religion</th><th>Caste</th><th>Country</th><th>State</th><th>City</th><th>Mob.No</th><th>Aadhar.No</th><th>Height</th><th>Education</th><th>Occupation</th><th>Marital status</th><th>Salary</th><th>Registerd Date</th><th>Membership Type</th><th>Active</th></tr>");
			for (Profiles pi : d) {
		out.print("<tr><td>" + pi.getUserId() + "</td><td>" + pi.getUserName() + "</td><td><img src=images/"
				+ pi.getPic() + " height='100' width='100'> </td><td>" + pi.getDob() + "</td><td>"
				+ pi.getGender() + "</td><td>" + pi.getReligion() + "</td><td>" + pi.getCaste() + "</td><td>"
				+ pi.getCountry() + "</td><td>" + pi.getState() + "</td><td>" + pi.getCity() + "</td><td>"
				+ pi.getMobNo() + "</td><td>" + pi.getAadharNo() + "</td><td>" + pi.getHeight() + "</td><td>"
				+ pi.getEducation() + "</td><td>" + pi.getOccupation() + "</td><td>" + pi.getMaritalSts()
				+ "</td><td>" + pi.getSalary() + "</td><td>" + pi.getRegisterdDate() + "</td><td>"
				+ pi.getMembershipType() + "</td><td>" + pi.getActive() + "</td></tr>");
			}
			out.print("</table>");
	%>

</form>

</body>
</html>