package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.entity.ProviderParcel;

public interface ProviderParcelDao {

	public ProviderParcel findById(int id);
	
	public void save(ProviderParcel fishProvider);
	
	public List<ProviderParcel> findAll();
	
	public List<ProviderParcel> findAllExpected();
	
	public ProviderParcel findExpected(Provider provider);
}
