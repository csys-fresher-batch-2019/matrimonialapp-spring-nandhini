package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@Service
@WebServlet("/CalculateExpiryDate")
public class CalculateExpiryDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String u = (String) session.getAttribute("suserid");
		String p1 = (String) session.getAttribute("splanid");
		int u1 = Integer.parseInt(u);
		int p2 = Integer.parseInt(p1);
		MembershipDurationDAO m = DAOFactory.getMembershipDurationDAO();
		int month = Integer.parseInt(request.getParameter("month"));
		try {
			m.calculateExpiryDuration(u1, p2, month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("DurationDetails.jsp");
	}

}
