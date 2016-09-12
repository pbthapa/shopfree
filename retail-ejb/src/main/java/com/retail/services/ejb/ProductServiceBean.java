package com.retail.services.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.retail.services.remote.ProductService;

@Stateless(name = "ProductService")
public class ProductServiceBean implements ProductService {
	
//	@PersistenceContext(unitName = "retailPersistenceUnit")
//	private static EntityManager em;

	public String doProcess(String value) {

//		Query query = em.createNativeQuery("select * from customer");
//		List result = query.getResultList();
//		System.out.println(result.get(0));
		return "Heello " + value + "!!!!!!. Result from DB : ";

	}

	public Object addProduct(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
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
