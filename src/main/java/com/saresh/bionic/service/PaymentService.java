package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.Payment;

public interface PaymentService {
	public void save(Payment payment);
	public Payment findById(int id);
	
	public List<Payment> getIncomeReport(java.sql.Date since);
	
	public List<Payment> getPaymentsForParcel(int parcelId);
}
