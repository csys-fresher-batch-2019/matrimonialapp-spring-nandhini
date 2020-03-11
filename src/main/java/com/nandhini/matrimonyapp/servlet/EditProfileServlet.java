package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@Service
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ProfilesInterfaceDAO p = DAOFactory.getProfilesInterfaceDAO();
		String name = request.getParameter("username");
		long mob = Long.parseLong(request.getParameter("mob"));
		String occup = request.getParameter("occupation");
		int salary = Integer.parseInt(request.getParameter("salary"));
		try {
			msg = p.updateProfiles(occup, salary, name, mob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (msg.equals("success")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Updated Success');");
			out.println("location='UserHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Update Fail');");
			out.println("location='EditProfile.jsp';");
			out.println("</script>");
		}

	}

}
