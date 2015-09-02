package com.saresh.bionic.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.UserDao;
import com.saresh.bionic.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext
    private EntityManager em;
	
	private final String selectByUsernamePasswordCustomer = "SELECT u FROM User u "
			+ "WHERE u.username = :username AND u.password = :password AND u.userRole='Customer'";
	private final String selectByUsernamePasswordStaff = "SELECT u FROM User u "
			+ "WHERE u.username = :username AND u.password = :password AND u.userRole='Staff'";
	private final String selectByUsernamePassword = "SELECT u FROM User u "
			+ "WHERE u.username = :username AND u.password = :password";
	
	@Override
	public void save(User user) {
		em.persist(user);		
	}

	@Override
	public boolean validateCustomer(String username, String password) {
		boolean result;
		TypedQuery<User> query = em.createQuery(selectByUsernamePasswordCustomer, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		if (query.getResultList().isEmpty()){
			result = false;
		} else {
			result = true;
		}		
		
		return result;
	}
	
	@Override
	public boolean validateStaff(String username, String password) {
		boolean result;
		TypedQuery<User> query = em.createQuery(selectByUsernamePasswordStaff, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		if (query.getResultList().isEmpty()){
			result = false;
		} else {
			result = true;
		}		
		
		return result;
	}

	@Override
	public boolean checkAvaliability(String username, String password) {
		boolean result;
		TypedQuery<User> query = em.createQuery(selectByUsernamePassword, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		if (query.getResultList().isEmpty()){
			result = true;
		} else {
			result = false;
		}		
		
		return result;
	}

	
	@Override
	public User find(String username, String password) {
		TypedQuery<User> query = em.createQuery(selectByUsernamePassword, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);		
		
		return query.getSingleResult();
	}

	@Override
	public User fingById(int id) {		
		return em.find(User.class, id);
	}

	
}
