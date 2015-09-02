package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.service.ParcelService;

@Named
@Scope("request")
public class CustomerParcelBean implements Serializable {
	
	private static final long serialVersionUID = -1740660497553644462L;

	private List<Parcel> customerParcels = null;
	
	@Inject
	private ParcelService parcelService;

	public void refreshList(Customer customer){
		customerParcels = parcelService.findParcelsByCustomer(customer);
	}
	
	public List<Parcel> getCustomerParcels() {
		return customerParcels;
	}

	public void setCustomerParcels(List<Parcel> customerParcels) {
		this.customerParcels = customerParcels;
	}
	
	

}
