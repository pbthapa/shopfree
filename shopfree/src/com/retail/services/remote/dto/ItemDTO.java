package com.retail.services.remote.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "item")
public class ItemDTO implements Serializable {

	private static final long serialVersionUID = -1762231067782798404L;

	@JsonProperty("id")
	private Integer itemId;
	@JsonProperty("item_desc")
	private String itemDescription;
	@JsonProperty("unit_cost")
	private Double unitCost;
	@JsonProperty("currency_code")
	private String currencyCode;

	public ItemDTO(Integer itemId, String itemDescription, Double unitCost, String currencyCode) {
		super();
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.unitCost = unitCost;
		this.currencyCode = currencyCode;
	}

	public ItemDTO() {
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
