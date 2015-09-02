package com.saresh.bionic.dao.impl;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.ParcelDao;
import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.report.Result;
import com.saresh.bionic.report.ResultByDate;
import com.saresh.bionic.report.ResultByFish;

@Repository
public class ParcelDaoImpl implements ParcelDao{
	
	private final String selectByStatus = "SELECT p FROM Parcel p "
			+ "WHERE p.status = :status";
	private final String selectByCustomer = "SELECT p FROM Parcel p "
			+ "WHERE p.customer = :customer ORDER BY p.orderDate DESC";
	
	private final String totalReportQuery = 
			  "SELECT new com.saresh.bionic.report.Result(SUM(pi.quantity), "
			+ "SUM(pi.price * pi.quantity), SUM (pi.price * pi.quantity - fi.pricePaidFor * pi.quantity) ) "
			+ "FROM Parcel p, ParcelItem pi, FishItem fi "
			+ "WHERE pi.parcel.id = p.id AND pi.fishItem.id = fi.id AND p.status = 'Shipped' "
			+ "AND p.shippingDate BETWEEN :since AND :to";
	
	private final String reportByFishQuery =  
			  "SELECT new com.saresh.bionic.report.ResultByFish(fi.name, SUM(pi.quantity), "
			+ "SUM(pi.price * pi.quantity), SUM (pi.price * pi.quantity - fi.pricePaidFor * pi.quantity) ) "
			+ "FROM Parcel p, ParcelItem pi, FishItem fi "
			+ "WHERE pi.parcel.id = p.id AND pi.fishItem.id = fi.id AND p.status = 'Shipped' "
				+ "AND p.shippingDate BETWEEN :since AND :to "
			+ "GROUP BY fi.name";
	
	private final String reportByDateQuery =  
			  "SELECT new com.saresh.bionic.report.ResultByDate(p.shippingDate, SUM(pi.quantity), "
			+ "SUM(pi.price * pi.quantity), SUM (pi.price * pi.quantity - fi.pricePaidFor * pi.quantity) ) "
			+ "FROM Parcel p, ParcelItem pi, FishItem fi "
			+ "WHERE pi.parcel.id = p.id AND pi.fishItem.id = fi.id AND p.status = 'Shipped' "
				+ "AND p.shippingDate BETWEEN :since AND :to "
			+ "GROUP BY p.shippingDate";
	

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void save(Parcel parcel) {
		if(parcel.getId() == 0){
			em.persist(parcel);		
		} else {
			em.merge(parcel);
		}
	}

	@Override
	public Parcel findById(int id) {
		Parcel parcel = null;
		parcel = em.find(Parcel.class, id);
		return parcel;
	}

	@Override
	public void updateStatus(int id, String status) {
		Parcel parcel = null;
		parcel = em.find(Parcel.class, id);
		parcel.setStatus(status);
		em.persist(parcel);
	}	

	@Override
	public List<Parcel> findParcelsByStatus(String status) {
		TypedQuery<Parcel> query = em.createQuery(selectByStatus, Parcel.class);
		query.setParameter("status", status);
		List<Parcel> result = query.getResultList();
		return result;
	}
	
	@Override
	public Result getTotalReport(java.sql.Date since, java.sql.Date to) {
		TypedQuery<Result> query = em.createQuery(totalReportQuery, Result.class);
		query.setParameter("since", since);
		query.setParameter("to", to);
		
		return query.getSingleResult();
	}
	
	@Override
	public List<ResultByFish> getReportByFish(Date since, Date to) {
		TypedQuery<ResultByFish> query = em.createQuery(reportByFishQuery, ResultByFish.class);
		query.setParameter("since", since);
		query.setParameter("to", to);
		
		return query.getResultList();
	}
	
	@Override
	public List<ResultByDate> getReportByDate(Date since, Date to) {
		TypedQuery<ResultByDate> query = em.createQuery(reportByDateQuery, ResultByDate.class);
		query.setParameter("since", since);
		query.setParameter("to", to);
		
		return query.getResultList();
	}

	@Override
	public List<Parcel> findParcelsByCustomer(Customer customer) {
		TypedQuery<Parcel> query = em.createQuery(selectByCustomer, Parcel.class);
		query.setParameter("customer", customer);
		
		return query.getResultList();
	}

	@Override
	public List<Parcel> findParcelsPendingPayment() {
		TypedQuery<Parcel> query = em.createQuery("SELECT p FROM Parcel p", Parcel.class);	
		List<Parcel> result = query.getResultList();
		
		Parcel p;
		
		for (Iterator<Parcel> it = result.iterator(); it.hasNext(); ){
			p = it.next();
			if(p.getTotalPaymentsAmount() >= p.getTotalPrice()){
				it.remove();
			}
			
		}	
		
		return result;		
	}

	@Override
	public List<Parcel> findParcelsPaidEnought() {
		List<Parcel> result = findParcelsByStatus("Client created order");
		Parcel p;		
		
		for (Iterator<Parcel> it = result.iterator(); it.hasNext(); ){
			p = it.next();
			if(p.getTotalPaymentsAmount() < p.getPrepaymentAmount()){
				it.remove();
			}
		}	
		
		return result;	
	}

	@Override
	public List<Parcel> findParcelsFullyPaid() {
		TypedQuery<Parcel> query = em.createQuery("SELECT p FROM Parcel p", Parcel.class);	
		List<Parcel> result = query.getResultList();
		
		Parcel p;
		
		for (Iterator<Parcel> it = result.iterator(); it.hasNext(); ){
			p = it.next();
			if(p.getTotalPaymentsAmount() < p.getTotalPrice()){
				result.remove(p);
			}
		}	
		
		return result;
	}

}
