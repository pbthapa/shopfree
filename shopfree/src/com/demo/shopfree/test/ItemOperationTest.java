package com.demo.shopfree.test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.services.remote.dto.ItemDTO;

public class ItemOperationTest {

	public static void main(String[] args) {
		addItem();

		// findItem();

		// getPo("100");
		
	//	findAllItem();
	}

	/***
	 * COMMENTED METHODS BELOW ARE FOR CONNECTING EJB VIA JNDI LOOKUP AND NOT BY
	 * RESTFUL WEB SERVICE
	 */
	// private static void findItem() {
	// final String jndiName = ItemService.class.getSimpleName() + "!" +
	// ItemService.class.getName();
	// ItemService productService = WebUtil.getBean(jndiName);
	// JsonObject obj = Json.createObjectBuilder().add("item_id",
	// "100").build();
	// String serializedJson =
	// productService.getProductBySearchCriteria(obj.toString());
	// JsonReader reader = Json.createReader(new StringReader(serializedJson));
	// JsonObject result = reader.readObject();
	// System.out.println("Item Id : " + result.getString("item_id"));
	// System.out.println("Item Description : " +
	// result.getString("item_description"));
	// System.out.println("Item Unit Cost : " +
	// result.getString("item_unit_cost"));
	// System.out.println("Item Currency Code : " +
	// result.getString("item_currency_code"));
	// }
	//
	// private static void addItem() {
	// final String jndiName = ItemService.class.getSimpleName() + "!" +
	// ItemService.class.getName();
	// ItemService productService = WebUtil.getBean(jndiName);
	// ItemDTO itemDto = productService.addProduct(new ItemDTO(null, "Polo",
	// 12.00, "USD"));
	// System.out.println("[ " + itemDto.getItemId() + ", " +
	// itemDto.getItemDescription() + ", "
	// + itemDto.getCurrencyCode() + ", " + itemDto.getUnitCost() + " ]");
	// }

	public static void getPo(String id) {

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/retail-ejb/rest/item/" + id);
		Response response = target.request().get();
		System.out.println("response: " + response);
		Object o = response.readEntity(String.class);
		System.out.println("entity: " + o);
		response.close();
		
	}

	private static void addItem() {
		ObjectMapper mapper = new ObjectMapper();		
		ItemDTO item = new ItemDTO();
		item.setItemDescription("Addidas Shoes");
		item.setUnitCost(12.99);
		item.setCurrencyCode("AUD");
		
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(item);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ResteasyClient client = new ResteasyClientBuilder().build();
		// ResteasyWebTarget target =
		// client.target("http://localhost:8080/retail-ejb/rest/item/create/");
		// Response response =
		// target.request().post(Entity.entity(json.toString(),
		// "application/json"));
		// System.out.println("response: " + response);
		// Object o = response.readEntity(String.class);
		// System.out.println("entity: " + o);
		// response.close();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		RestTemplate template = new RestTemplate();
		// send request and parse result
		ResponseEntity<String> response = template.exchange("http://localhost:8080/retail-ejb/rest/item/create/",
				HttpMethod.POST, entity, String.class);
		System.out.println(response.getBody());
		
		try {
			 item = mapper.readValue(response.getBody(), new TypeReference<ItemDTO>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void findAllItem() {
		String url = "http://localhost:8080/retail-ejb/rest/item/findallitem/";
//		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//		headers.add("Content-Type", "application/json");
//		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		RestTemplate template = new RestTemplate();
		// send request and parse result
		String response = template.getForObject(url, String.class);
		System.out.println(response);
//		JSONArray jsonArr = new JSONArray(response);
//		List list = new ArrayList<>();
//        for (int i = 0; i < jsonArr.length(); i++)
//        {
//        	ItemDTO itemDTO = new ItemDTO();
//            JSONObject jsonObj = jsonArr.getJSONObject(i);
//            itemDTO.setItemId(jsonObj.getInt("id"));
//            itemDTO.setItemDescription(jsonObj.getString("item_desc"));
//            itemDTO.setUnitCost(new Double(jsonObj.get("unit_cost").toString()));
//            itemDTO.setCurrencyCode(jsonObj.getString("currency_code"));
//            list.add(itemDTO);
//        }
		
		/**
		 * Jackson implementation
		 */
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<ItemDTO> list = mapper.readValue(response, new TypeReference<List<ItemDTO>>(){});
			System.out.println(list.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
