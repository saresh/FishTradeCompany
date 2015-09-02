package com.saresh.bionic.service.impl;


import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.ParcelDao;
import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.entity.ParcelItem;
import com.saresh.bionic.report.Result;
import com.saresh.bionic.report.ResultByDate;
import com.saresh.bionic.report.ResultByFish;
import com.saresh.bionic.service.ParcelService;

@Named
public class ParcelServiceImpl implements ParcelService {
	
	@Inject
	private ParcelDao parcelDao;
	
	@Override
	@Transactional
	public void save(Parcel parcel) {
		parcelDao.save(parcel);		
	}
	
	@Override
	@Transactional
	public void save(Parcel parcel, List<ParcelItem> parcelItems) {		
		parcel.setParcelItems(parcelItems);
		
		for (ParcelItem pi : parcelItems){
			pi.setParcel(parcel);
		}		
		parcelDao.save(parcel);
	}

	@Override
	public Parcel findById(int id) {
		return parcelDao.findById(id);
	}

	@Override
	@Transactional
	public void updateStatus(int id, String status) {
		parcelDao.updateStatus(id, status);		
	}
	
	@Override
	public List<Parcel> findParcelsByStatus(String status) {
		return parcelDao.findParcelsByStatus(status);
	}

	@Override
	public Result getTotalReport(java.sql.Date since, java.sql.Date to) {
		
		return parcelDao.getTotalReport(since, to);
	}

	@Override
	public List<Parcel> findParcelsByCustomer(Customer customer) {
		return parcelDao.findParcelsByCustomer(customer);
	}

	@Override
	public List<Parcel> findParcelsPendingPayment() {
		return parcelDao.findParcelsPendingPayment();
	}

	@Override
	public List<Parcel> findParcelsPaidEnought() {
		return parcelDao.findParcelsPaidEnought();
	}

	@Override
	public List<Parcel> findParcelsFullyPaid() {
		return parcelDao.findParcelsFullyPaid();
	}

	@Override
	public List<ResultByFish> getReportByFish(Date since, Date to) {
		return parcelDao.getReportByFish(since, to);
	}

	@Override
	public List<ResultByDate> getReportByDate(Date since, Date to) {
		return parcelDao.getReportByDate(since, to);
	}

	

}
