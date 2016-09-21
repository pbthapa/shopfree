package com.demo.shopfree.test;

import com.demo.shopfree.util.WebUtil;
import com.retail.services.remote.ItemService;

public class DataSourceConnectionTest {

	public static void main(String[] args) {
		final String jndiName = ItemService.class.getSimpleName() + "!" + ItemService.class.getName();
		ItemService productService = WebUtil.getBean(jndiName);
		System.out.println(productService.doProcess("Pushpa"));
	}
}
