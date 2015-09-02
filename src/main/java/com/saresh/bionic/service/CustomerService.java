package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.User;

public interface CustomerService {
	public Customer findById(int id);
	
	public void save(Customer customer);
	
	public Customer findByUser(User user);
	
	public List<Customer> findAll();
	
	
}
