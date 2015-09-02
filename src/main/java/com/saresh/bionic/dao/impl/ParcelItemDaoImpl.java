package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.ParcelItemDao;
import com.saresh.bionic.entity.ParcelItem;

@Repository
public class ParcelItemDaoImpl implements ParcelItemDao {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void save(ParcelItem parcelItem) {
		em.persist(parcelItem);		
	}

	@Override
	public ParcelItem findById(int id) {
		ParcelItem parcelItem = null;
		parcelItem = em.find(ParcelItem.class, id);
		return parcelItem;
	}

	@Override
	public void remove(int id) {
		ParcelItem parcelItem = em.find(ParcelItem.class, id);
		if (parcelItem != null){
			em.remove(parcelItem);
		}		
	}

	@Override
	public void updateQuantity(int id, int quantity) {
		ParcelItem parcelItem = null;
		parcelItem = em.find(ParcelItem.class, id);
		parcelItem.setQuantity(quantity);
		em.persist(parcelItem);		
	}

	@Override
	public List<ParcelItem> findAllParcelItems() {
		TypedQuery<ParcelItem> query = 
				em.createQuery("SELECT pi FROM ParcelItem pi", ParcelItem.class);
		List<ParcelItem> result = query.getResultList();
		return result;
	}

}
