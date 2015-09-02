package com.saresh.bionic.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.ProviderParcelDao;
import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.entity.ProviderParcel;
import com.saresh.bionic.service.ProviderParcelService;

@Named
public class ProviderParcelServiceImpl implements ProviderParcelService {
	
	@Inject
	private ProviderParcelDao providerParcelDao;

	@Override
	public ProviderParcel findById(int id) {
		return providerParcelDao.findById(id);
	}

	@Override
	@Transactional
	public void save(ProviderParcel fishProvider) {
		providerParcelDao.save(fishProvider);		
	}

	@Override
	public List<ProviderParcel> findAll() {
		return providerParcelDao.findAll();
	}

	@Override
	public List<ProviderParcel> findAllExpected() {
		return providerParcelDao.findAllExpected();
	}

	@Override
	public ProviderParcel findExpected(Provider provider) {		
		return providerParcelDao.findExpected(provider);
	}
	
	
}
