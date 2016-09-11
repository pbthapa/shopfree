package com.demo.shopfree.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class WebUtil {

	private static final String PROPERTY_FILE = "/com/demo/shopfree/properties/jboss-ejb-client.properties";
	private static final String EAR_EJB_PATH = "ejb:retail-ear/retail-ejb-0.0.1-SNAPSHOT/";

	public static <E> E getBean(String jndi) {
		Properties prop = new Properties();
		InitialContext context = null;
		InputStream inputStream = null;
		try {
			inputStream = WebUtil.class.getResourceAsStream(PROPERTY_FILE);
			prop.load(inputStream);
			context = new InitialContext(prop);
			return (E) context.lookup(EAR_EJB_PATH + jndi);
		} catch (IOException a) {
			return null;
		} catch (NamingException b) {
			return null;
		} finally {
			context = null;
			inputStream = null;
		}
	}

}
