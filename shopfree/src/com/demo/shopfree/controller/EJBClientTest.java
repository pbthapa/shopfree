package com.demo.shopfree.controller;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.retail.services.remote.ProductService;

public class EJBClientTest {

	public static void main(String[] args) throws NamingException, IOException {

		EjbConfig config = new EjbConfig();
		ProductService helloWorld = (ProductService) config.myBean();
		System.out.println(helloWorld.doProcess("Pushpa"));
	}


}
