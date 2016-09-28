/**
 * 
 */
package com.retail.services.remote;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

/**
 * @author ruchi.shrestha
 *
 */

@Remote
public interface RetailerService {
	
	public Response addRetailerInfo(String json);
	
	public Response findAllRetailers();

}
