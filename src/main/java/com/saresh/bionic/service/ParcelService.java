package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.entity.ParcelItem;
import com.saresh.bionic.report.Result;
import com.saresh.bionic.report.ResultByDate;
import com.saresh.bionic.report.ResultByFish;

public interface ParcelService {
	public void save(Parcel parcel);
	
	public void save(Parcel parcel, List<ParcelItem> parcelItem);
	
	public Parcel findById(int id);
	
	public void updateStatus(int id, String status);
	
	public List<Parcel> findParcelsByStatus(String status);
	
	public List<Parcel> findParcelsByCustomer(Customer customer);
	
	public List<Parcel> findParcelsPendingPayment();
	
	public List<Parcel> findParcelsPaidEnought();
	
	public List<Parcel> findParcelsFullyPaid();
	
	public Result getTotalReport(java.sql.Date since, java.sql.Date to);
	
	public List<ResultByFish> getReportByFish(java.sql.Date since, java.sql.Date to);
	
	public List<ResultByDate> getReportByDate(java.sql.Date since, java.sql.Date to);
}
