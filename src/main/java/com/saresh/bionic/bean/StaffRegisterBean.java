package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.StaffService;
import com.saresh.bionic.service.UserService;

@Named
@Scope("request")
public class StaffRegisterBean implements Serializable{
	
	private static final long serialVersionUID = 3013304448919033989L;
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String staffRole;
	private java.util.Date maturity;
	private String telephone;
	
	private Map<String,String> staffRoles = new HashMap<String, String>();
	
	public StaffRegisterBean() {
		staffRoles.put("General manager", "General manager");
		staffRoles.put("Cold store manager", "Cold store manager");
		staffRoles.put("Accountant", "Accountant");
	}
	
	@Inject
	private UserService userService;
	@Inject
	private StaffService staffSevice;
	
	public String registerStaff(){
		if (userService.checkAvaliability(username, password)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setUserType("Staff");
			
			Staff staff = new Staff();
			staff.setName(name);
			staff.setSurname(surname);
			staff.setEmail(email);
			staff.setTelephone(telephone);
			staff.setStaffRole(staffRole);
			staff.setMaturity(new java.sql.Date(maturity.getTime()));
			staff.setActive(false);
			
			staff.setUser(user);
			
			staffSevice.save(staff);
						
			return "/staff/staffHome";
		} else {
			return "/so/registerStaffAccount";
		}			
	}	
	
	public String getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getMaturity() {
		return maturity;
	}
	public void setMaturity(java.util.Date maturity) {
		this.maturity = maturity;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Map<String, String> getStaffRoles() {
		return staffRoles;
	}

	public void setStaffRoles(Map<String, String> staffRoles) {
		this.staffRoles = staffRoles;
	}
	
	
	
	

}
