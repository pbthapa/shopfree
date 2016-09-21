package com.retail.services.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.retail.model.Item;

@Stateless
public class PurchaseOrderBean {
	
	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

	public Item findItemById(Integer id) {
		Item item = em.find(Item.class, id);
		return item;
	}

}
