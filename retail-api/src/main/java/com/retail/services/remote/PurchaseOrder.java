package com.retail.services.remote;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

@Remote
public interface PurchaseOrder {
	
	public Response getItem(String id);

}
