package com.demo.shopfree.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.shopfree.service.IRetailerService;
import com.retail.services.remote.dto.ItemDTO;
import com.retail.services.remote.dto.RetailerDTO;

@Component
@ManagedBean(name = "retailerController")
@RequestScoped
public class RetailerController {
	
	@Autowired
	@ManagedProperty("#{retailerService}")
	private IRetailerService retailerService;
	private RetailerDTO retailer;
	private DataModel<RetailerDTO> retailerDataTable;
	
	public RetailerController(){
		
	}
	
	public String saveRetailerInfo() {
		retailerService.addRetailerInfo(retailer);
		retailer = null;
		
		return "addretailerinfo.xhtml";
	}

	public IRetailerService getRetailerService() {
		return retailerService;
	}

	public void setRetailerService(IRetailerService retailerService) {
		this.retailerService = retailerService;
	}


	public RetailerDTO getRetailer() {
		if (retailer == null) {
			retailer = new RetailerDTO();
		}
		return retailer;
	}

	public void setRetailer(RetailerDTO retailer) {
		this.retailer = retailer;
	}

	public DataModel<RetailerDTO> getRetailerDataTable() {
		retailerDataTable = new ListDataModel<>(retailerService.findAllRetailers());
		return retailerDataTable;
	}

	public void setRetailerDataTable(DataModel<RetailerDTO> retailerDataTable) {
		this.retailerDataTable = retailerDataTable;
	}
	
	
	
}

