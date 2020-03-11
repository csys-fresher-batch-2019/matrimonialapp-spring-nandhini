package com.nandhini.matrimonyapp.dao;

import java.util.List;

import com.nandhini.matrimonyapp.domain.MembershipDuration;
import com.nandhini.matrimonyapp.exception.DBException;

public interface MembershipDurationDAO {

	public List<MembershipDuration> findByMembershipDuration() throws DBException;

	public void saveMembershipDurationDetails(MembershipDuration md) throws DBException;

	public String[] updateExpiryDate(MembershipDuration md) throws DBException;

	public List<MembershipDuration> findByRemainingDays(int userId) throws DBException;

	public void calculateExpiryDuration(int userId, int mdplanId, int monthValidity) throws DBException;
}
