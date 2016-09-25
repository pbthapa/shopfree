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
 * @author pushpathapa
 *
 */
@XmlRootElement(name = "item")
@Entity
@Table(name = "item")
@SequenceGenerator(name = "ItemSequence", sequenceName = "item_seq", initialValue = 100, allocationSize = 20)
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemSequence")
	@Column(name = "item_id")
	private Integer itemId;
	@JsonProperty("item_desc")
	@Column(name = "item_description", nullable = false)
	private String itemDescription;
	@JsonProperty("unit_cost")
	@Column(name = "unit_cost", scale = 2)
	private Double unitCost;
	@JsonProperty("currency_code")
	@Column(name = "currency_code")
	private String currencyCode;

	public Integer getItemId() {
		return itemId;
	}

	@XmlAttribute(name = "id")
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	@XmlElement(name = "item_desc")
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	@XmlElement(name = "unit_cost")
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	@XmlElement(name = "currency_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
