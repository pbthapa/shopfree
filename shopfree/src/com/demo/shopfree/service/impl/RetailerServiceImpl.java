/**
 * 
 */
package com.demo.shopfree.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.demo.shopfree.service.IRetailerService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.services.remote.dto.RetailerDTO;

/**
 * @author ruchi.shrestha
 *
 */

@Service("retailerService")
public class RetailerServiceImpl implements IRetailerService{
	
	private static final String JNDI_URL = System.getenv("DEV.JNDI.URL");

	@Override
	public boolean addRetailerInfo(RetailerDTO retailer) {
		
		String url = JNDI_URL + "/retailer/add/";
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(retailer);
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
			retailer = mapper.readValue(response.getBody(), new TypeReference<RetailerDTO>() {
			});
		} catch (Exception e) {
		}
		return true;

	}

	@Override
	public List findAllRetailers() {
		String url = JNDI_URL + "/retailer/findallretailer/";
		RestTemplate template = new RestTemplate();
		String response = template.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<RetailerDTO> list = mapper.readValue(response, new TypeReference<List<RetailerDTO>>() {
			});
			return list;
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}
}


