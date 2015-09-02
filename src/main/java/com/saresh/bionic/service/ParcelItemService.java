package com.saresh.bionic.service;

import com.saresh.bionic.entity.ParcelItem;

public interface ParcelItemService {
	
		public void save(ParcelItem parcelItem);
		public ParcelItem findById(int id);
		
		public void updateQuantity(int id, int quantity);
		
		public void remove(int id);
}
