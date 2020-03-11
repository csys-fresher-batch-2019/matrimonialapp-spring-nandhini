package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@WebServlet("/UpdateActiveStatus")
public class UpdateActiveStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProfilesInterfaceDAO p = DAOFactory.getProfilesInterfaceDAO();
		int userid = Integer.parseInt(request.getParameter("userid"));
		int activests = Integer.parseInt(request.getParameter("activests"));
		try {
			p.updateActive(userid, activests);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("AdminHome.jsp");
	}

}
