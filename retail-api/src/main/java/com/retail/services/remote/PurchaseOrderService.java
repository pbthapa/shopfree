package com.retail.services.remote;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

@Remote
public interface PurchaseOrderService {
	
	public Response findPurchaseOrderById(String id);
	
}
