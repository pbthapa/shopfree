/**
 * 
 */
package com.retail.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ruchi.shrestha
 *
 */


@Entity
@Table(name = "retailer")
@SequenceGenerator(name = "RetailerSequence", sequenceName = "retailer_seq", initialValue = 100, allocationSize = 20)
public class Retailer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2723860459861085484L;
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RetailerSequence")
	@Column(name = "retailer_id")
	private Integer retailerId;
	@JsonProperty("retailer_name")
	@Column(name = "retailer_name", nullable = false)
	private String retailerName;
	@JsonProperty("address")
	@Column(name = "address")
	private String address;
	@JsonProperty("phone_no")
	@Column(name = "phone_no")
	private Long phoneNum;
	
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
