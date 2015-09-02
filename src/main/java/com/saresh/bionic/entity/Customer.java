package com.saresh.bionic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private User user;
	private String name;
	private String surname;
	private String email;
	private java.sql.Date maturity;
	private String telephone;
	private int prepaymentPercent;
	
	@OneToMany(mappedBy = "customer")
	private List<Parcel> parcels;
	
	public Customer(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public java.sql.Date getMaturity() {
		return maturity;
	}
	public void setMaturity(java.sql.Date maturity) {
		this.maturity = maturity;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getPrepaymentPercent() {
		return prepaymentPercent;
	}

	public void setPrepaymentPercent(int prepaymentPercent) {
		this.prepaymentPercent = prepaymentPercent;
	}
	
}
