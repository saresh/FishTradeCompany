package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.User;


public interface CustomerDao {
	
	public Customer findById(int id);
	//Us # 21
	public void save(Customer customer);
	//Us # 11
	public void setPrepaymentType(int id, int percent);
	
	public Customer findByUser(User user);
	
	public List<Customer> findAll();
}
