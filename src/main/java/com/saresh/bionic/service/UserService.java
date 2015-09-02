package com.saresh.bionic.service;

import com.saresh.bionic.entity.User;

public interface UserService {
	public void save(User user);
	public boolean validateCustomer(String username, String password);
	public boolean validateStaff(String username, String password);
	public boolean checkAvaliability(String username, String password);
	public User find(String username, String password);
	public User fingById(int id);
}
