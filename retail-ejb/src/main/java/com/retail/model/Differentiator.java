package com.retail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name="diff")
@Entity
@Table(name="diff_detail")
@SequenceGenerator(name="DiffSequence", sequenceName="diff_seq", initialValue=100, allocationSize=20)
public class Differentiator
  implements Serializable
{
  private static final long serialVersionUID = 7539760147377487159L;

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DiffSequence")
  @Column(name="diff_id")
  private Integer diffId;

  @JsonProperty("diff_name")
  @Column(name="diff_name", nullable=false)
  private String diffName;

  public Integer getDiffId()
  {
    return this.diffId;
  }

  @XmlAttribute(name="diff_id")
  public void setDiffId(Integer diffId) {
    this.diffId = diffId;
  }

  public String getDiffName() {
    return this.diffName;
  }

  @XmlElement(name="diff_name")
  public void setDiffName(String diffName) {
    this.diffName = diffName;
  }
}