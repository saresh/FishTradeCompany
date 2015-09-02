package com.saresh.bionic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParcelItem {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@ManyToOne
	@JoinColumn(name = "parcelId")
	private Parcel parcel;
	@ManyToOne
	@JoinColumn(name = "fishItemId")
	private FishItem fishItem;
	private int quantity;
	private int price;
	
	public ParcelItem(){}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}
	
	public FishItem getFishItem() {
		return fishItem;
	}

	public void setFishItem(FishItem fishItem) {
		this.fishItem = fishItem;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
