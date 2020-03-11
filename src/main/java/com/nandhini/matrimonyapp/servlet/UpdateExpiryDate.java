package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.domain.MembershipDuration;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@WebServlet("/UpdateExpiryDate")
public class UpdateExpiryDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembershipDuration p = new MembershipDuration();
		MembershipDurationDAO m = DAOFactory.getMembershipDurationDAO();
		p.setMdUserId(Integer.parseInt(request.getParameter("userid")));
		p.setMdPlanId(Integer.parseInt(request.getParameter("planid")));
		p.setMonthValidity(Integer.parseInt(request.getParameter("month")));
		try {
			m.updateExpiryDate(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("DurationDetails.jsp");

	}

}
