package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.domain.Profiles;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@SuppressWarnings("serial")
@Service
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int msg = 0;
		Profiles p = new Profiles();
		ProfilesInterfaceDAO m = DAOFactory.getProfilesInterfaceDAO();
		PrintWriter out = response.getWriter();
		p.setUserName(request.getParameter("Name"));
		p.setDob(LocalDate.parse(request.getParameter("dob")));
		p.setGender(request.getParameter("gender"));
		p.setReligion(request.getParameter("religion"));
		p.setCaste(request.getParameter("caste"));
		p.setCountry(request.getParameter("country"));
		p.setState(request.getParameter("state"));
		p.setCity(request.getParameter("city"));
		p.setMobNo(Long.parseLong(request.getParameter("mob")));
		p.setAadharNo(Long.parseLong(request.getParameter("aadhar")));
		p.setMail(request.getParameter("mail"));
		p.setHeight(Float.parseFloat(request.getParameter("height")));
		p.setEducation(request.getParameter("education"));
		p.setMaritalSts(request.getParameter("marital"));
		p.setOccupation(request.getParameter("occup"));
		p.setSalary(Integer.parseInt(request.getParameter("salary")));
		p.setMembershipType(request.getParameter("plan"));
		p.setPass(request.getParameter("pass"));
		p.setPic(request.getParameter("pic"));
		try {
			msg = m.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (msg == 1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Success');");
			out.println("location='Login.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Failed');");
			out.println("location='register.jsp';");
			out.println("</script>");
		}

	}
}
