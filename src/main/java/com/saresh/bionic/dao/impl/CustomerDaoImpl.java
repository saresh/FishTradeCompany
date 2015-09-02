package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.CustomerDao;
import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.User;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Customer findById(int id) {
		Customer customer = null;
		customer = em.find(Customer.class, id);
		return customer;
	}
	
	@Override
	public void save(Customer customer) {
		if(customer.getId() == 0){
			em.persist(customer);		
		} else {
			em.merge(customer);
		}
	}

	@Override
	public void setPrepaymentType(int id, int percent) {
		Customer customer = null;
		customer = em.find(Customer.class, id);
		customer.setPrepaymentPercent(percent);
		em.persist(customer);		
	}

	@Override
	public Customer findByUser(User user) {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c "
				+ "WHERE c.user = :user", Customer.class);
		query.setParameter("user", user);
		
		return query.getSingleResult();
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
		return query.getResultList();
	}	

}
