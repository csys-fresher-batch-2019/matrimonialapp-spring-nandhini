 package com.nandhini.matrimonyapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import com.nandhini.matrimonyapp.controller.IndexController;
import com.nandhini.matrimonyapp.dao.ProfilesInterfaceDAO;
import com.nandhini.matrimonyapp.domain.Profiles;
import com.nandhini.matrimonyapp.exception.DBException;
import com.nandhini.matrimonyapp.exception.ErrorConstant;
import com.nandhini.matrimonyapp.util.ConnectionUtil;

public class ProfilesImpl implements ProfilesInterfaceDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public List<Profiles> findByProfile(String userName) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where lower(user_name)=lower(?) and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userName1 = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic = rs.getString("pic");
				Profiles p = new Profiles();
				p.setUserName(userName1);
				p.setDob(dob);
				p.setGender(gender);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setPic(pic);
				list.add(p);

				// file Write
				/*
				 * String result="Name= "+user_name+"\n"+"DOB= "+dob+"\n"+"Gender= "+gender+
				 * "\n"+"Religion= "+religion+"\n"+"Height= "+height+"\n"+"Education= "
				 * +education+"\n"+
				 * "Occupation= "+occupation+"\n"+"Salary= "+salary+"\n"+"Marital Status="
				 * +marital_sts; FileUtil.WriteToFile("ProfilePrint.txt", result);
				 * LOGGER.debug("Write Successfully");
				 * 
				 * //file Read String pro="ProfilePrint.txt"; Path path=Paths.get(pro);
				 * 
				 * byte[] bytes=Files.readAllBytes(path); String content=new String(bytes);
				 * LOGGER.debug(content);
				 */
				// LOGGER.debug("Read successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;
	}

	public List<Profiles> findByGender(String gender) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where gender=? and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, gender);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic = rs.getString("pic");
				Long mobNo = rs.getLong("mob_no");
				String caste = rs.getString("caste");
				Profiles p = new Profiles();
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public List<Profiles> findByCity(String gender, String city) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where gender=? and lower(city)=lower(?) and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, gender);
			ps.setString(2, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city1 = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic1 = rs.getString("pic");
				Profiles p = new Profiles();
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city1);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setPic(pic1);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Profiles> findByHeight(double height, String gender) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where height >=? and gender=? and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, height);
			ps.setString(2, gender);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic = rs.getString("pic");
				Long mobNo = rs.getLong("mob_no");
				String caste = rs.getString("caste");
				Profiles p = new Profiles();
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public List<Profiles> findBySalary(int salary, String gender) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where salary>=? and gender=? and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, salary);
			ps.setString(2, gender);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary1 = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic = rs.getString("pic");
				Long mobNo = rs.getLong("mob_no");
				String caste = rs.getString("caste");
				Profiles p = new Profiles();
				p.setCaste(caste);
				p.setPic(pic);
				p.setMobNo(mobNo);
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary1);
				p.setMaritalSts(marital_sts);
				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}
	// List the bridegroom list with the specific occupation

	public List<Profiles> findByOccupation(String gender, String occupation) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where gender=? and lower(occupation) =lower(?) and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, gender);
			ps.setString(2, occupation);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation1 = rs.getString("occupation");
				int salary1 = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic1 = rs.getString("pic");
				Profiles p = new Profiles();
				p.setUserName(user_name);
				p.setPic(pic1);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation1);
				p.setSalary(salary1);
				p.setMaritalSts(marital_sts);
				p.setPic(pic1);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public List<Profiles> findByNotInOccupation(String gender, String occupation) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where gender=? and lower(occupation) not in lower(?) and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, gender);
			ps.setString(2, occupation);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height1 = rs.getInt("height");
				String education = rs.getString("education");
				String occupation1 = rs.getString("occupation");
				int salary1 = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic = rs.getString("pic");
				Long mobNo = rs.getLong("mob_no");
				Profiles p = new Profiles();
				// p.setUserName(rs.getString("user_name"));
				p.setUserName(userName);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height1);
				p.setEducation(education);
				p.setOccupation(occupation1);
				p.setSalary(salary1);
				p.setMaritalSts(marital_sts);
				p.setPic(pic);
				p.setMobNo(mobNo);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	public int save(Profiles p) throws DBException {
		int msg = 0;
		try (Connection con = ConnectionUtil.getConnect()) {
			String sql = "insert into profiles(user_id,user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,membership_type,pass,pic)"
					+ "values(user_id_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getUserName());
			ps.setDate(2, Date.valueOf(p.getDob()));
			ps.setString(3, p.getGender());
			ps.setString(4, p.getReligion());
			ps.setString(5, p.getCaste());
			ps.setString(6, p.getCountry());
			ps.setString(7, p.getState());
			ps.setString(8, p.getCity());
			ps.setLong(9, p.getMobNo());
			ps.setLong(10, p.getAadharNo());
			ps.setString(11, p.getMail());
			ps.setDouble(12, p.getHeight());
			ps.setString(13, p.getEducation());
			ps.setString(14, p.getOccupation());
			ps.setInt(15, p.getSalary());
			ps.setString(16, p.getMaritalSts());
			ps.setString(17, p.getMembershipType());
			ps.setString(18, p.getPass());
			ps.setString(19, p.getPic());
			int row = ps.executeUpdate();
			Logger.debug(row + " row inserted");
			if (row == 1) {
				msg = 1;
			} else {
				msg = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
		return msg;
	}

	public String updateProfiles(String occupation, int salary, String userName, Long mobNo) throws DBException {
		String msg = null;
		String sql = "update profiles set occupation=?,salary=? where user_name=? and  mob_no=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, occupation);
			ps.setInt(2, salary);
			ps.setString(3, userName);
			ps.setLong(4, mobNo);
			int row = ps.executeUpdate();
			Logger.debug("" + row);
			if (row == 1) {
				Logger.debug("Updated Success");
				msg = "success";
			} else {
				Logger.debug("Update Fail");
				msg = "fail";
			}
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public void updateActive(int userId, int active) throws DBException {
		String sql = "update profiles  set active =? where user_id=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, active);
			ps.setInt(2, userId);

			int row = ps.executeUpdate();
			Logger.debug("" + row);
			Logger.debug("Updated Success");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

	}

	public List<Profiles> findByReligion(String gender, String religion) throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		int active = 1;
		String sql = "select user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,pic from profiles where gender=? and lower(religion)=lower(?) and active=" + active;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, gender);
			ps.setString(2, religion);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion1 = rs.getString("religion");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String pic = rs.getString("pic");
				Long mobNo = rs.getLong("mob_no");
				String caste = rs.getString("caste");
				Profiles p = new Profiles();
				p.setCaste(caste);
				p.setDob(dob);
				p.setPic(pic);
				p.setMobNo(mobNo);
				p.setUserName(user_name);
				p.setGender(gender1);
				p.setReligion(religion1);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Profiles> findByFullProfile() throws DBException {
		List<Profiles> list = new ArrayList<Profiles>();
		String sql = "select user_id,user_name,d_o_b,gender,religion,caste,country,states,city,mob_no,aadhar_no,mail_id,height,education,occupation,salary,marital_sts,membership_type,pass,active,pic from profiles";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				LocalDate dob = rs.getDate("d_o_b").toLocalDate();
				String gender1 = rs.getString("gender");
				String religion1 = rs.getString("religion");
				String caste = rs.getString("caste");
				String country = rs.getString("country");
				String state = rs.getString("states");
				String city = rs.getString("city");
				Long mobNo = rs.getLong("mob_no");
				Long aadharNo = rs.getLong("aadhar_no");
				String mail = rs.getString("mail_id");
				int height = rs.getInt("height");
				String education = rs.getString("education");
				//LocalDateTime registerdDate = rs.getTimestamp("registerdDate").toLocalDateTime();
				String occupation = rs.getString("occupation");
				int salary = rs.getInt("salary");
				String marital_sts = rs.getString("marital_sts");
				String membershipType = rs.getString("membership_type");
				String pass = rs.getString("pass");
				int active = rs.getInt("active");
				String pic = rs.getString("pic");
				
				Profiles p = new Profiles();
				p.setUserId(userId);
				p.setUserName(user_name);
				p.setDob(dob);
				p.setGender(gender1);
				p.setReligion(religion1);
				p.setCaste(caste);
				p.setCountry(country);
				p.setState(state);
				p.setCity(city);
				p.setMobNo(mobNo);
				p.setAadharNo(aadharNo);
				p.setMail(mail);
				p.setHeight(height);
				p.setEducation(education);
				//p.setRegisterdDate(registerdDate);
				p.setOccupation(occupation);
				p.setSalary(salary);
				p.setMaritalSts(marital_sts);
				p.setMembershipType(membershipType);
				p.setPass(pass);
				p.setActive(active);
				p.setPic(pic);
				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public String userLogin(String mail, String pass) throws DBException {
		String sql = "select mail_id,pass from profiles where mail_id=? and pass=?";
		String msg = null;
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mail);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String mail1 = rs.getString("mail_id");
				String password1 = rs.getString("pass");
				if (mail1.equals(mail) && password1.equals(pass))

					Logger.debug("Logged In...");
				msg = "success";
			} else {
				Logger.debug("Invalid EmailId/Password");
				msg = "fail";
			}
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

	}

	public String updatePassword(String userEmail, String pass, String userpassword) throws DBException {
		String msg = null;
		String sql = "update profiles set pass=? where mail_id=? and pass=?";
		try (Connection con = ConnectionUtil.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, userpassword);
			ps.setString(2, userEmail);
			ps.setString(3, pass);
			int row = ps.executeUpdate();
			Logger.debug("" + row);
			if (row == 1) {
				Logger.debug("Updated Success");
				msg = "success";
			} else {
				Logger.debug("Invalid EmailId/Password");
				msg = "fail";
			}
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}

	}

}

/*
 * create table profiles ( user_id number, user_name varchar2(50) not null,
 * d_o_b date not null, gender char(1)not null, religion varchar2(50)not null,
 * caste varchar2(50), country varchar2(50)not null, mob_no number not null,
 * height number , education varchar2(30), constraint user_id_pk primary
 * key(user_id), constraint gender_cq check(gender in ('M','F')) ); Query alter
 * table profiles add( registerd_date date default sysdate, marital_sts
 * varchar2(20)not null, occupation varchar2(20), salary number, constraint
 * marital_sts_cq check(marital_sts in
 * ('unmarried','widow','widower','divorced')) );
 */