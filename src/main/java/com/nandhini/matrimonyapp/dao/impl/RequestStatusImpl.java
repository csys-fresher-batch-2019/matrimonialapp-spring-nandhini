package com.nandhini.matrimonyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.nandhini.matrimonyapp.controller.IndexController;
import com.nandhini.matrimonyapp.dao.RequestStatusDAO;
import com.nandhini.matrimonyapp.domain.RequestStatus;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ErrorConstant;
import com.nandhini.matrimonyapp.util.ConnectionUtil;

public class RequestStatusImpl implements RequestStatusDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public void saveRequest(RequestStatus r) throws DBException {
		String sql = "insert into request(requestor,acceptor)values(?,?)";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, r.getRequestor());
			ps.setString(2, r.getAcceptor());
			int row = ps.executeUpdate();
			Logger.debug(row + "Rows Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);

		}
	}

	public List<RequestStatus> findByRequestorList(String requestor) throws DBException {
		List<RequestStatus> list = new ArrayList<RequestStatus>();
		String sql = "select acceptor,status from request where requestor=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, requestor);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String acc = rs.getString("acceptor");
				String sts = rs.getString("status");
				RequestStatus r = new RequestStatus();
				r.setAcceptor(acc);
				r.setStatus(sts);
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<RequestStatus> findByAcceptorList(String acceptor) throws DBException {
		List<RequestStatus> list = new ArrayList<RequestStatus>();
		String sql = "select requestor,status from request where acceptor=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, acceptor);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String req = rs.getString("requestor");
				String sts = rs.getString("status");
				RequestStatus r = new RequestStatus();
				r.setRequestor(req);
				r.setStatus(sts);
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public void updateStatus(String requestor, String acceptor, String status) throws DBException {
		String sql = "update request set status=? where requestor=? and acceptor=?";
		@SuppressWarnings("unused")
		String error = null;
		int row = 0;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setString(2, requestor);
			ps.setString(3, acceptor);
			row = ps.executeUpdate();
			if (row == 1) {
				Logger.debug(row + "Rows Updated");

			} else {
				Logger.debug("Invalid input");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}
}
/*
 * create table request_status ( user_1_id number, user_2_id number, status
 * varchar2(20)not null, request_starts_by number(20)not null, constraint
 * user_1_id_fk foreign key(user_1_id)references profiles(user_id), constraint
 * user_2_id_fk foreign key(user_2_id)references profiles(user_id), constraint
 * status_cq check(status in ('accepted','rejected')) );
 */