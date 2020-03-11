package com.nandhini.matrimonyapp.service;

import java.util.List;

import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.domain.Profiles;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ServiceConstant;
import com.nandhini.matrimonyapp.exception.ServiceException;
import com.nandhini.matrimonyapp.factory.DAOFactory;

public class ProfilesService {
	ProfilesInterfaceDAO dao = DAOFactory.getProfilesInterfaceDAO();

	public List<Profiles> getProfile(String userName) throws DBException, ServiceException {
		try {
			return dao.findByProfile(userName);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public String changePassword(String userEmail, String pass, String userpassword)
			throws DBException, ServiceException {
		try {
			return dao.updatePassword(userEmail, pass, userpassword);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public List<Profiles> getGenderProfile(String gender) throws DBException, ServiceException {
		try {
			return dao.findByGender(gender);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Profiles> getHeight(double height, String gender) throws DBException, ServiceException {
		try {
			return dao.findByHeight(height, gender);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Profiles> getSalaryDetails(int salary, String gender) throws DBException, ServiceException {
		try {
			return dao.findBySalary(salary, gender);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Profiles> getOccupation(String gender, String occupation) throws DBException, ServiceException {
		try {
			return dao.findByOccupation(gender, occupation);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Profiles> getNotInOccupation(String gender, String occupation) throws DBException, ServiceException {
		try {
			return dao.findByNotInOccupation(gender, occupation);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Profiles> getCityProfile(String gender, String city) throws DBException, ServiceException {
		try {
			return dao.findByNotInOccupation(gender, city);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public int save(Profiles p) throws DBException, ServiceException {
		try {
			return dao.save(p);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public String updateProfiles(String occupation, int salary, String userName, Long mobNo)
			throws DBException, ServiceException {
		try {
			return dao.updateProfiles(occupation, salary, userName, mobNo);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public void updateActive(int userId, int active) throws DBException, ServiceException {
		try {
			dao.updateActive(userId, active);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public String userLogin(String mail, String pass) throws DBException, ServiceException {
		try {
			return dao.userLogin(mail, pass);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public List<Profiles> getReligion(String gender, String religion) throws DBException, ServiceException {
		try {
			return dao.findByReligion(gender, religion);
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public List<Profiles> getFullProfile() throws DBException, ServiceException {
		try {
			return dao.findByFullProfile();
		} catch (DBException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

}
