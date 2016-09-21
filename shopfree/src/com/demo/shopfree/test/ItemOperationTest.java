package com.demo.shopfree.test;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ItemOperationTest {

	public static void main(String[] args) {
		// addItem();

		// findItem();

		getPo("100");
	}

	/***
	 * COMMENTED METHODS BELOW ARE FOR CONNECTING EJB VIA JNDI LOOKUP AND NOT BY RESTFUL WEB SERVICE
	 */
//	private static void findItem() {
//		final String jndiName = ItemService.class.getSimpleName() + "!" + ItemService.class.getName();
//		ItemService productService = WebUtil.getBean(jndiName);
//		JsonObject obj = Json.createObjectBuilder().add("item_id", "100").build();
//		String serializedJson = productService.getProductBySearchCriteria(obj.toString());
//		JsonReader reader = Json.createReader(new StringReader(serializedJson));
//		JsonObject result = reader.readObject();
//		System.out.println("Item Id : " + result.getString("item_id"));
//		System.out.println("Item Description : " + result.getString("item_description"));
//		System.out.println("Item Unit Cost : " + result.getString("item_unit_cost"));
//		System.out.println("Item Currency Code : " + result.getString("item_currency_code"));
//	}
//
//	private static void addItem() {
//		final String jndiName = ItemService.class.getSimpleName() + "!" + ItemService.class.getName();
//		ItemService productService = WebUtil.getBean(jndiName);
//		ItemDTO itemDto = productService.addProduct(new ItemDTO(null, "Polo", 12.00, "USD"));
//		System.out.println("[ " + itemDto.getItemId() + ", " + itemDto.getItemDescription() + ", "
//				+ itemDto.getCurrencyCode() + ", " + itemDto.getUnitCost() + " ]");
//	}

	public static void getPo(String id) {

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/retail-ejb/rest/po/" + id);
		Response response = target.request().get();
		System.out.println("response: " + response);
		Object o = response.readEntity(String.class);
		System.out.println("entity: " + o);
		response.close();
	}

}
