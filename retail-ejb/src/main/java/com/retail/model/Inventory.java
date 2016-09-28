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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name="item")
@Entity
@Table(name="item_inventory")
@SequenceGenerator(name="InvSequence", sequenceName="inv_seq", initialValue=100, allocationSize=20)
public class Inventory
  implements Serializable
{
  private static final long serialVersionUID = 8552914954053114954L;

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="InvSequence")
  @Column(name="inv_id")
  private Integer inventoryId;

  @JsonProperty("inv_bucket")
  @Column(name="inv_bucket", nullable=false)
  private String itemBucket;

  @JsonProperty("total_stock_on_hand")
  @Column(name="total_stock_on_hand")
  private Integer totalStockOnHand;

  @JsonProperty("reserved_qty")
  @Column(name="reserved_qty")
  private Integer reservedQty;

  @ManyToOne
  @JoinColumn(name="inv_sku_id", referencedColumnName="item_id")
  private Item sku;

  public Integer getInventoryId()
  {
    return this.inventoryId;
  }

  @XmlElement(name="id")
  public void setInventoryId(Integer inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getItemBucket() {
    return this.itemBucket;
  }

  @XmlElement(name="inv_bucket")
  public void setItemBucket(String itemBucket) {
    this.itemBucket = itemBucket;
  }

  public Integer getTotalStockOnHand() {
    return this.totalStockOnHand;
  }

  @XmlElement(name="total_stock_on_hand")
  public void setTotalStockOnHand(Integer totalStockOnHand) {
    this.totalStockOnHand = totalStockOnHand;
  }

  public Integer getReservedQty() {
    return this.reservedQty;
  }

  @XmlElement(name="reserved_qty")
  public void setReservedQty(Integer reservedQty) {
    this.reservedQty = reservedQty;
  }

  public Item getSku() {
    if (this.sku == null) {
      this.sku = new Item();
    }
    return this.sku;
  }

  public void setSku(Item sku) {
    this.sku = sku;
  }
}