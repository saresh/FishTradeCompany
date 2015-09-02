package com.saresh.bionic.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "parcelId")
	private Parcel parcel;
	private int amount;
	private java.sql.Date paymentDate;
	@ManyToOne
	@JoinColumn(name = "staffAcceptedId")
	private Staff staffAccepted;	
	
	public Payment(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Staff getStaffAccepted() {
		return staffAccepted;
	}

	public void setStaffAccepted(Staff staffAccepted) {
		this.staffAccepted = staffAccepted;
	}

	public java.sql.Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.sql.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}
	
	
	
	
}
