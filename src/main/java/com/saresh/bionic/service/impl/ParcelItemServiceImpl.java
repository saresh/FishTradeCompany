package com.saresh.bionic.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.ParcelItemDao;
import com.saresh.bionic.entity.ParcelItem;
import com.saresh.bionic.service.ParcelItemService;

@Named
public class ParcelItemServiceImpl implements ParcelItemService {

	@Inject
	private ParcelItemDao parcelItemDao;
	
	@Override
	@Transactional
	public void save(ParcelItem parcelItem) {
		parcelItemDao.save(parcelItem);		
	}

	@Override
	public ParcelItem findById(int id) {
		return parcelItemDao.findById(id);
	}

	@Override
	public void updateQuantity(int id, int quantity) {
		parcelItemDao.updateQuantity(id, quantity);		
	}

	@Override
	public void remove(int id) {
		parcelItemDao.remove(id);
	}

}
