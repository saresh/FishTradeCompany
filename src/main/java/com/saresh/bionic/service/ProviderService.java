package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.Provider;

public interface ProviderService {
	public void save(Provider provider);
	
	public Provider findById(int id);
	
	public List<Provider> findAll();
	
}
