package com.saresh.bionic.dao;

import java.util.List;

import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;

public interface StaffDao {
	
	public Staff findById(int id);
	//Us # 19
	public void changeActiveStatus(int id);
	//Us # 18
	public void save(Staff staff);
	
	public Staff findByUser(User user);
	
	public List<Staff> findAll();
	
}
