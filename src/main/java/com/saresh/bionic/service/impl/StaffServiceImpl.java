package com.saresh.bionic.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.saresh.bionic.dao.StaffDao;
import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.service.StaffService;

@Named
public class StaffServiceImpl implements StaffService{
	
	@Inject
	private StaffDao staffDao;

	@Override
	public Staff findById(int id) {
		return staffDao.findById(id);
	}

	@Override
	@Transactional
	public void changeActiveStatus(int id) {
		staffDao.changeActiveStatus(id);
	}

	@Override
	@Transactional
	public void save(Staff staff) {
		staffDao.save(staff);
	}

	@Override
	public Staff findByUser(User user) {
		return staffDao.findByUser(user);
	}

	@Override
	public List<Staff> findAll() {
		return staffDao.findAll();
	}

}
