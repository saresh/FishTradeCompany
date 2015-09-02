package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.ProviderParcel;

public interface FishItemService {
	public FishItem findById(int id);
	
	public void save(FishItem fishItem);
	
	public void changeAvaliability(int id);
	
	public void updatePrice(int id, int price);
	
	public void reduceFishItemQuantity(int id, int quantity);
	
	public void setAsWriteOff(int id);
	
	public void registerFishItemArrival(int id, int quantity);
	
	public List<FishItem> findFishAvaliableForSale();
	
	public List<FishItem> findAllExpected();
	
	public List<FishItem> findAllReceived();	
	
	public List<FishItem> findAll();
	
	public List<FishItem> findExpected(ProviderParcel providerParcel);
	

	public List<FishItem> findWriteOffFishItems();
	
}
