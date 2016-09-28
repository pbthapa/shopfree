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
@XmlRootElement(name="dept")
@Entity
@Table(name="dept")
@SequenceGenerator(name="DeptSequence", sequenceName="dept_seq", initialValue=100, allocationSize=20)
public class Department
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DeptSequence")
  @Column(name="dept_id")
  private Integer deptId;

  @JsonProperty("dept_name")
  @Column(name="dept_name", nullable=false, length=100)
  private String deptName;

  public Integer getDeptId()
  {
    return this.deptId;
  }

  @XmlAttribute(name="id")
  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  public String getDeptName() {
    return this.deptName;
  }

  @XmlElement(name="dept_name")
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
}