package com.retail.services.remote;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

@Remote
public interface EmployeeService {

	public Response addEmployee(String json);

	public String deleteEmployee(String id);

	public Response updateProduct(String json);

	public Response getEmployeeBySearchCriteria(String json);
}
