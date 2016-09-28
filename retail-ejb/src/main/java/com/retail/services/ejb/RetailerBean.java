/**
 * 
 */
package com.retail.services.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.retail.model.Retailer;

/**
 * @author ruchi.shrestha
 *
 */

@Stateless
public class RetailerBean {
	
	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

	public Boolean saveRetailerInfo(final Retailer retailer) {
		em.persist(retailer);
		em.flush();
		
		return true;
	}
	
	public List findAllRetailer() {
		Query query = em.createQuery("FROM Retailer i");
		List list = query.getResultList();
		return list;
	}
	
	

}
