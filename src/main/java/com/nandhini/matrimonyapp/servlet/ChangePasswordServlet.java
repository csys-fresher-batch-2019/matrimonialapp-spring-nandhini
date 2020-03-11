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
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProfilesInterfaceDAO p = DAOFactory.getProfilesInterfaceDAO();
		PrintWriter out = response.getWriter();
		String Mail = request.getParameter("mail");
		String OPass = request.getParameter("opass");
		String NPass = request.getParameter("npass");
		try {
			msg = p.updatePassword(Mail, OPass, NPass);
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
			out.println("alert('User or password incorrect');");
			out.println("location='ChangePass.jsp';");
			out.println("</script>");
		}

	}

}
