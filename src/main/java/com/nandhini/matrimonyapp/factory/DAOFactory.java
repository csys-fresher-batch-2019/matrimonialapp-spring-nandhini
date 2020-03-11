package com.nandhini.matrimonyapp.factory;

import com.nandhini.matrimonyapp.dao.AdminLoginDAO;
import com.nandhini.matrimonyapp.dao.MembershipDurationDAO;
import com.nandhini.matrimonyapp.dao.MembershipPlanInterfaceDAO;
import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.dao.RequestStatusDAO;
import com.nandhini.matrimonyapp.dao.impl.AdminLoginImpl;
import com.nandhini.matrimonyapp.dao.impl.MembershipDurationImpl;
import com.nandhini.matrimonyapp.dao.impl.MembershipPlanImpl;
import com.nandhini.matrimonyapp.dao.impl.ProfilesImpl;
import com.nandhini.matrimonyapp.dao.impl.RequestStatusImpl;

public class DAOFactory {
	public static AdminLoginDAO getAdminLoginDAO() {
		return new AdminLoginImpl();
	}

	public static MembershipDurationDAO getMembershipDurationDAO() {
		return new MembershipDurationImpl();
	}

	public static MembershipPlanInterfaceDAO getMembershipPlanInterfaceDAO() {
		return new MembershipPlanImpl();
	}

	public static ProfilesInterfaceDAO getProfilesInterfaceDAO() {
		return new ProfilesImpl();
	}

	public static RequestStatusDAO getRequestStatusDAO() {
		return new RequestStatusImpl();
	}

}
