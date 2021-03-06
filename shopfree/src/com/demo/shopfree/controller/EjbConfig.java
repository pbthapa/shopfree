package com.demo.shopfree.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.retail.services.remote.ItemService;

public class EjbConfig {

	private static final String JNDI_NAME = "ejb:retail-ear/retail-ejb-0.0.1-SNAPSHOT/ProductService!"
			+ "com.retail.services.remote.ProductService";

	public ItemService myBean() throws NamingException, IOException {			
		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put("endpoint.name","client-endpoint");
		prop.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		prop.put("remote.connections","default");
		prop.put("remote.connection.default.host", "localhost");
		prop.put("remote.connection.default.port", "8080");
		prop.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
		prop.put("remote.connection.default.username", "ejb-client");
		prop.put("remote.connection.default.password", "UHdkMTIzNCs=");
		prop.put("org.jboss.ejb.client.scoped.context", true);
		prop.put("jboss.naming.client.ejb.context",true);

		InitialContext context = new InitialContext(prop);
		System.out.println("Context lookup finisehed");

		ItemService remote = lookup(context);
		//IHelloWorldRemote remote = createEjbProxy(context, JNDI_NAME, IBean.class);
		return remote;
	}
	
	private static ItemService lookup(InitialContext context) {
		ItemService h = null;
		try {
			h = (ItemService) context.lookup(JNDI_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return h;

	}
}
