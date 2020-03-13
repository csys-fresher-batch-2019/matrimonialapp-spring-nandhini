package com.nandhini.matrimonyapp.service;

import java.util.List;

import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.domain.MembershipDuration;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ServiceConstant;
import com.nandhini.matrimonyapp.exception.ServiceException;
import com.nandhini.matrimonyapp.factory.DAOFactory;

public class MembershipDurationService {
	MembershipDurationDAO dao = DAOFactory.getMembershipDurationDAO();

	public List<MembershipDuration> findByMembershipDuration() throws DBException, ServiceException {
		try {
			return dao.findByMembershipDuration();
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public void saveMembershipDurationDetails(MembershipDuration md) throws DBException, ServiceException {
		try {
			dao.saveMembershipDurationDetails(md);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public String[] updateExpiryDate(MembershipDuration md) throws DBException, ServiceException {
		try {
			return dao.updateExpiryDate(md);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public List<MembershipDuration> findByRemainingDays(int userId) throws DBException, ServiceException {
		try {
			return dao.findByRemainingDays(userId);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public void calculateExpiryDuration(int userId, int mdplanId, int monthValidity)
			throws DBException, ServiceException {
		try {
			dao.calculateExpiryDuration(userId, mdplanId, monthValidity);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

}
