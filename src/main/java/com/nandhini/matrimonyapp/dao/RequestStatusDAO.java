package com.nandhini.matrimonyapp.dao;

import java.util.List;

import com.nandhini.matrimonyapp.domain.RequestStatus;
import com.nandhini.matrimonyapp.exception.DBException;

public interface RequestStatusDAO {

	public void saveRequest(RequestStatus r) throws DBException;

	public List<RequestStatus> findByRequestorList(String requestor) throws DBException;

	public List<RequestStatus> findByAcceptorList(String acceptor) throws DBException;

	public void updateStatus(String requestor, String acceptor, String status) throws DBException;

}
