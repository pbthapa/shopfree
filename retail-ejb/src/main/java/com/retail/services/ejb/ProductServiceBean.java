package com.retail.services.ejb;

import javax.ejb.Stateless;

import com.retail.services.remote.ProductService;

@Stateless(name = "ProductService")
public class ProductServiceBean implements ProductService {

	public String doProcess(String value) {

		return "Heello " + value + "!!!!!!";

	}

	@Override
	public Object addProduct(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object updateProduct(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProductBySearchCriteria(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
