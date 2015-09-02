package com.saresh.bionic.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.ProviderDao;
import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.service.ProviderService;

@Named
public class ProviderServiceImpl implements ProviderService {

	@Inject
	private ProviderDao providerDao;
	
	@Override
	@Transactional
	public void save(Provider provider) {
		providerDao.save(provider);		
	}

	@Override
	public Provider findById(int id) {
		return providerDao.findById(id);
	}

	@Override
	public List<Provider> findAll() {		
		return providerDao.findAll();
	}

}
