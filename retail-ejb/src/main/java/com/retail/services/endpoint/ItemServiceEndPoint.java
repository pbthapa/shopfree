package com.retail.services.endpoint;

import java.io.StringReader;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.retail.model.Item;
import com.retail.services.ejb.ItemBean;
import com.retail.services.remote.ItemService;

@Path("/item")
public class ItemServiceEndPoint implements ItemService {

	@Inject
	private ItemBean item_;

	// Inject UriInfo to build the uri used in the POST response
	@Context
	private UriInfo uriInfo;

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findItemById(@PathParam("id") String id) {
		Item item = item_.findItemById(Integer.valueOf(id));
		if (item == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + id).build();
		}

		Response response = Response.status(Response.Status.OK).entity(item).build();
		return response;
	}

	public String doProcess(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addItem(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject obj = reader.readObject();
		Item item = new Item();
		item.setItemId(null);
		item.setItemDescription(obj.getString("item_desc"));
		item.setUnitCost(Double.valueOf(obj.getString("unit_cost")));
		item.setCurrencyCode(obj.getString("currency"));
		Item result = item_.saveItem(item);
		if (result == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(result).build();
	}

	public String deleteItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response updateItem(String json) {
		// TODO Auto-generated method stub
		return null;
	}
}
