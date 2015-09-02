package com.saresh.bionic.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.FishItemDao;
import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.ProviderParcel;
import com.saresh.bionic.service.FishItemService;

@Named
public class FishItemServiceImpl implements FishItemService{
	
	@Inject
	private FishItemDao fishItemDao;

	@Override
	public FishItem findById(int id) {
		return fishItemDao.findById(id);
	}

	@Override
	@Transactional
	public void save(FishItem fishItem) {
		fishItemDao.save(fishItem);
	}

	@Override
	@Transactional
	public void changeAvaliability(int id) {
		fishItemDao.changeAvaliability(id);
	}

	@Override
	@Transactional
	public void updatePrice(int id, int price) {
		fishItemDao.updatePrice(id, price);
	}

		
	@Override
	@Transactional
	public void reduceFishItemQuantity(int id, int quantity) {
		fishItemDao.reduceFishItemQuantity(id, quantity);		
	}

	@Override
	@Transactional
	public void setAsWriteOff(int id) {
		fishItemDao.setAsWriteOff(id);		
	}

	@Override
	@Transactional
	public void registerFishItemArrival(int id, int quantity) {
		fishItemDao.registerFishItemArrival(id, quantity);
	}

	@Override
	public List<FishItem> findFishAvaliableForSale() {
		return fishItemDao.findFishAvaliableForSale();
	}

	@Override
	public List<FishItem> findAll() {
		return fishItemDao.findAll();
	}

	@Override
	public List<FishItem> findAllExpected() {
		return fishItemDao.findAllExpected();
	}

	@Override
	public List<FishItem> findAllReceived() {
		return fishItemDao.findAllReceived();
	}

	@Override
	public List<FishItem> findExpected(ProviderParcel providerParcel) {
		return fishItemDao.findExpected(providerParcel);
	}

	@Override
	public List<FishItem> findWriteOffFishItems() {
		return fishItemDao.findWriteOffFishItems();
	}

}
