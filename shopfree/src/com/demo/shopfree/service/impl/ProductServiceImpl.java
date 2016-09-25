package com.demo.shopfree.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.demo.shopfree.service.IProductService;
import com.demo.shopfree.util.WebUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.services.remote.ItemService;
import com.retail.services.remote.dto.ItemDTO;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	private static final String JNDI_URL = System.getenv("DEV.JNDI.URL");

	/**
	 * THIS METHOD IS IMPLEMENTED USING JNDI LOOKUP ON AS SERVER DO NOT USE THIS
	 * METHOD. IT WON'T WORK. NOW EJB CALL IS MADE BY RESTFUL WS
	 */
	@Override
	public String getHelloMessage(String name) {
		final String jndiName = ItemService.class.getSimpleName() + "!" + ItemService.class.getName();
		ItemService productService = WebUtil.getBean(jndiName);
		return productService.doProcess(name);
	}

	@Override
	public ItemDTO findItemById(String id) {
		String url = JNDI_URL + "/item/" + id;
		RestTemplate template = new RestTemplate();
		String result = template.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		ItemDTO item = null;
		try {
			item = mapper.readValue(result, new TypeReference<ItemDTO>() {
			});
		} catch (Exception e) {
		}
		return item;
	}

	@Override
	public ItemDTO addItem(ItemDTO item) {
		String url = JNDI_URL + "/item/create/";
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(item);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		RestTemplate template = new RestTemplate();
		// send request and parse result
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);
		try {
			item = mapper.readValue(response.getBody(), new TypeReference<ItemDTO>() {
			});
		} catch (Exception e) {
		}
		return item;
	}

	@Override
	public List findAllItem() {
		String url = JNDI_URL + "/item/findallitem/";
		RestTemplate template = new RestTemplate();
		String response = template.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<ItemDTO> list = mapper.readValue(response, new TypeReference<List<ItemDTO>>() {
			});
			return list;
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}
}