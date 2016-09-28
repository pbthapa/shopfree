/**
 * 
 */
package com.demo.shopfree.service;

import java.util.List;

import com.retail.services.remote.dto.RetailerDTO;

/**
 * @author ruchi.shrestha
 *
 */
public interface IRetailerService {
	
	public boolean addRetailerInfo(RetailerDTO retailer);
	
	public List findAllRetailers();

}
