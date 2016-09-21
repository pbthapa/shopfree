package com.retail.services.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.retail.model.Item;

@Stateless(name = "ProductService")
public class ItemBean {

	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

	public String doProcess(String value) {
		return null;
	}

	public Item saveItem(final Item item) {
		em.persist(item);
		em.flush();
		item.setItemId(item.getItemId());
		return item;
	}

	public Item findItemById(final Integer id) {
		Item item = em.find(Item.class, id);
		return item;
	}
}
