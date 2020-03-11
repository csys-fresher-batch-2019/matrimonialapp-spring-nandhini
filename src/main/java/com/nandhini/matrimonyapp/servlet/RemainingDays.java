package com.nandhini.matrimonyapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.domain.MembershipDuration;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@WebServlet("/RemainingDays")
public class RemainingDays extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<MembershipDuration> d = new ArrayList<MembershipDuration>();
		MembershipDurationDAO p = DAOFactory.getMembershipDurationDAO();
		int user_id = Integer.parseInt(request.getParameter("userid"));
		try {
			d = p.findByRemainingDays(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<div align=center>");
		out.print("<h2>Remaining Days</h2>");
		out.print("<br>");
		out.print("</div>");

		out.print("<table cellpadding=5 border=5 align=center><tr><th>User Name</th><th>Remaining Days</th></tr>");

		for (MembershipDuration pi : d) {
			out.print("<tr><td>" + pi.getUserName() + "</td><td>" + pi.getRemainingDays() + "</td></tr>");
		}
		out.print("</table>");
		out.print("<div align=center>");
		out.print("<br>");
		out.print("<button  onclick=\"window.location.href ='DurationDetails.jsp';\">Back</button>");
		out.print("</div>");

	}

}
