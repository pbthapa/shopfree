package com.retail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name="item")
@Entity
@Table(name="item")
@SequenceGenerator(name="ItemSequence", sequenceName="item_seq", initialValue=100, allocationSize=20)
public class Item
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ItemSequence")
  @Column(name="item_id")
  private Integer itemId;

  @JsonProperty("item_desc")
  @Column(name="item_description", nullable=false)
  private String itemDescription;

  @JsonProperty("unit_cost")
  @Column(name="unit_cost", scale=2)
  private Double unitCost;

  @JsonProperty("currency_code")
  @Column(name="currency_code", length=3)
  private String currencyCode;

  @JsonProperty("item_code")
  @Column(name="item_code", nullable=false, length=8)
  private String itemCode;

  @ManyToOne
  @JoinColumn(name="parent_item_id", referencedColumnName="item_id")
  private Item parentItem;

  @OneToOne
  @JoinColumn(name="item_dept_id")
  private Department dept;

  @Column(name="item_level", length=10)
  private String itemLevel;

  public Integer getItemId()
  {
    return this.itemId;
  }

  @XmlAttribute(name="id")
  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public String getItemDescription() {
    return this.itemDescription;
  }

  @XmlElement(name="item_desc")
  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public Double getUnitCost() {
    return this.unitCost;
  }

  @XmlElement(name="unit_cost")
  public void setUnitCost(Double unitCost) {
    this.unitCost = unitCost;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  @XmlElement(name="currency_code")
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getItemCode() {
    return this.itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public Item getParentItem() {
    if (this.parentItem == null) {
      this.parentItem = new Item();
    }
    return this.parentItem;
  }

  public void setParentItem(Item parentItem) {
    this.parentItem = parentItem;
  }

  public Department getDept() {
    if (this.dept == null) {
      this.dept = new Department();
    }
    return this.dept;
  }

  public void setDept(Department dept) {
    this.dept = dept;
  }

  public String getItemLevel() {
    return this.itemLevel;
  }

  public void setItemLevel(String itemLevel) {
    this.itemLevel = itemLevel;
  }
}