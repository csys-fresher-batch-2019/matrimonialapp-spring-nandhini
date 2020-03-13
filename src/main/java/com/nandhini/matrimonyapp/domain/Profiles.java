package com.nandhini.matrimonyapp.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.Date;

public class Profiles {
	private int userId;
	private String userName;
	private LocalDate dob;
	private String gender;
	private String religion;
	private String caste;
	private String country;
	private String state;
	private String city;
	private Long mobNo;
	private Long aadharNo;
	private String mail;
	private double height;
	private String education;
	private LocalDateTime registerdDate= LocalDateTime.now();
	private String maritalSts;
	private String occupation;
	private int salary;
	private String membershipType;
	private String pass;
	private int active = 1;
	private String pic;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob2) {
		this.dob = dob2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobNo() {
		return mobNo;
	}

	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public LocalDateTime getRegisterdDate() {
		return registerdDate;
	}

	public void setRegisterdDate(LocalDateTime registerdDate) {
		this.registerdDate = registerdDate;
	}

	public String getMaritalSts() {
		return maritalSts;
	}

	public void setMaritalSts(String maritalSts) {
		this.maritalSts = maritalSts;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Profiles [userId=" + userId + ", userName=" + userName + ", dob=" + dob + ", gender=" + gender
				+ ", religion=" + religion + ", caste=" + caste + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", mobNo=" + mobNo + ", aadharNo=" + aadharNo + ", mail=" + mail + ", height="
				+ height + ", education=" + education + ", registerdDate=" + registerdDate + ", maritalSts="
				+ maritalSts + ", occupation=" + occupation + ", salary=" + salary + ", membershipType="
				+ membershipType + ", pass=" + pass + ", active=" + active + ", pic=" + pic + "]";
	}

	
}
