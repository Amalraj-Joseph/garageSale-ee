/**
 * 
 */
package com.ibm.wsspi.webservices.persona.api;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import com.ibm.json.java.JSONObject;

/**
 * @author JAGRAJ
 *
 */
public class WASPersonaRestfulServicesPMIDataBean implements Serializable{
	
	/**
	 * This class holds PMI stasts for RestfulWebServices
	 */
	private static final long serialVersionUID = 1L;
	private String requestURI;
	private String serviceType;
	private AtomicLong atomicLong;
	private long currentCount;
	private String contextRoot;
	private String serviceName;
	private String operationName;
	
	
	/**
	 * 
	 * @return
	 */
	public String getContextRoot() {
		return contextRoot;
	}
	
	/**
	 * 
	 * @param contextRoot
	 */
	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}
	/**
	 * 
	 * @return
	 */
	public long getCurrentCount() {
		return currentCount;
	}
	/**
	 * 
	 * @param currentCount
	 */
	public void setCurrentCount(long currentCount) {
		this.currentCount = currentCount;
	}
	
	/**
	 * 
	 * @param atomicLong
	 */
	public void setAtomicLong(AtomicLong atomicLong) {
		this.atomicLong = atomicLong;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * 
	 * @param serviceType
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	/**
	 * 
	 * @return
	 */
	public AtomicLong getAtomicLong() {
		return atomicLong;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRequestURI() {
		return requestURI;
	}
	/**
	 * 
	 * @param requestURI
	 */
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOperationName() {
		return operationName;
	}
	
	/**
	 * 
	 * @param operationName
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}


	
	@Override
	public String toString() {
		return "WASPersonaRestfulServicesPMIDataBean [requestURI=" + requestURI
				+ ", serviceType=" + serviceType + ", atomicLong=" + atomicLong
				+ ", currentCount=" + currentCount + ", contextRoot="
				+ contextRoot + ", serviceName=" + serviceName
				+ ", operationName=" + operationName + "]";
	}

	/**
	 * 
	 * @return
	 */
	public JSONObject getJSONObject(){
		
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("serviceType", this.serviceType);
		jsonObject.put("requestURI", this.requestURI);
		jsonObject.put("contextRoot", this.contextRoot);
		jsonObject.put("currentCount", this.currentCount);
		jsonObject.put("serviceName",serviceName);
		jsonObject.put("operationName",operationName);
		
		return jsonObject;
	}
		

}
