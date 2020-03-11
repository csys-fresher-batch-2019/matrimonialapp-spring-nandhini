package com.nandhini.matrimonyapp.dao;

import java.util.List;

import com.nandhini.matrimonyapp.domain.Profiles;
import com.nandhini.matrimonyapp.exception.DBException;

public interface ProfilesInterfaceDAO {

	public List<Profiles> findByProfile(String userName) throws DBException;

	public String updatePassword(String userEmail, String pass, String userpassword) throws DBException;

	public List<Profiles> findByGender(String gender) throws DBException;

	public List<Profiles> findByHeight(double height, String gender) throws DBException;

	public List<Profiles> findBySalary(int salary, String gender) throws DBException;

	public List<Profiles> findByOccupation(String gender, String occupation) throws DBException;

	public List<Profiles> findByNotInOccupation(String gender, String occupation) throws DBException;

	public List<Profiles> findByCity(String gender, String city) throws DBException;

	public int save(Profiles p) throws DBException;

	public String updateProfiles(String occupation, int salary, String userName, Long mobNo) throws DBException;

	public void updateActive(int userId, int active) throws DBException;

	public String userLogin(String mail, String pass) throws DBException;

	public List<Profiles> findByReligion(String gender, String religion) throws DBException;

	public List<Profiles> findByFullProfile() throws DBException;

}
