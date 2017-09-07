/**
 * 
 */
package com.ibm.wsspi.webservices.persona.api;

import java.util.Map;

/**
 * @author JAGRAJ
 *
 */
public interface WASPersonaWebServicesPMIService {
	public Map<String,WASPersonaWebServicesPMIDataBean> getJAXWSMetricsFromHandler() throws Exception;

}
