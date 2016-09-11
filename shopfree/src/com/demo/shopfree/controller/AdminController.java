/**
 * 
 */
package com.demo.shopfree.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.shopfree.model.Employee;
import com.demo.shopfree.service.IProductService;

/**
 * @author pushpathapa
 *
 */
@ManagedBean(name = "adminController", eager = true)
@RequestScoped
public class AdminController {

	@Autowired
	private IProductService productService;
	private Employee employee;

	// @RequestMapping("/welcome")
	// public ModelAndView helloWorld() throws NamingException, IOException {
	//
	// String message = productService.getHelloMessage("Pushpa");
	// return new ModelAndView("register", "message", message);
	// }

	public String register() {
		employee = new Employee();
		return null;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}