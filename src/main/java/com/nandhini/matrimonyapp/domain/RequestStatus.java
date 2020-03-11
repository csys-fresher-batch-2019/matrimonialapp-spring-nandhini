package com.nandhini.matrimonyapp.domain;

public class RequestStatus {
	private String requestor;
	private String acceptor;
	private String status;

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RequestStatus [requestor=" + requestor + ", acceptor=" + acceptor + ", status=" + status + "]";
	}

}
