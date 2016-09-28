/**
 * 
 */
package com.retail.services.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.model.Item;
import com.retail.model.Retailer;
import com.retail.services.ejb.RetailerBean;
import com.retail.services.remote.RetailerService;

/**
 * @author ruchi.shrestha
 *
 */

@Path("/retailer")
public class RetailerServiceEndPoint implements RetailerService{
	
	@Inject
	private RetailerBean retailer_;

	// Inject UriInfo to build the uri used in the POST response
	@Context
	private UriInfo uriInfo;

	@Override
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public Response addRetailerInfo(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Retailer retailer = null;
		try {
			retailer = mapper.readValue(json, new TypeReference<Retailer>(){});
		} catch(Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		Boolean saved = retailer_.saveRetailerInfo(retailer);
		if (saved == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(true).build();
	}

	@Override
	@GET
	@Path("/findallretailer")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response findAllRetailers() {
		List list = retailer_.findAllRetailer();
		if (list == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();
		}

		Response response = Response.status(Response.Status.OK).entity(list).build();
		return response;
	}
}
