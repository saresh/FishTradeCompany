package com.saresh.bionic.dao;

import com.saresh.bionic.entity.User;


public interface UserDao {
	//Us # 18, 21
	public void save(User user);
	
	public boolean validateCustomer(String username, String password);
	
	public boolean validateStaff(String username, String password);
	
	public boolean checkAvaliability(String username, String password);
	
	public User find(String username, String password);
	
	public User fingById(int id);
	
	
}
