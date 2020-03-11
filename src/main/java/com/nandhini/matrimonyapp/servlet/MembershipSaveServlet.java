package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.domain.MembershipDuration;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@WebServlet("/MembershipSaveServlet")
public class MembershipSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembershipDuration m = new MembershipDuration();
		MembershipDurationDAO p = DAOFactory.getMembershipDurationDAO();
		m.setMdUserId(Integer.parseInt(request.getParameter("userid")));
		m.setMdPlanId(Integer.parseInt(request.getParameter("planid")));
		HttpSession session = request.getSession();
		session.setAttribute("suserid", request.getParameter("userid"));
		session.setAttribute("splanid", request.getParameter("planid"));
		try {
			p.saveMembershipDurationDetails(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("CalculateExpiryDate.jsp");

	}

}
