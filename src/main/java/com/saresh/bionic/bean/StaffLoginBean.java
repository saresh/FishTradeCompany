package com.saresh.bionic.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.StaffService;
import com.saresh.bionic.service.UserService;

@Named
@Scope("session")
public class StaffLoginBean implements Serializable {
	private static final long serialVersionUID = -8211129648300901783L;
	
	private String username;
	private String password;
	private User user;
	private Staff staff;
	
	@Inject
	UserService userService;
	@Inject
	StaffService staffService;
	
	public String validate(){
		boolean valid = userService.validateStaff(username, password);	
				
		if(valid && staffService.findByUser(userService.find(username, password)).isActive()){
			user = userService.find(username, password);
			staff = staffService.findByUser(user);
			return "/staff/staffHome";
		} else {
			return "/staff/staffLogin";
		}		
	}
	
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();		
		return "/customer/fishForSale";
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	

}
