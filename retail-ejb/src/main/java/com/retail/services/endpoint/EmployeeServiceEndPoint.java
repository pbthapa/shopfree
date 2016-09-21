package com.retail.services.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.retail.services.ejb.EmployeeBean;
import com.retail.services.remote.EmployeeService;

@Path("/employee")
public class EmployeeServiceEndPoint implements EmployeeService {

	@Inject
	private EmployeeBean employee_;

	// Inject UriInfo to build the uri used in the POST response
	@Context
	private UriInfo uriInfo;

	public Response addEmployee(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response updateEmployee(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response getEmployeeBySearchCriteria(String json) {
		// TODO Auto-generated method stub
		return null;
	}

}
