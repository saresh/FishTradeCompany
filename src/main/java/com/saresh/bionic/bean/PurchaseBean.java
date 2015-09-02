package com.saresh.bionic.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.entity.ParcelItem;
import com.saresh.bionic.service.FishItemService;
import com.saresh.bionic.service.ParcelService;

@Named
@Scope("session")
public class PurchaseBean implements Serializable {
	private static final long serialVersionUID = -4757768773858458484L;
	
	private int quantitySelected;
	private int totalWeight;
	private int totalPrice;
	
	private List<FishItem> fishList = null;
	
	private List<ParcelItem> cart = new ArrayList<ParcelItem>(); 
	
	private ParcelItem itemToEdit = null;
	
	@Inject
	private FishItemService fishItemService;
	@Inject
	private ParcelService parcelService;

	public String addToCart(String fishItemId){
		int fishId = Integer.parseInt(fishItemId);		
		FishItem fi = fishItemService.findById(fishId);
		
		ParcelItem pi = new ParcelItem();
		pi.setFishItem(fi);
		pi.setQuantity(quantitySelected);
		pi.setPrice(fi.getPrice());
		
		cart.add(pi);
		
		quantitySelected = 0;
		updateTotalPrice();
		updateTotalWeight();
		
		return "/customer/fishForSale";
	}		
	
	public String removeFromCart(ParcelItem pi){
				
		cart.remove(pi);
		updateTotalPrice();
		updateTotalWeight();
		
		return "/customer/cart";
	}
	
	public String editCartItem(ParcelItem pi){
		itemToEdit = pi;		
		return "/customer/editCartItem";
	}
	
	public String updateCartItem(){
		updateTotalPrice();
		updateTotalWeight();
		return "/customer/cart";
	}
	
	public String sendOrder(Customer customer){
		Parcel parcel = new Parcel();
		parcel.setCustomer(customer);
		parcel.setOrderDate(new Date(Calendar.getInstance().getTimeInMillis()));
		parcel.setStatus("Client created order");
		
		parcelService.save(parcel, cart);	
		
		cart.clear();
		updateTotalPrice();
		updateTotalWeight();
		
		return "/customer/fishForSale";
	}

	public void updateTotalPrice(){
		int result = 0;
		for (ParcelItem pi : cart){
			result += pi.getQuantity() * pi.getPrice();
		}
		totalPrice = result;
	}
	
	public void updateTotalWeight(){
		int result = 0;
		for (ParcelItem pi : cart){
			result += pi.getQuantity();
		}
		totalWeight = result;
	}
	
	public void updateFishList(){
		fishList = fishItemService.findFishAvaliableForSale();
	}
	
	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getQuantitySelected() {
		return quantitySelected;
	}
	
	public void setQuantitySelected(int quantitySelected) {
		this.quantitySelected = quantitySelected;
	}

	public List<FishItem> getFishList() {
		return fishList;
	}

	public void setFishList(List<FishItem> fishList) {
		this.fishList = fishList;
	}

	public List<ParcelItem> getCart() {
		return cart;
	}

	public void setCart(List<ParcelItem> cart) {
		this.cart = cart;
	}

	public ParcelItem getItemToEdit() {
		return itemToEdit;
	}

	public void setItemToEdit(ParcelItem itemToEdit) {
		this.itemToEdit = itemToEdit;
	}
	
	
	

}
