package com.saresh.bionic.service;

import java.util.List;

import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;

public interface StaffService {
	public Staff findById(int id);
	
	public void changeActiveStatus(int id);
	
	public void save(Staff staff);

	public Staff findByUser(User user);
	
	public List<Staff> findAll();
}
