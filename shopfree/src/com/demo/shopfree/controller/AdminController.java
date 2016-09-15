/**
 * 
 */
package com.demo.shopfree.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.shopfree.service.IProductService;
import com.retail.services.remote.dto.EmployeeDTO;

/**
 * @author pushpathapa
 *
 */
@ManagedBean(name = "adminController", eager = true)
@RequestScoped
public class AdminController {

	@Autowired
	private IProductService productService;
	private EmployeeDTO employee;

	// @RequestMapping("/welcome")
	// public ModelAndView helloWorld() throws NamingException, IOException {
	//
	// String message = productService.getHelloMessage("Pushpa");
	// return new ModelAndView("register", "message", message);
	// }

	public String register() {
		employee = new EmployeeDTO();
		return null;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
}
