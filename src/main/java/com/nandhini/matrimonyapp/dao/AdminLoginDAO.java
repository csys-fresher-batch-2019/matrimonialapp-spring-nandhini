package com.nandhini.matrimonyapp.dao;

import com.nandhini.matrimonyapp.domain.AdminLogin;
import com.nandhini.matrimonyapp.exception.DBException;

public interface AdminLoginDAO {
	public String adminLogin(AdminLogin al) throws DBException;
}