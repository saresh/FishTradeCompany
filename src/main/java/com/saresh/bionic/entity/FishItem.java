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
public class FishItem {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private int quantityBought;
	private int pricePaidFor;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "providerParcelId")
	private ProviderParcel providerParcel;
	private boolean avaliable;
	private boolean writeoff;
	
	@OneToMany(mappedBy = "fishItem")
	private List<ParcelItem> parcelItems = new ArrayList<ParcelItem>();
	
	public FishItem(){}	
	
	public void addQuantity(int quantity){
		this.quantity += quantity;
	}
	
	public void reduceQuantity(int quantity){
		this.quantity -= quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantityBought() {
		return quantityBought;
	}

	public void setQuantityBought(int quantityBought) {
		this.quantityBought = quantityBought;
	}

	public int getPricePaidFor() {
		return pricePaidFor;
	}

	public void setPricePaidFor(int pricePaidFor) {
		this.pricePaidFor = pricePaidFor;
	}

	public boolean isAvaliable() {
		return avaliable;
	}
	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	public boolean isWriteoff() {
		return writeoff;
	}
	public void setWriteoff(boolean writeoff) {
		this.writeoff = writeoff;
	}

	public ProviderParcel getProviderParcel() {
		return providerParcel;
	}

	public void setProviderParcel(ProviderParcel providerParcel) {
		this.providerParcel = providerParcel;
	}

	public List<ParcelItem> getParcelItems() {
		return parcelItems;
	}

	public void setParcelItems(List<ParcelItem> parcelItems) {
		this.parcelItems = parcelItems;
	}
	
	
	
	

}
