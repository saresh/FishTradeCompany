package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.ProviderParcel;

public interface FishItemDao {
	
	public FishItem findById(int id);
	//Us # 6, 7
	public void save(FishItem fishItem);
	//Us # 8
	public void changeAvaliability(int id);
	//Us # 9
	public void updatePrice(int id, int price);	
	//Us # 13
	public void registerFishItemArrival(int id, int quantity);
	
	public void reduceFishItemQuantity(int id, int quantity);
	//Us # 10, 15	
	public void setAsWriteOff(int id);
	
	public List<FishItem> findAll();
	
	public List<FishItem> findAllExpected();
	
	public List<FishItem> findAllReceived();
	
	public List<FishItem> findFishAvaliableForSale();
	
	public List<FishItem> findExpected(ProviderParcel providerParcel);
	
	public List<FishItem> findWriteOffFishItems();
}
