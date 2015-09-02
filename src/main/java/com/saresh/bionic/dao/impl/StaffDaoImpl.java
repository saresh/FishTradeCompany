package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.StaffDao;
import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;

@Repository
public class StaffDaoImpl implements StaffDao {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Staff findById(int id) {
		Staff staff = null;
		staff = em.find(Staff.class, id);
		return staff;
	}
	
	@Override
	public void changeActiveStatus(int id) {
		
		Staff staff = null;
		staff = em.find(Staff.class, id);
		if (staff.isActive()){
			staff.setActive(false);
		} else {
			staff.setActive(true);
		}
		
		em.merge(staff);
	}

	@Override
	public void save(Staff staff) {
		em.persist(staff);		
	}

	@Override
	public Staff findByUser(User user) {
		TypedQuery<Staff> query = em.createQuery("SELECT s FROM Staff s "
				+ "WHERE s.user = :user", Staff.class);
		query.setParameter("user", user);
		
		return query.getSingleResult();
	}

	@Override
	public List<Staff> findAll() {
		TypedQuery<Staff> query = em.createQuery("SELECT s FROM Staff s ORDER BY s.staffRole", Staff.class);
		return query.getResultList();
	}

	

}
