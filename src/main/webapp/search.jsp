<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<style>
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color:#ffcccc;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(3,1,3,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #cc0052;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #800033;}
</style>
<body>
 <%
String n=(String)session.getAttribute("semail");
out.print("<h2>Welcome </h2>"+n+"<h2> to our Matrimonial Site</h2>");
%>

<div class="dropdown">
  <button class="dropbtn">search</button>
  <div class="dropdown-content">
      <a href="Gender.jsp">Gender</a>
      <a href="City.jsp">City</a>
    <a href="occupation.jsp">Occupation</a>
    <a href="UserProfile.jsp">Name</a>
        <a href="Salary.jsp">Salary</a>
        <a href="religion.jsp">Religion</a>
        <a href="NotInOccup.jsp">Not in Occupation</a>
                <a href="Height.jsp">Height</a>
        
    
    
  </div>
</div>

<!--  <a href="City.jsp">city</a><br>
<a href="occupation.jsp">Occupation</a><br>
<a href="UserProfile.jsp">Name</a><br>-->

</body>
</html>