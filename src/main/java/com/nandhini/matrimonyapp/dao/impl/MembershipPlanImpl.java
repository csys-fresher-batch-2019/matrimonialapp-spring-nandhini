package com.nandhini.matrimonyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import com.nandhini.matrimonyapp.controller.IndexController;
import com.nandhini.matrimonyapp.dao.MembershipPlanInterfaceDAO;
import com.nandhini.matrimonyapp.domain.MembershipPlan;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ErrorConstant;
import com.nandhini.matrimonyapp.util.ConnectionUtil;

public class MembershipPlanImpl implements MembershipPlanInterfaceDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public List<MembershipPlan> findByMembershipPlan() throws DBException {
		List<MembershipPlan> list = new ArrayList<MembershipPlan>();
		String sql = "select * from plan";
		try (Connection con = ConnectionUtil.getConnect();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql)) {
			while (rs.next()) {
				int planId = rs.getInt("plan_id");
				String membershipType = rs.getString("membership_type");
				int totalMonths = rs.getInt("total_months");
				int amount = rs.getInt("amount");
				MembershipPlan m = new MembershipPlan();
				m.setPlanId(planId);
				m.setMembershipType(membershipType);
				m.setTotalMonths(totalMonths);
				m.setAmount(amount);
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public void updatePlan(int amount, int planId) throws DBException {
		String sql = "update plan set amount=? where plan_id=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, amount);
			ps.setInt(2, planId);
			int row = ps.executeUpdate();
			Logger.debug("" + row);
			Logger.debug("Updated Success");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}

	public List<MembershipPlan> findByExpiryDate() throws DBException {
		List<MembershipPlan> list = new ArrayList<MembershipPlan>();

		String sql = "select p.user_name,p.registerd_date,m.expiry_date,l.membership_type from profiles p,plan l,membership_duration m where p.user_id=m.md_user_id and l.plan_id=m.md_plan_id";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MembershipPlan p = new MembershipPlan();
				p.setUserName(rs.getString("user_name"));
				p.setRegisterdDate(rs.getDate("registerd_date"));
				p.setExpiryDate(rs.getDate("expiry_date"));
				p.setMembershipType(rs.getString("membership_type"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}
}
/*
 * create table plan( plan_id number, membership_type varchar2(20)not null,
 * total_months number not null, amount number not null, constraint plan_id_pk
 * primary key (plan_id), constraint membership_type_cq check(membership_type
 * in('platinum','gold','silver')), constraint total_months_cq
 * check(total_months in (12,6,3)) )
 */