/**
 * 
 */
package com.retail.services.remote.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ruchi.shrestha
 *
 */


public class RetailerDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7751562648066229238L;
	
	@JsonProperty("id")
	private Integer retailerId;
	@JsonProperty("retailer_name")
	private String retailerName;
	@JsonProperty("address")
	private String address;
	@JsonProperty("phone_no")
	private Long phoneNum;
	
	public RetailerDTO(Integer retailerId, String retailerName, String address, Long phoneNum) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public RetailerDTO() {
	}

	public Integer getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Integer retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	


}
