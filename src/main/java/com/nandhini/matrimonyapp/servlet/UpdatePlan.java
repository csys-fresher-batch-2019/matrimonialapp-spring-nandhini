package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nandhini.matrimonyapp.dao.MembershipPlanInterfaceDAO;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@WebServlet("/UpdatePlan")
public class UpdatePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembershipPlanInterfaceDAO p = DAOFactory.getMembershipPlanInterfaceDAO();
		int planid = Integer.parseInt(request.getParameter("planid"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		try {
			p.updatePlan(amount, planid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("plan.jsp");

	}

}
