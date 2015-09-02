package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.entity.ProviderParcel;

public interface ProviderParcelService {
	
	public ProviderParcel findById(int id);
	
	public void save(ProviderParcel fishProvider);
	
	public List<ProviderParcel> findAll();
	
	public List<ProviderParcel> findAllExpected();
	
	public ProviderParcel findExpected(Provider provider);
}
