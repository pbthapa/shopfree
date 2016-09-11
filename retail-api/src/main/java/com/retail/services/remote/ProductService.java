package com.retail.services.remote;

import javax.ejb.Remote;

@Remote
public interface ProductService {

	public String doProcess(String value);

	public Object addProduct(Object obj);

	public void deleteProduct(int id);

	public Object updateProduct(Object obj);

	public Object getProductBySearchCriteria(Object obj);
}
