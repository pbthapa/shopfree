package com.retail.services.remote.dto;

import java.io.Serializable;

public class ItemDTO implements Serializable {

	private static final long serialVersionUID = -1762231067782798404L;

	private Integer itemId;
	private String itemDescription;
	private Double unitCost;
	private String currencyCode;

	public ItemDTO(Integer itemId, String itemDescription, Double unitCost, String currencyCode) {
		super();
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.unitCost = unitCost;
		this.currencyCode = currencyCode;
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
