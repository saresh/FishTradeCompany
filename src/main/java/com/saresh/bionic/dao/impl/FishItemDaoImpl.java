package com.saresh.bionic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.saresh.bionic.dao.FishItemDao;
import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.ProviderParcel;

@Repository
public class FishItemDaoImpl implements FishItemDao {
	
	private final String selectAvaliableForSale = 
			"SELECT fi FROM FishItem fi WHERE fi.avaliable = true";
	
	private final String selectAll = 
			"SELECT fi FROM FishItem fi ORDER BY fi.writeoff, fi.avaliable";
	
	private final String selectReceived = 
			"SELECT fi FROM FishItem fi WHERE fi.providerParcel.deliveryDate IS NOT NULL";
	
	private final String selectExpected = 
			"SELECT fi FROM FishItem fi WHERE fi.providerParcel.deliveryDate IS NULL";
	
	private final String selectExpectedByProviderParcel = 
			"SELECT fi FROM FishItem fi WHERE fi.providerParcel = :providerParcel "
			+ "AND fi.quantity = 0";
	
	private final String selectWriteOffFish = "SELECT fi FROM FishItem fi WHERE fi.writeoff = true AND fi.quantity > 0";
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public FishItem findById(int id) {
		FishItem fishItem = null;
		fishItem = em.find(FishItem.class, id);
		return fishItem;
	}

	@Override
	public void save(FishItem fishItem) {
		if(fishItem.getId() == 0){
			em.persist(fishItem);
		} else {
			em.merge(fishItem);
		}
	}

	@Override
	public void changeAvaliability(int id) {
		FishItem fishItem = em.find(FishItem.class, id);
		fishItem.setAvaliable(!fishItem.isAvaliable());
		em.persist(fishItem);		
	}

	@Override
	public void updatePrice(int id, int price) {
		FishItem fishItem = em.find(FishItem.class, id);
		fishItem.setPrice(price);
		em.persist(fishItem);		
	}

		
	@Override
	public void reduceFishItemQuantity(int id, int quantity) {
		FishItem fishItem = em.find(FishItem.class, id);
		fishItem.reduceQuantity(quantity);
		em.persist(fishItem);		
	}

	@Override
	public void setAsWriteOff(int id) {
		FishItem fishItem = em.find(FishItem.class, id);
		fishItem.setWriteoff(true);
		fishItem.setAvaliable(false);
		em.persist(fishItem);		
	}

	@Override
	public void registerFishItemArrival(int id, int quantity) {
		FishItem fishItem = em.find(FishItem.class, id);
		fishItem.setQuantity(quantity);
		em.persist(fishItem);
	}

	@Override
	public List<FishItem> findFishAvaliableForSale() {
		TypedQuery<FishItem> query = 
				em.createQuery(selectAvaliableForSale, FishItem.class);
		List<FishItem> result = query.getResultList();
		return result;
	}

	@Override
	public List<FishItem> findAll() {
		TypedQuery<FishItem> query = em.createQuery(selectAll, FishItem.class);
		return query.getResultList();
	}

	@Override
	public List<FishItem> findAllExpected() {
		TypedQuery<FishItem> query = em.createQuery(selectExpected, FishItem.class);
		return query.getResultList();
	}

	@Override
	public List<FishItem> findAllReceived() {
		TypedQuery<FishItem> query = em.createQuery(selectReceived, FishItem.class);
		return query.getResultList();
	}

	@Override
	public List<FishItem> findExpected(ProviderParcel providerParcel) {
		TypedQuery<FishItem> query = em.createQuery(selectExpectedByProviderParcel, FishItem.class);
		query.setParameter("providerParcel", providerParcel);
		return query.getResultList();
	}

	@Override
	public List<FishItem> findWriteOffFishItems() {
		TypedQuery<FishItem> query = em.createQuery(selectWriteOffFish, FishItem.class);
		return query.getResultList();
	}

}
