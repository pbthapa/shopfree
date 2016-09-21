package com.retail.services.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeBean {

	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

}
