package com.nandhini.matrimonyapp.service;

import java.util.List;

import com.nandhini.matrimonyapp.dao.MembershipPlanInterfaceDAO;
import com.nandhini.matrimonyapp.domain.MembershipPlan;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ServiceConstant;
import com.nandhini.matrimonyapp.exception.ServiceException;
import com.nandhini.matrimonyapp.factory.DAOFactory;

public class MembershipPlanService {

	MembershipPlanInterfaceDAO dao = DAOFactory.getMembershipPlanInterfaceDAO();

	public List<MembershipPlan> findByMembershipPlan() throws DBException, ServiceException {
		try {
			return dao.findByMembershipPlan();
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public void updatePlan(int amount, int planId) throws DBException, ServiceException {
		try {
			dao.updatePlan(amount, planId);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public List<MembershipPlan> findByExpiryDate() throws DBException, ServiceException {
		try {
			return dao.findByExpiryDate();
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}

	}

}
