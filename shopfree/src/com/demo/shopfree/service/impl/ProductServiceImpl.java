package com.demo.shopfree.service.impl;

import org.springframework.stereotype.Service;

import com.demo.shopfree.service.IProductService;
import com.demo.shopfree.util.WebUtil;
import com.retail.services.remote.ProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	@Override
	public String getHelloMessage(String name) {
		final String jndiName = ProductService.class.getSimpleName() + "!" + ProductService.class.getName();
		ProductService productService = WebUtil.getBean(jndiName);
		return productService.doProcess(name);
	}
}