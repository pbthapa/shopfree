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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name="customer_address")
@Entity
@Table(name="customer_address")
@SequenceGenerator(name="AddrSequence", sequenceName="addr_seq", initialValue=100, allocationSize=20)
public class CustomerAddress
  implements Serializable
{
  private static final long serialVersionUID = 1962607267985262619L;

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AddrSequence")
  @Column(name="address_id")
  private Integer addressId;

  @JsonProperty("default_address")
  @Column(name="default_address", nullable=false)
  private Boolean defaultAddress;

  @JsonProperty("address_type")
  @Column(name="address_type", length=20, nullable=false)
  private String addressType;

  @JsonProperty("street_name")
  @Column(name="street_name", length=100)
  private String streetName;

  @JsonProperty("city")
  @Column(name="city", length=50)
  private String city;

  @JsonProperty("state")
  @Column(name="state", length=50)
  private String state;

  @JsonProperty("country")
  @Column(name="country", length=50)
  private String country;

  @ManyToOne
  @JoinColumn(name="customer_id", nullable=false)
  private Customer customer;

  public Integer getAddressId()
  {
    return this.addressId;
  }

  @XmlAttribute(name="address_id")
  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Boolean getDefaultAddress() {
    return this.defaultAddress;
  }

  @XmlElement(name="default_address")
  public void setDefaultAddress(Boolean defaultAddress) {
    this.defaultAddress = defaultAddress;
  }

  public String getAddressType() {
    return this.addressType;
  }

  @XmlElement(name="address_type")
  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public String getStreetName() {
    return this.streetName;
  }

  @XmlElement(name="street_name")
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getCity() {
    return this.city;
  }

  @XmlElement(name="city")
  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  @XmlElement(name="state")
  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return this.country;
  }

  @XmlElement(name="country")
  public void setCountry(String country) {
    this.country = country;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}