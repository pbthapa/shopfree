package com.retail.services.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.retail.model.Item;

@Stateless
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

	public List findAllItem() {
		Query query = em.createQuery("FROM Item i");
		List list = query.getResultList();
		return list;
	}
}
