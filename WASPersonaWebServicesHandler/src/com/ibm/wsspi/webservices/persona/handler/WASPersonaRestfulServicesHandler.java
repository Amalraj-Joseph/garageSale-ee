/**
 * 
 */
package com.ibm.wsspi.webservices.persona.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.http.HttpServletRequest;

import com.ibm.wsspi.webservices.handler.GlobalHandlerMessageContext;
import com.ibm.wsspi.webservices.handler.Handler;
import com.ibm.wsspi.webservices.persona.api.WASPersonaRestfulServicesPMIDataBean;
import com.ibm.wsspi.webservices.persona.api.WASPersonaRestfulServicesPMIService;

/**
 * @author JAGRAJ
 *
 */
public class WASPersonaRestfulServicesHandler implements Handler, WASPersonaRestfulServicesPMIService{
	
	private static String componentName = "com.ibm.wsspi.webservices.persona.handler";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = WASPersonaRestfulServicesHandler.class.getName();

	private static Map<String,WASPersonaRestfulServicesPMIDataBean> jaxRSOperationsDictionary= new ConcurrentHashMap<String,WASPersonaRestfulServicesPMIDataBean>();

	@Override
	public void handleFault(GlobalHandlerMessageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMessage(GlobalHandlerMessageContext messageContext) throws Exception {
		String methodName="handleMessage";
    	logger.logp(Level.FINE, className, methodName, "Entered into handleMessage method");
        HttpServletRequest servletRequest = messageContext.getHttpServletRequest();
		Iterator<String> propertyNames=messageContext.getPropertyNames();
        while(propertyNames!=null && propertyNames.hasNext()){
        	String propertyName=propertyNames.next();
	        logger.logp(Level.FINE, className, methodName, "+++++++++ The Property name is :  "+ propertyName+"  and its Value is:   "+messageContext.getProperty(propertyName)+"++++++++ ");
        }
        logger.logp(Level.FINE, className, methodName, "The requestURI is  : "+servletRequest.getRequestURI());
		
		String key = 	servletRequest.getRequestURI();
		if(jaxRSOperationsDictionary !=null){
			WASPersonaRestfulServicesPMIDataBean currentDataBean=jaxRSOperationsDictionary.get(key);
			if(currentDataBean==null){
				currentDataBean = new WASPersonaRestfulServicesPMIDataBean();
				currentDataBean.setRequestURI(key);
				currentDataBean.setAtomicLong(new AtomicLong());
				currentDataBean.setCurrentCount(currentDataBean.getAtomicLong().incrementAndGet());
				currentDataBean.setServiceType("JAX-RS");
				currentDataBean.setContextRoot(servletRequest.getContextPath());
				currentDataBean.setOperationName(getFormattedString(currentDataBean.getRequestURI(), "/", 1));
				currentDataBean.setServiceName(getFormattedString(currentDataBean.getRequestURI(), "/", 2));
			}
			else{
				currentDataBean.setCurrentCount(currentDataBean.getAtomicLong().incrementAndGet());
			}
			jaxRSOperationsDictionary.put(key,currentDataBean);
			logger.logp(Level.FINE, className, methodName, "Begin ##################### WASPersonaRestfulServicesHandler ################### Begin");
			logger.logp(Level.FINE, className, methodName, "The Data is +++++++:  "+ currentDataBean.toString()+"+++++++");
			logger.logp(Level.FINE, className, methodName, "End ###################### WASPersonaRestfulServicesHandler r################## End");

		}
	}
	
	@Override
	public Map<String,WASPersonaRestfulServicesPMIDataBean> getJAXRSMetricsFromHandler() throws Exception{
		return jaxRSOperationsDictionary;
	}
	
	/**
	 * 
	 * @param requestURI
	 * @param formatString
	 * @param recursiveNum
	 * @return
	 * @throws Exception
	 */
	private String getFormattedString(String requestURI,String formatString, int position) throws Exception{
		String methodName="getFormattedString";
		String formattedString="unExpectedURI";
    	logger.logp(Level.FINE, className, methodName, "The request is requestURI  formatString recursiveNum : " +requestURI+":"+formatString+":"+position);
		ArrayList<String> list= new ArrayList<String>();
		if(requestURI!=null && requestURI.indexOf(formatString)!=-1){
			StringTokenizer stringTokenizer = new StringTokenizer(requestURI, formatString);
			while(stringTokenizer.hasMoreElements() ){
				list.add((String)stringTokenizer.nextElement());
			}
	    	logger.logp(Level.FINE, className, methodName, "The List size is : "+list.size());
			if(list.size()==1){
				formattedString= list.get(0);
			}
			else if(list.size() >1){
				formattedString = list.get(list.size()-position);
			}
		}
    	logger.logp(Level.FINE, className, methodName, "The Formatted String is : "+formattedString);
		return formattedString;
		
		
	}

}
