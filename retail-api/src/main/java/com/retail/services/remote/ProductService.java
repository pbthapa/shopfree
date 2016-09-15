package com.retail.services.remote;

import javax.ejb.Remote;

import com.retail.services.remote.dto.ItemDTO;

@Remote
public interface ProductService {

	public String doProcess(String value);

	public ItemDTO addProduct(ItemDTO item);

	public void deleteProduct(int id);

	public Object updateProduct(Object obj);

	public Object getProductBySearchCriteria(Object obj);
}
