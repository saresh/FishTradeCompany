package com.saresh.bionic.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.CustomerService;
import com.saresh.bionic.service.UserService;

@Named
@Scope("session")
public class CustomerLoginBean implements Serializable {
		private static final long serialVersionUID = 6008295829972017696L;
	
	private String username;
	private String password;
	private User user;
	private Customer customer;
	
	@Inject
	UserService userService;
	@Inject
	CustomerService customerService;
	
	public CustomerLoginBean(){}
	
	public String validate(){
		boolean valid = userService.validateCustomer(username, password);
		
		if(valid){
			user = userService.find(username, password);
			customer = customerService.findByUser(user);
			return "/customer/fishForSale";
		} else {
			return "/customer/customerLogin";
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
