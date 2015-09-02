package com.saresh.bionic.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.UserDao;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.UserService;

@Named
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;
	
	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);		
	}

	@Override
	public boolean validateCustomer(String username, String password) {	
		return userDao.validateCustomer(username, password);
	}
	
	@Override
	public boolean validateStaff(String username, String password) {	
		return userDao.validateStaff(username, password);
	}
	
	@Override
	public boolean checkAvaliability(String username, String password) {
		return userDao.checkAvaliability(username, password);
	}


	@Override
	public User find(String username, String password) {
		return userDao.find(username, password);
	}

	@Override
	public User fingById(int id) {
		return userDao.fingById(id);
	}

	
}
