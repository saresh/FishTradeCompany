package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.ProviderParcelDao;
import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.entity.ProviderParcel;

@Repository
public class ProviderParcelDaoImpl implements ProviderParcelDao{
	
	private final String selectAll = "SELECT pp FROM ProviderParcel pp "
			+ "ORDER BY pp.deliveryDate DESC";
	private final String selectAllExpected = "SELECT pp FROM ProviderParcel pp "
			+ "WHERE pp.deliveryDate IS NULL";
	
	private final String selectExpectedFromProvider = "SELECT pp FROM ProviderParcel pp "
			+ "WHERE pp.deliveryDate IS NULL AND pp.provider = :provider ORDER BY pp.id DESC";

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public ProviderParcel findById(int id) {
		ProviderParcel fp = null;
		fp = em.find(ProviderParcel.class, id);
		return fp;
	}

	@Override
	public void save(ProviderParcel providerParcel) {
		if (providerParcel.getId() == 0){
			em.persist(providerParcel);
		} else {
			em.merge(providerParcel);
		}
	}

	@Override
	public List<ProviderParcel> findAll() {
		TypedQuery<ProviderParcel> query = em.createQuery(selectAll, ProviderParcel.class);
		return query.getResultList();
	}

	@Override
	public List<ProviderParcel> findAllExpected() {
		TypedQuery<ProviderParcel> query = em.createQuery(selectAllExpected, ProviderParcel.class);
		return query.getResultList();
	}

	@Override
	public ProviderParcel findExpected(Provider provider) {
		TypedQuery<ProviderParcel> query = em.createQuery(selectExpectedFromProvider, ProviderParcel.class);
		query.setParameter("provider", provider);
		List<ProviderParcel> list = query.getResultList();
		if (list.isEmpty()){
			return null;
		} else {
			return list.get(0);
		}
	}	

}
