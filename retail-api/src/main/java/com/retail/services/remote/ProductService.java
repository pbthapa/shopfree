package com.retail.services.remote;

import javax.ejb.Remote;

@Remote
public interface ProductService {

	public String doProcess(String value);
}
