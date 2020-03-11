package com.nandhini.matrimonyapp.domain;

public class MembershipDuration {
	private int memberId;
	private int mdUserId;
	private int mdPlanId;
	private String expiryDate;
	private int monthValidity;
	private int remainingDays;
	private String userName;
	private int UserId;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMdUserId() {
		return mdUserId;
	}

	public void setMdUserId(int mdUserId) {
		this.mdUserId = mdUserId;
	}

	public int getMdPlanId() {
		return mdPlanId;
	}

	public void setMdPlanId(int mdPlanId) {
		this.mdPlanId = mdPlanId;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getMonthValidity() {
		return monthValidity;
	}

	public void setMonthValidity(int monthValidity) {
		this.monthValidity = monthValidity;
	}

	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

}
