package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.entity.ParcelItem;
import com.saresh.bionic.service.FishItemService;
import com.saresh.bionic.service.ParcelService;

@Named
@Scope("session")
public class ParcelShipmentBean implements Serializable {
	private static final long serialVersionUID = -5702153399563235514L;

	private List<Parcel> avaliableForShipment;
	
	@Inject
	private ParcelService parcelService;
	@Inject
	private FishItemService fishItemService;
	
	public void updateAvaliableList(){
		avaliableForShipment = parcelService.findParcelsByStatus("Avaliable for shipment");
	}
	
	public String shipParcel(Parcel parcel){		
		for (ParcelItem pi : parcel.getParcelItems()){
			fishItemService.reduceFishItemQuantity(pi.getFishItem().getId(), pi.getQuantity());	
		}
		parcel.setStatus("Shipped");
		parcel.setShippingDate(new java.sql.Date(new java.util.Date().getTime()));		
		
		parcelService.save(parcel);
		
		return "/csm/shipment";		
	}
	
	public boolean checkAvaliability(Parcel parcel){
		boolean result = true;
		for (ParcelItem pi : parcel.getParcelItems()){
			if(pi.getQuantity() > pi.getFishItem().getQuantity()){
				result = false;
			}
		}
		
		return result;
	}

	public String cancelParcelShipment(Parcel parcel){
		parcel.setStatus("Cancelled");
		
		for (ParcelItem pi : parcel.getParcelItems()){
			pi.setQuantity(0);			
		}
		
		parcelService.save(parcel);
		
		return "/csm/shipment";
	}
	
	public List<Parcel> getAvaliableForShipment() {
		return avaliableForShipment;
	}

	public void setAvaliableForShipment(List<Parcel> avaliableForShipment) {
		this.avaliableForShipment = avaliableForShipment;
	}
	
}
