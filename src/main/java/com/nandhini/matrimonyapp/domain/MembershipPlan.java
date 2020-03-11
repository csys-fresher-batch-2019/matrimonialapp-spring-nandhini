package com.nandhini.matrimonyapp.domain;

import java.sql.Date;

public class MembershipPlan {
	private int planId;
	private String membershipType;
	private int totalMonths;
	private int amount;
	private String userName;
	private Date registerdDate;
	private Date expiryDate;
	private int userId;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public int getTotalMonths() {
		return totalMonths;
	}

	public void setTotalMonths(int totalMonths) {
		this.totalMonths = totalMonths;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegisterdDate() {
		return registerdDate;
	}

	public void setRegisterdDate(Date registerdDate) {
		this.registerdDate = registerdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MembershipPlan [planId=" + planId + ", membershipType=" + membershipType + ", totalMonths="
				+ totalMonths + ", amount=" + amount + ", userName=" + userName + ", registerdDate=" + registerdDate
				+ ", expiryDate=" + expiryDate + ", userId=" + userId + "]";
	}

}
