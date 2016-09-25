package com.demo.shopfree.service;

import java.util.List;

import com.retail.services.remote.dto.ItemDTO;

public interface IProductService {
	
	public String getHelloMessage(String name);
	
	public 	ItemDTO findItemById(String id);
	
	public ItemDTO addItem(ItemDTO item);

	public List findAllItem();

}
