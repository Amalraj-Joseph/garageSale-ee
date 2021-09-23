/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.Interceptors;

import com.ibm.websphere.svt.gs.ccdb.jaxws.client.GarageSaleCCManagerLocal;
import com.ibm.websphere.svt.gs.gsdb.jaxws.client.GarageSaleStoreManagerLocal;
import com.ibm.websphere.svt.gs.wsbankdb.jaxws.client.GarageSaleBankManagerLocal;

/**
 * @author JAGRAJ
 *
 */

@ApplicationScoped
@Interceptors(GarageSaleWSClientCDIInterceptor.class)
public class GarageSaleCDIWSClientUtil {
	
	
	public GarageSaleCDIWSClientUtil(){
	}
	
	
	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb.utils";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = GarageSaleCDIWSClientUtil.class.getName();
	private static final String CLIENTSIDE = "<====CCCCC ";
	
	private GarageSaleCCManagerLocal ccManager;
	private GarageSaleStoreManagerLocal storeManager;
	private GarageSaleBankManagerLocal bankManager;
	
	
	/**
	 * 
	 * @return
	 */
	public GarageSaleCCManagerLocal getCcManager() {
		return ccManager;
	}
	
	/**
	 * 
	 * @param ccManager
	 */
	public void setCcManager(GarageSaleCCManagerLocal ccManager) {
		this.ccManager = ccManager;
	}
	/**
	 * 
	 * @return
	 */
	public GarageSaleStoreManagerLocal getStoreManager() {
		return storeManager;
	}
	/**
	 * 
	 * @param storeManager
	 */
	public void setStoreManager(GarageSaleStoreManagerLocal storeManager) {
		this.storeManager = storeManager;
	}
	
	/**
	 * 
	 * @return
	 */
	public GarageSaleBankManagerLocal getBankManager() {
		return bankManager;
	}
	
	/**
	 * 
	 * @param bankManager
	 */
	public void setBankManager(GarageSaleBankManagerLocal bankManager) {
		this.bankManager = bankManager;
	}

	/**
	 * 
	 * @param storeManager
	 * @return
	 */
	public GarageSaleStoreManagerLocal injectStoreManagerEndPoint(GarageSaleStoreManagerLocal storeManager){
		String methodName="injectStoreManagerEndPoint";
        logger.logp(Level.FINER, className, methodName, "Calling Interceptor method to Override WebService Endpoint address.");
		return storeManager;
	}
	
	public GarageSaleCCManagerLocal injectCCManagerEndPoint(GarageSaleCCManagerLocal ccManager){
		String methodName="injectCCManagerEndPoint";
        logger.logp(Level.FINER, className, methodName, "Calling Interceptor method to Override WebService Endpoint address.");
		return ccManager;
	}
	
	public GarageSaleBankManagerLocal injectBankManagerEndPoint(GarageSaleBankManagerLocal bankManager){
		String methodName="injectBankManagerEndPoint";
        logger.logp(Level.FINER, className, methodName, "Calling Interceptor method to Override WebService Endpoint address.");
		return bankManager;
	}
	
}
