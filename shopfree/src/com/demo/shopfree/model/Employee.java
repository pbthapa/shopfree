/**
 * 
 */
package com.demo.shopfree.model;

import java.io.Serializable;

/**
 * @author pushpathapa
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String employeeName;
	private java.util.Date employeeHireDate;
	private Double employeeSalary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public java.util.Date getEmployeeHireDate() {
		return employeeHireDate;
	}

	public void setEmployeeHireDate(java.util.Date employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
