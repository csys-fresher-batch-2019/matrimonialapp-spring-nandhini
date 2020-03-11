package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.nandhini.matrimonyapp.dao.AdminLoginDAO;
import com.nandhini.matrimonyapp.domain.AdminLogin;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@Service
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("userName");
		String pass = request.getParameter("password");
		AdminLogin al = new AdminLogin();
		al.setUserName(user);
		al.setPassword(pass);
		AdminLoginDAO a = DAOFactory.getAdminLoginDAO();
		try {
			msg = a.adminLogin(al);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (msg.equals("success")) {

			response.sendRedirect("AdminHome.jsp");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UserName or password incorrect');");
			out.println("location='AdminLogin.jsp';");
			out.println("</script>");

		}
	}

}
