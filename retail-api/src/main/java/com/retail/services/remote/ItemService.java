package com.retail.services.remote;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

@Remote
public interface ItemService {

	public String doProcess(String value);

	public Response addItem(String json);

	public String deleteItem(String id);

	public Response updateItem(String json);

	public Response findItemById(String id);
	
	public Response findAllItem();
}
