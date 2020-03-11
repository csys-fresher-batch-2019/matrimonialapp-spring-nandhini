package com.nandhini.matrimonyapp.service;

import com.nandhini.matrimonyapp.dao.AdminLoginDAO;
import com.nandhini.matrimonyapp.domain.AdminLogin;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ServiceConstant;
import com.nandhini.matrimonyapp.exception.ServiceException;
import com.nandhini.matrimonyapp.factory.DAOFactory;

public class AdminLoginService {
	AdminLoginDAO dao = DAOFactory.getAdminLoginDAO();

	public String adminLogin(AdminLogin al) throws DBException, ServiceException {
		try {
			return dao.adminLogin(al);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

}
