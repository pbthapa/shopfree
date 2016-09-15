package com.retail.services.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.retail.model.Item;
import com.retail.services.remote.ProductService;
import com.retail.services.remote.dto.ItemDTO;

@Stateless(name = "ProductService")
public class ProductServiceBean implements ProductService {

	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

	public String doProcess(String value) {
		Query query = em.createNativeQuery("select * from testtable");
		List result = query.getResultList();
		System.out.println(result.get(0));
		return "Heello " + value + "!!!!!!. Result from DB : " + result.get(0);
	}

	public ItemDTO addProduct(ItemDTO item) {
		Item entity = new Item();
		entity.setItemDescription(item.getItemDescription());
		entity.setCurrencyCode(item.getCurrencyCode());
		entity.setUnitCost(item.getUnitCost());
		em.persist(entity);
		em.flush();
		item.setItemId(entity.getItemId());
		return item;
	}

	public void deleteProduct(int id) {
		
	}

	public Object updateProduct(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getProductBySearchCriteria(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
