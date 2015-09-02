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
public class ProviderParcel {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "providerId")
	private Provider provider;
	private java.sql.Date deliveryDate;
	
	@OneToMany(mappedBy = "providerParcel")
	private List<FishItem> fishItems = new ArrayList<FishItem>();
	
	public void addFishItem(FishItem fi){
		fishItems.add(fi);
		fi.setProviderParcel(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public java.sql.Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(java.sql.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
}
