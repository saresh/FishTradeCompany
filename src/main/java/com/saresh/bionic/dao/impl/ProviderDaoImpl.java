package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.ProviderDao;
import com.saresh.bionic.entity.Provider;

@Repository
public class ProviderDaoImpl implements ProviderDao{
	
	private final String selectAll = "SELECT p FROM Provider p";

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void save(Provider provider) {
		if (provider.getId() == 0){
			em.persist(provider);
		} else {
			em.merge(provider);
		}
	}

	@Override
	public Provider findById(int id) {
		Provider provider = em.find(Provider.class, id);
		return provider;
	}

	@Override
	public List<Provider> findAll() {
		TypedQuery<Provider> query = em.createQuery(selectAll, Provider.class);
		return query.getResultList();
	}

}
