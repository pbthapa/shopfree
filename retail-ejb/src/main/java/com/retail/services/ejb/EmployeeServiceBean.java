package com.retail.services.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "EmployeeService")
public class EmployeeServiceBean {

	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

}
