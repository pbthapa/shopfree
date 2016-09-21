package com.retail.services.endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.retail.model.Item;
import com.retail.services.ejb.PurchaseOrderBean;
import com.retail.services.remote.PurchaseOrderService;

@Path("/po")
public class PurchaseOrderServiceEndPoint implements PurchaseOrderService {

	@Inject
	private PurchaseOrderBean po_;

	// Inject UriInfo to build the uri used in the POST response
	@Context
	private UriInfo uriInfo;

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findPurchaseOrderById(@PathParam("id") String id) {
		Item item = po_.findItemById(Integer.valueOf(id));
		if (item == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + id).build();
		}

		Response response = Response.status(Response.Status.OK).entity(item).build();
		return response;
	}
}
