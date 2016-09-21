package com.demo.shopfree.service.impl;

import org.springframework.stereotype.Service;

import com.demo.shopfree.service.IProductService;
import com.demo.shopfree.util.WebUtil;
import com.retail.services.remote.ItemService;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	@Override
	public String getHelloMessage(String name) {
		final String jndiName = ItemService.class.getSimpleName() + "!" + ItemService.class.getName();
		ItemService productService = WebUtil.getBean(jndiName);
		return productService.doProcess(name);
	}
}