package com.retail.services.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.retail.model.Item;
import com.retail.services.remote.PurchaseOrder;

@Path("/item")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Stateless
public class PurchaseOrderBean implements PurchaseOrder {

	@PersistenceContext(unitName = "retailPersistenceUnit")
	private EntityManager em;

	// Inject UriInfo to build the uri used in the POST response
	@Context
	private UriInfo uriInfo;

	@GET
    @Path("{id}")
	public Response getItem(@PathParam("id") String id) {
		Item item = em.find(Item.class, Integer.valueOf(id));
		Query query = em.createNativeQuery("select * from customer");
		List result = query.getResultList();
		String s = (String) result.get(0);
		System.out.println(s);
        if(s == null){
            throw new NotFoundException();
        }
 
        return Response.ok(s).build();
	}

}
