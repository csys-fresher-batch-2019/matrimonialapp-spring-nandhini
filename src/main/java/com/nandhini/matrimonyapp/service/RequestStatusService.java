package com.nandhini.matrimonyapp.service;

import java.util.List;

import com.nandhini.matrimonyapp.dao.RequestStatusDAO;
import com.nandhini.matrimonyapp.domain.RequestStatus;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ServiceConstant;
import com.nandhini.matrimonyapp.exception.ServiceException;
import com.nandhini.matrimonyapp.factory.DAOFactory;

public class RequestStatusService {
	RequestStatusDAO dao = DAOFactory.getRequestStatusDAO();

	public void insertRequest(RequestStatus r) throws DBException, ServiceException {
		try {
			dao.saveRequest(r);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public List<RequestStatus> getRequestorList(String requestor) throws DBException, ServiceException {
		try {
			return dao.findByRequestorList(requestor);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<RequestStatus> getAcceptorList(String acceptor) throws DBException, ServiceException {
		try {
			return dao.findByAcceptorList(acceptor);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public void updateStatus(String requestor, String acceptor, String status) throws DBException, ServiceException {
		try {
			dao.updateStatus(requestor, acceptor, status);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

}
