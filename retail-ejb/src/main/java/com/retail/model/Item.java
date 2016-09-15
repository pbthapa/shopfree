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

/**
 * @author pushpathapa
 *
 */
@Entity(name = "item")
@Table(name = "item")
@SequenceGenerator(name = "ItemSequence", sequenceName = "item_seq", initialValue = 100, allocationSize = 20)
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemSequence")
	@Column(name = "item_id")
	private Integer itemId;
	@Column(name = "item_description", nullable = false)
	private String itemDescription;
	@Column(name = "unit_cost", scale = 2)
	private Double unitCost;
	@Column(name = "currency_code")
	private String currencyCode;

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
