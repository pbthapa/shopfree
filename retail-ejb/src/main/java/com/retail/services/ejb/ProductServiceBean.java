package com.retail.services.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.retail.services.remote.ProductService;

@Stateless(name = "ProductService")
public class ProductServiceBean implements ProductService {
	
	@PersistenceContext(unitName = "retailPersistenceUnit")
	private static EntityManager em;

	public String doProcess(String value) {

		System.out.println("Called upto here--1--------------------->");
		if(em == null) {
			System.out.println("What the hell!!!, entity manager is null you noob");
		}
		Query query = em.createNativeQuery("select * from testtable");
		System.out.println("Called upto here---2-------------------->");
		List result = query.getResultList();
		System.out.println("Called upto here-----3------------------>");
		System.out.println(result.get(0));
		System.out.println("Called upto here--------4--------------->");
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
