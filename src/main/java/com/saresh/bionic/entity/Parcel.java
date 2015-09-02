package com.saresh.bionic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Parcel {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private String status;
	private java.sql.Date orderDate;
	private java.sql.Date shippingDate;
	
	@OneToMany(mappedBy = "parcel", cascade = CascadeType.ALL)
	private List<ParcelItem> parcelItems = new ArrayList<ParcelItem>();
	
	@OneToMany(mappedBy = "Parcel", cascade = CascadeType.PERSIST)
	private List<Payment> payments = new ArrayList<Payment>();
	
	public Parcel(){}
	
	public int getTotalWeight(){
		int result = 0;
		
		if (!parcelItems.isEmpty()){
			for (ParcelItem pi : parcelItems){
				result += pi.getQuantity();
			}
		} 
		
		return result;
	}
	
	public int getTotalPrice(){
		int result = 0;
		
		if (!parcelItems.isEmpty()){
			for (ParcelItem pi : parcelItems){
				result += pi.getPrice() * pi.getQuantity();
			}
		} 
		
		return result;
	}
	
	public int getTotalPaymentsAmount(){
		int result = 0;
		
		if (!payments.isEmpty()){
			for (Payment p : payments){
				result += p.getAmount();
			}
		}
		
		return result;		
	}	
	
	public int getPrepaymentAmount(){
		return customer.getPrepaymentPercent() * getTotalPrice() / 100 ;
	}
	
	public void addPayment(Payment p){
		payments.add(p);
		p.setParcel(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ParcelItem> getParcelItems() {
		return parcelItems;
	}

	public void setParcelItems(List<ParcelItem> parcelItems) {
		this.parcelItems = parcelItems;
	}
	
	public void addParcelItem(ParcelItem parcelItem){
		this.parcelItems.add(parcelItem);
		parcelItem.setParcel(this);
	}

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public java.sql.Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(java.sql.Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	
	
	
}
