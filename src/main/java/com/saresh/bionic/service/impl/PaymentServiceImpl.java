package com.saresh.bionic.service.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.saresh.bionic.dao.PaymentDao;
import com.saresh.bionic.entity.Payment;
import com.saresh.bionic.service.PaymentService;

@Named
public class PaymentServiceImpl implements PaymentService {

	@Inject
	private PaymentDao paymentDao;
	
	@Override
	public void save(Payment payment) {
		paymentDao.save(payment);		
	}

	@Override
	public Payment findById(int id) {
		return paymentDao.findById(id);
	}

	@Override
	public List<Payment> getIncomeReport(Date since) {
		return paymentDao.getIncomeReport(since);
	}

	@Override
	public List<Payment> getPaymentsForParcel(int parcelId) {		
		return paymentDao.getPaymentsForParcel(parcelId);
	}

	
}
