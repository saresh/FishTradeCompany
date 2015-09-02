package com.saresh.bionic.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.CustomerDao;
import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.CustomerService;

@Named
public class CustomerServiceImpl implements CustomerService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private CustomerDao customerDao;

	@Override
	public Customer findById(int id) {		
		return customerDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);		
	}

	@Override
	public Customer findByUser(User user) {
		return customerDao.findByUser(user);
	}

	@Override
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

}
