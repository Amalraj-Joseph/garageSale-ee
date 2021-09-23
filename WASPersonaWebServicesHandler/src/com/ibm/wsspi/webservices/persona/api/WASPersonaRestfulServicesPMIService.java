/**
 * 
 */
package com.ibm.wsspi.webservices.persona.api;

import java.util.Map;

/**
 * @author JAGRAJ
 *
 */
public interface WASPersonaRestfulServicesPMIService {
	public Map<String,WASPersonaRestfulServicesPMIDataBean> getJAXRSMetricsFromHandler() throws Exception;

}
