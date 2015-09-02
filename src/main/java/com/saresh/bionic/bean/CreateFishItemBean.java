package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.entity.ProviderParcel;
import com.saresh.bionic.service.FishItemService;
import com.saresh.bionic.service.ProviderParcelService;
import com.saresh.bionic.service.ProviderService;

@Named
@Scope("session")
public class CreateFishItemBean implements Serializable {
	
	private static final long serialVersionUID = 2252464777286348860L;
	
	private FishItem fishItem;
	private String providerId;
	private Map<String, String> providersList = new HashMap<String, String>();
	
	private Provider newProvider = new Provider();
	
	@Inject
	FishItemService fishItemService;
	@Inject
	ProviderService providerService;
	@Inject
	ProviderParcelService providerParcelService;
	
		
	public CreateFishItemBean(){
		clearFishItem();				
	}
	
	public void clearFishItem(){
		fishItem = new FishItem();
		fishItem.setAvaliable(false);
		fishItem.setWriteoff(false);
	}
	
	public void updateProvidersList(){
		String key;
		String value;
		for(Provider p : providerService.findAll()){
			value = p.getId() + "";
			key = p.getName();
			
			providersList.put(key, value);
		}
	}
	
	public String registerFishItem(){
		int pId = Integer.parseInt(providerId);
		Provider p = providerService.findById(pId);		
		
		ProviderParcel pp;
		if ((pp = providerParcelService.findExpected(p)) == null){
			pp = new ProviderParcel();
			pp.addFishItem(fishItem);		
			p.addParcel(pp);			
			providerService.save(p);
		} else {
			pp.addFishItem(fishItem);
			providerParcelService.save(pp);
		}					
		
		clearFishItem();
		
		return "/gm/newFishItem";
	}
	
	public String registerProvider(){
		providerService.save(newProvider);
		
		return "/gm/newFishItem";
	}
	
	public FishItem getFishItem() {
		return fishItem;
	}

	public void setFishItem(FishItem fishItem) {
		this.fishItem = fishItem;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Map<String, String> getProvidersList() {
		return providersList;
	}

	public void setProvidersList(Map<String, String> providersList) {
		this.providersList = providersList;
	}

	public Provider getNewProvider() {
		return newProvider;
	}

	public void setNewProvider(Provider newProvider) {
		this.newProvider = newProvider;
	}

	
	
	
}
