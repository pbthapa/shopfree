/**
 * 
 */
package com.demo.shopfree.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.shopfree.service.IProductService;
import com.retail.services.remote.dto.EmployeeDTO;
import com.retail.services.remote.dto.ItemDTO;

/**
 * @author pushpathapa
 *
 */
@Component
@ManagedBean(name = "adminController")
@RequestScoped
public class AdminController {

	@Autowired
	@ManagedProperty("#{productService}")
	private IProductService productService;
	private EmployeeDTO employee;
	private ItemDTO item;
	private DataModel<ItemDTO> itemDataTable;

	public AdminController() {
	}

	@PostConstruct
	public void init() {
	}
	
	public String saveItem() {
		productService.addItem(item);
		return "itemlist.xhtml";
	}

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

	public ItemDTO getItem() {
		if (item == null) {
			item = new ItemDTO();
		}
		return item;
	}

	public void setItem(ItemDTO item) {
		this.item = item;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public DataModel<ItemDTO> getItemDataTable() {
		if(itemDataTable == null) {
			itemDataTable = new ListDataModel<>(productService.findAllItem());
		}
		return itemDataTable;
	}

	public void setItemDataTable(DataModel<ItemDTO> itemDataTable) {
		this.itemDataTable = itemDataTable;
	}
}
