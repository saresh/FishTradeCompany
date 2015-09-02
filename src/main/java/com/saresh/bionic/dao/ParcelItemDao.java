package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.ParcelItem;

public interface ParcelItemDao {
	//Us # 2
	public void save(ParcelItem parcelItem);
	public ParcelItem findById(int id);
	
	public void updateQuantity(int id, int quantity);
	// Us # 3
	public void remove(int id);
	
	public List<ParcelItem> findAllParcelItems();
	
}
