package com.nandhini.matrimonyapp.dao;

import java.util.List;

import com.nandhini.matrimonyapp.domain.MembershipPlan;
import com.nandhini.matrimonyapp.exception.DBException;

public interface MembershipPlanInterfaceDAO {

	public List<MembershipPlan> findByMembershipPlan() throws DBException;

	public void updatePlan(int amount, int planId) throws DBException;

	public List<MembershipPlan> findByExpiryDate() throws DBException;

}
