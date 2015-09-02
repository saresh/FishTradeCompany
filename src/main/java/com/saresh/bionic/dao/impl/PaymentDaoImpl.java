package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.PaymentDao;
import com.saresh.bionic.entity.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	private static final String SQL_SELECT_PAYMENTS_SINCE_DATE = 
			"SELECT p FROM Payment p WHERE paymentDate >= :since";
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void save(Payment payment) {
		em.persist(payment);		
	}

	@Override
	public Payment findById(int id) {
		Payment payment = null;
		payment = em.find(Payment.class, id);
		return payment;
	}

	@Override
	public List<Payment> getIncomeReport(java.sql.Date since) {
		TypedQuery<Payment> query = 
				em.createQuery(SQL_SELECT_PAYMENTS_SINCE_DATE, Payment.class);
		query.setParameter("since", since);
		List<Payment> result = null;
		result = query.getResultList();
		
		return result;
	}

	@Override
	public List<Payment> getPaymentsForParcel(int parcelId) {
		TypedQuery<Payment> query = 
				em.createQuery("SELECT p FROM Payment p WHERE parcelId = :parcelid", Payment.class);
		query.setParameter("parcelId", parcelId);
		List<Payment> result = null;
		result = query.getResultList();
		
		return result;
	}
	

}
