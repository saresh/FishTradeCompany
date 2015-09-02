package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.entity.Payment;
import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.service.ParcelService;
import com.saresh.bionic.service.StaffService;

@Named
@Scope("session")
public class AccountantBean implements Serializable {
	private static final long serialVersionUID = 3043543509181614751L;

	private List<Parcel> pendingPayments;
	
	private List<Parcel> readyForShipmentStatus;
	
	private Parcel parcelForPayment;
	private int amountPaid;
	
	
	@Inject
	private ParcelService parcelService;
	@Inject
	private StaffService staffService;
	
	public void updatePendingPaymentsList(){
		pendingPayments = parcelService.findParcelsPendingPayment();
	}
	
	public void updateReadyForShipmentStatusList(){
		readyForShipmentStatus = parcelService.findParcelsPaidEnought();
	}
	
	public String addPayment(Parcel parcel){
		parcelForPayment = parcel;
		
		return "/accountant/newPayment";
	}
	
	public String savePayment(String staffId){
		Staff staffAccepted = staffService.findById(Integer.parseInt(staffId));
		Payment payment = new Payment();
				
		payment.setAmount(amountPaid);
		payment.setStaffAccepted(staffAccepted);
		payment.setPaymentDate(new java.sql.Date(new java.util.Date().getTime()));
		
		parcelForPayment.addPayment(payment);
		
		parcelService.save(parcelForPayment);
		
		return "/accountant/manageParcelPayments";
	}
	
	public String setAvaliableForShipment(Parcel parcel){
		parcel.setStatus("Avaliable for shipment");
		parcelService.save(parcel);
		
		return "/accountant/managePaidParcels";
	}

	public List<Parcel> getPendingPayments() {
		return pendingPayments;
	}

	public void setPendingPayments(List<Parcel> pendingPayments) {
		this.pendingPayments = pendingPayments;
	}

	public List<Parcel> getReadyForShipmentStatus() {
		return readyForShipmentStatus;
	}

	public void setReadyForShipmentStatus(List<Parcel> readyForShipmentStatus) {
		this.readyForShipmentStatus = readyForShipmentStatus;
	}

	public Parcel getParcelForPayment() {
		return parcelForPayment;
	}

	public void setParcelForPayment(Parcel parcelForPayment) {
		this.parcelForPayment = parcelForPayment;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	

	
	
	
}
