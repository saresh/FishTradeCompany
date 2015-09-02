package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.ProviderParcel;
import com.saresh.bionic.service.FishItemService;
import com.saresh.bionic.service.ProviderParcelService;
import com.saresh.bionic.service.ProviderService;

@Named
@Scope("session")
public class FishArrivalBean implements Serializable {
	private static final long serialVersionUID = 1927242182299286933L;

	private String fishProviderName;	
	private java.util.Date dateArrival;
	
	private int quantityArrived;
	private String providerParcelId;
	
	private ProviderParcel providerParcel;
	
	private List<FishItem> newFishList = null;
	private Map<String, String> fishProviders = new HashMap<String, String>();
	private FishItem fishToEdit = null;
	
	@Inject
	ProviderParcelService providerParcelService;
	@Inject
	ProviderService providerService;
	@Inject
	FishItemService fishItemService;	
	
	public String saveProviderParcelArrival(){		
		providerParcel = providerParcelService.findById(Integer.parseInt(providerParcelId));
		providerParcel.setDeliveryDate(new java.sql.Date(dateArrival.getTime()));
		
		providerParcelService.save(providerParcel);
		
		return "/csm/manageFishArrival";
	}
	
	public void updateFishList(){
		newFishList = fishItemService.findExpected(providerParcel);		
	}
	
	public void updateProvidersList(){
		String key = "";
		String value = "";
		for(ProviderParcel fp : providerParcelService.findAllExpected()){
			value = fp.getId() + "";
			if (fp.getProvider() != null){
				key = fp.getProvider().getName();
			} else {
				key = "no provider";
			}
			
			fishProviders.put(key, value);
		}
	}
	
	public String registerFishArrival(FishItem fi){
		
		fishItemService.save(fi);
		
		return "/csm/manageFishArrival";		
	}
	
	public String updateFishItem(){		
		fishToEdit.addQuantity(quantityArrived);
		
		fishItemService.save(fishToEdit);
		return "/csm/manageFishArrival";
	}	

	public List<FishItem> getNewFishList() {
		return newFishList;
	}

	public void setNewFishList(List<FishItem> fishList) {
		this.newFishList = fishList;
	}

	public FishItem getFishToEdit() {
		return fishToEdit;
	}

	public void setFishToEdit(FishItem fishToEdit) {
		this.fishToEdit = fishToEdit;
	}

	public String getFishProviderName() {
		return fishProviderName;
	}

	public void setFishProviderName(String fishProviderName) {
		this.fishProviderName = fishProviderName;
	}

	public java.util.Date getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(java.util.Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public String getProviderParcelId() {
		return providerParcelId;
	}

	public void setProviderParcelId(String providerParcelId) {
		this.providerParcelId = providerParcelId;
	}

	public Map<String, String> getFishProviders() {
		return fishProviders;
	}

	public void setFishProviders(Map<String, String> fishProviders) {
		this.fishProviders = fishProviders;
	}

	public int getQuantityArrived() {
		return quantityArrived;
	}

	public void setQuantityArrived(int quantityArrived) {
		this.quantityArrived = quantityArrived;
	}

	public ProviderParcel getProviderParcel() {
		return providerParcel;
	}

	public void setProviderParcel(ProviderParcel providerParcel) {
		this.providerParcel = providerParcel;
	}
	
}
