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
public class WASPersonaWebServicesPMIDataBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	private String operationName;
	private String serviceType;
	private AtomicLong atomicLong;
	private long currentCount;

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
	
	@Override
	public String toString() {
		return "WASPersonaWebServicesPMIDataBean [serviceName=" + serviceName
				+ ", operationName=" + operationName + ", serviceType="
				+ serviceType + ", currentCount=" + currentCount + "]";
	}
	
	/**
	 * 
	 * @return
	 */
	public JSONObject getJSONObject(){
		
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("serviceType", this.serviceType);
		jsonObject.put("serviceName", this.serviceName);
		jsonObject.put("operationName", this.operationName);
		jsonObject.put("currentCount", this.currentCount);
		
		return jsonObject;
		
	}
	

}
