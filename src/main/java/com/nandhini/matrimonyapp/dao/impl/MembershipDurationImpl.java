package com.nandhini.matrimonyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import com.nandhini.matrimonyapp.controller.IndexController;
import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.domain.MembershipDuration;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ErrorConstant;
import com.nandhini.matrimonyapp.util.ConnectionUtil;

public class MembershipDurationImpl implements MembershipDurationDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public List<MembershipDuration> findByMembershipDuration() throws DBException {
		List<MembershipDuration> list = new ArrayList<MembershipDuration>();
		String sql = "select * from membership_duration";
		try (Connection con = ConnectionUtil.getConnect();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int memberId = rs.getInt("member_id");
				int mdUserId = rs.getInt("md_user_id");
				int mdPlanId = rs.getInt("md_plan_id");
				String expiryDate = rs.getString("expiry_date");
				MembershipDuration m = new MembershipDuration();
				m.setMemberId(memberId);
				m.setMdUserId(mdUserId);
				m.setMdPlanId(mdPlanId);
				m.setExpiryDate(expiryDate);
				list.add(m);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public void saveMembershipDurationDetails(MembershipDuration md) throws DBException {
		String sql = "insert into membership_duration(member_id,md_user_id,md_plan_id)values(memb_id_sq.nextval,?,?)";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, md.getMdUserId());
			ps.setInt(2, md.getMdPlanId());
			int row = ps.executeUpdate();
			Logger.debug("" + row);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);

		}
	}

	public List<MembershipDuration> findByRemainingDays(int userId) throws DBException {
		List<MembershipDuration> list = new ArrayList<MembershipDuration>();
		String sql = "select user_name,((select expiry_date from membership_duration where md_user_id=?)-(sysdate))as remaining_days from profiles where user_id=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("user_name");
				int remainingDays = rs.getInt("remaining_days");
				MembershipDuration m = new MembershipDuration();
				m.setUserName(userName);
				m.setRemainingDays(remainingDays);
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;
	}

	public String[] updateExpiryDate(MembershipDuration md) throws DBException {
		String sql = "update membership_duration set expiry_date=add_months(expiry_date,?),md_plan_id=? where md_user_id=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, md.getMonthValidity());
			ps.setInt(2, md.getMdPlanId());
			ps.setInt(3, md.getMdUserId());
			int row = ps.executeUpdate();
			Logger.debug("" + row);
			Logger.debug(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
		return null;
	}

	public void calculateExpiryDuration(int userId, int mdplanId, int monthValidity) throws DBException {
		String sql = "update membership_duration set expiry_date=add_months((select registerd_date from profiles where user_id=?),?)where md_user_id=? and md_plan_id=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, monthValidity);
			ps.setInt(3, userId);
			ps.setInt(4, mdplanId);
			int row = ps.executeUpdate();
			Logger.debug("" + row);
			Logger.debug(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
	}

}
/*
 * create table membership_duration( member_id number, md_user_id number,
 * md_plan_id number, expiry_date date, constraint member_id_pk primary
 * key(member_id), constraint md_user_id_fk foreign key(md_user_id)references
 * profiles(user_id), constraint md_plan_id_fk foreign key(md_plan_id)references
 * plan(plan_id) );
 * 
 */