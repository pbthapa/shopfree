package com.demo.shopfree.test;

import com.demo.shopfree.util.WebUtil;
import com.retail.services.remote.ProductService;
import com.retail.services.remote.dto.ItemDTO;

public class ItemOperationTest {

	public static void main(String[] args) {
		final String jndiName = ProductService.class.getSimpleName() + "!" + ProductService.class.getName();
		ProductService productService = WebUtil.getBean(jndiName);
		ItemDTO itemDto = productService.addProduct(new ItemDTO(null, "Polo", 12.00, "USD"));
		System.out.println("[ " + itemDto.getItemId() + ", " + itemDto.getItemDescription() + ", "
				+ itemDto.getCurrencyCode() + ", " + itemDto.getUnitCost() + " ]");
	}
}
