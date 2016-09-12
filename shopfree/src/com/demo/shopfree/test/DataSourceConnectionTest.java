package com.demo.shopfree.test;

import com.demo.shopfree.util.WebUtil;
import com.retail.services.remote.ProductService;

public class DataSourceConnectionTest {

	public static void main(String[] args) {
		final String jndiName = ProductService.class.getSimpleName() + "!" + ProductService.class.getName();
		ProductService productService = WebUtil.getBean(jndiName);
		System.out.println(productService.doProcess("Pushpa"));
	}
}
