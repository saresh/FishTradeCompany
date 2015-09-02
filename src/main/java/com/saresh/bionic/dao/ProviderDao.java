package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.Provider;

public interface ProviderDao {
	public void save(Provider provider);
	
	public Provider findById(int id);
	
	public List<Provider> findAll();

}
