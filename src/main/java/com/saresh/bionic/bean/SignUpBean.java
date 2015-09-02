package com.saresh.bionic.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.CustomerService;
import com.saresh.bionic.service.UserService;

@Named
@Scope("request")
public class SignUpBean implements Serializable {

	private static final long serialVersionUID = 4209717421184141437L;

	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private java.util.Date maturity;
	private String telephone;

	@Inject
	private CustomerService customerService;
	@Inject
	private UserService userService;

	public String signUp() {
		if (userService.checkAvaliability(username, password)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setUserType("Customer");

			Customer customer = new Customer();
			customer.setName(name);
			customer.setSurname(surname);
			customer.setEmail(email);
			customer.setTelephone(telephone);
			customer.setMaturity(new java.sql.Date(maturity.getTime()));
			customer.setUser(user);
			customer.setPrepaymentPercent(100);

			customerService.save(customer);
			
			return "/customer/customerLogin";
		} else {
			return "/customer/signup";
		}		
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

}
