package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.Payment;

public interface PaymentDao {
	// Us # 16
	public void save(Payment payment);
	
	public Payment findById(int id);
	
	//Us # 12
	public List<Payment> getIncomeReport(java.sql.Date since);
	
	public List<Payment> getPaymentsForParcel(int parcelId);
	
	
	
}
