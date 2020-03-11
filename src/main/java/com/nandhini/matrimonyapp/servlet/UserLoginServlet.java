package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ProfilesInterfaceDAO p = DAOFactory.getProfilesInterfaceDAO();
		String Mail = request.getParameter("mail");
		String Pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		session.setAttribute("semail", Mail);
		try {
			msg = p.userLogin(Mail, Pass);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if (msg.equals("success")) {
			response.sendRedirect("UserHome.jsp");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UserName or password incorrect');");
			out.println("location='Login.jsp';");
			out.println("</script>");
		}

	}
}
