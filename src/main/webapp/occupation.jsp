<%@page import="com.nandhini.matrimonyapp.factory.DAOFactory"%>
<%@page import="com.nandhini.matrimonyapp.domain.Profiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@include file="header.jsp" %>
     <%@ page import="com.nandhini.matrimonyapp.dao.impl.ProfilesImpl" %>
    <%@ page import="com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body style="background-image:url('images/123.jpg')">
<div>
<form >
<h1>Display Profile as per their Occupation</h1>
<table  align="left" cellpadding="7" >
<tr>
<td><h3 >Enter Gender:</h3>
</td>
<td><input type="radio" name="gender" value="M"> Male<br>
  <input type="radio" name="gender" value="F"> Female<br>
</td>
</tr>
<tr>
<td><h3 >Enter Occupation:</h3>
</td>
<td><input type="text" name="occupation" required/>
</td>
</tr>

<tr>
<td align="right">
<input type="submit" name="occupation" value="submit" >
<td>
</tr>
</table>
</form>
</div>
<%
	List<Profiles> d=new ArrayList<Profiles>();
ProfilesInterfaceDAO p = DAOFactory.getProfilesInterfaceDAO();
String gender=request.getParameter("gender");
String occupation=request.getParameter("occupation");

 try {
		d=p.findByOccupation(gender,occupation);
 }		
catch(Exception e)
{
	e.printStackTrace();
}
	

out.print("<table border=5 align=center><tr><th>Name</th><th>Picture</th><th>DOB</th><th>Gender</th><th>Religion</th><th>Caste</th><th>Country</th><th>State</th><th>City</th><th>Mob.No</th><th>Height</th><th>Education</th><th>Occupation</th><th>Marital status</th><th>Salary</th><th>Action</th></tr>");


for (Profiles pi : d) {
	out.print("<tr><td>"+pi.getUserName()+"</td><td><img src=images/"+pi.getPic()+" height='100' width='100'> </td><td>"+pi.getDob()+"</td><td>"+pi.getGender()+"</td><td>"+pi.getReligion()+"</td><td>"+pi.getCaste()+"</td><td>"+pi.getCountry()+"</td><td>"+pi.getState()+"</td><td>"+pi.getCity()+"</td><td>"+pi.getMobNo()+"</td><td>"+pi.getHeight()+"</td><td>"+pi.getEducation()+"</td><td>"+pi.getOccupation()+"</td><td>"+pi.getMaritalSts()+"</td><td>"+pi.getSalary()+"</td><td><a href=SendRequest.jsp?mail="+pi.getMail()+">Request</a></td></tr>");
	out.print("<br>");
}

out.print("</table>");
%>
</body>
</html>