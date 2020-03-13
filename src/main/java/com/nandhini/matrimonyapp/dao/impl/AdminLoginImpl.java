package com.nandhini.matrimonyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.slf4j.LoggerFactory;

import com.nandhini.matrimonyapp.controller.IndexController;
import com.nandhini.matrimonyapp.dao.AdminLoginDAO;
import com.nandhini.matrimonyapp.domain.AdminLogin;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ErrorConstant;
import com.nandhini.matrimonyapp.util.ConnectionUtil;

public class AdminLoginImpl implements AdminLoginDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public String adminLogin(AdminLogin al) throws DBException {

		String sql = "select user_name,password from login where user_name=? and password=?";

		String msg = null;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, al.getUserName());
			ps.setString(2, al.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			String userName1 = rs.getString("user_name");
				String password1 = rs.getString("password");
				if (al.getUserName().equals(userName1) && password1.equals(al.getPassword()))
					Logger.debug("Logged In...");
				msg = "success";

			} else {
				Logger.debug("Login Failed...");
				msg = "fail";
			}
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
	}
}
