package com.retail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="customer")
@SequenceGenerator(name="CustomerSequence", sequenceName="customer_seq", initialValue=100, allocationSize=20)
public class Customer
  implements Serializable
{
  private static final long serialVersionUID = -5358352753835271269L;

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CustomerSequence")
  @Column(name="customer_id")
  private Integer customerId;

  @JsonProperty("first_name")
  @Column(name="first_name", nullable=false, length=50)
  private String firstName;

  @JsonProperty("middle_name")
  @Column(name="middle_name", length=50)
  private String middleName;

  @JsonProperty("last_name")
  @Column(name="last_name", nullable=false, length=50)
  private String lastName;

  @JsonProperty("user_name")
  @Column(name="user_name", nullable=false, unique=true, length=10)
  private String username;

  @JsonProperty("password")
  @Column(name="password", nullable=false, length=50)
  private String password;

  @JsonProperty("confirm_password")
  @Transient
  private String confirmPassword;

  @JsonProperty("email_id")
  @Column(name="email_id", nullable=false, length=50)
  private String emailId;

  @JsonProperty("confirm_email_id")
  @Transient
  private String confirmEmailId;

  @JsonProperty("contact_number")
  @Column(name="contact_number", nullable=false, length=50)
  private String contactNumber;

  @JsonProperty("confirm_contact_number")
  @Transient
  private String confirmContactNumber;

  @JsonProperty("registered_since")
  @Column(name="registered_since", nullable=false)
  private Timestamp registeredSince;

  @OneToMany(mappedBy="customer")
  private Set<CustomerAddress> customerAddress_;

  public Integer getCustomerId()
  {
    return this.customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return this.confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getEmailId() {
    return this.emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getConfirmEmailId() {
    return this.confirmEmailId;
  }

  public void setConfirmEmailId(String confirmEmailId) {
    this.confirmEmailId = confirmEmailId;
  }

  public String getContactNumber() {
    return this.contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getConfirmContactNumber() {
    return this.confirmContactNumber;
  }

  public void setConfirmContactNumber(String confirmContactNumber) {
    this.confirmContactNumber = confirmContactNumber;
  }

  public Timestamp getRegisteredSince() {
    return this.registeredSince;
  }

  public void setRegisteredSince(Timestamp registeredSince) {
    this.registeredSince = registeredSince;
  }

  public Set<CustomerAddress> getCustomerAddress_() {
    return this.customerAddress_;
  }

  public void setCustomerAddress_(Set<CustomerAddress> customerAddress_) {
    this.customerAddress_ = customerAddress_;
  }
}