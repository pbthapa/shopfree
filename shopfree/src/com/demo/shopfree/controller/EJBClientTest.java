package com.demo.shopfree.controller;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.retail.services.remote.ItemService;

public class EJBClientTest {

	public static void main(String[] args) throws NamingException, IOException {

		EjbConfig config = new EjbConfig();
		ItemService helloWorld = (ItemService) config.myBean();
		System.out.println(helloWorld.doProcess("Pushpa"));
	}


}
