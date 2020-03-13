package com.nandhini.matrimonyapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nandhini.matrimonyapp.dao.AdminLoginDAO;
import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.domain.AdminLogin;
import com.nandhini.matrimonyapp.domain.Profiles;
import com.nandhini.matrimonyapp.dto.MessageDTO;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.factory.DAOFactory;

@RestController
@RequestMapping("api")
public class ProductController {
	@GetMapping("/Register")
	public MessageDTO register(@RequestParam("userName") String userName, @RequestParam("dob") LocalDate dob,
			@RequestParam("gender") String gender, @RequestParam("religion") String religion,
			@RequestParam("caste") String caste, @RequestParam("country") String country,
			@RequestParam("states") String states, @RequestParam("city") String city, @RequestParam("mobNo") Long mobNo,
			@RequestParam("aadharNo") Long aadharNo, @RequestParam("mailId") String mailId,
			@RequestParam("height") float height, @RequestParam("education") String education,
			@RequestParam("maritalStatus") String maritalStatus, @RequestParam("occupation") String occupation,
			@RequestParam("salary") int salary, @RequestParam("membershipType") String membershipType,
			@RequestParam("pass") String pass, @RequestParam("pic") String pic) throws Exception {
		MessageDTO msg = new MessageDTO();
		Profiles p = new Profiles();
		p.setUserName(userName);
		p.setDob(dob);
		p.setGender(gender);
		p.setMobNo(mobNo);
		p.setAadharNo(aadharNo);
		p.setCaste(caste);
		p.setState(states);
		p.setCity(city);
		p.setCountry(country);
		p.setReligion(religion);
		p.setSalary(salary);
		p.setMail(mailId);
		p.setHeight(height);
		p.setEducation(education);
		p.setMaritalSts(maritalStatus);
		p.setOccupation(occupation);
		p.setSalary(salary);
		p.setMembershipType(membershipType);
		p.setPass(pass);
		p.setPic(pic);
		ProfilesInterfaceDAO pi = DAOFactory.getProfilesInterfaceDAO();
		int a = pi.save(p);
		if (a == 1) {
			msg.setInfoMessage("Successfully Registered");
		} else {
			msg.setInfoMessage("Registeration Failed");
		}
		return msg;
	}

	@GetMapping("/searchbyname")
	public List<Profiles> getProfile(@RequestParam("userName") String userName) throws Exception {

		ProfilesInterfaceDAO pi = DAOFactory.getProfilesInterfaceDAO();
		List<Profiles> l = new ArrayList<Profiles>();
		l = pi.findByProfile(userName);
		return l;
	}

	@GetMapping("/adminlogin")
	public MessageDTO adminLogin(@RequestParam("userName") String userName, @RequestParam("pass") String pass) throws DBException {
		MessageDTO msg = new MessageDTO();
		AdminLogin a = new AdminLogin();
		a.setUserName(userName);
		a.setPassword(pass);
		AdminLoginDAO dao = DAOFactory.getAdminLoginDAO();
		String rst=dao.adminLogin(a);
		if (rst == "success") {
			msg.setInfoMessage("Login Success");
		} else {
			msg.setInfoMessage("Login Failed");
		}
		return msg;
	}
}
