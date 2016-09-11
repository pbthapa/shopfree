package com.retail.services.ejb;

import javax.ejb.Stateless;

import com.retail.services.remote.ProductService;

//@Stateless(mappedName="ProductService/remote")
@Stateless(name = "ProductService")
public class ProductServiceBean implements ProductService {

	public String doProcess(String value) {

		return "Heello " + value + "!!!!!!";

	}

}
