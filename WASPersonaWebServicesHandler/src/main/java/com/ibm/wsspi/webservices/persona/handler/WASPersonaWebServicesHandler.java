/**
 * 
 */
package com.ibm.wsspi.webservices.persona.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.wsspi.webservices.handler.GlobalHandlerMessageContext;
import com.ibm.wsspi.webservices.handler.Handler;
import com.ibm.wsspi.webservices.persona.api.WASPersonaWebServicesPMIDataBean;
import com.ibm.wsspi.webservices.persona.api.WASPersonaWebServicesPMIService;

/**
 * @author JAGRAJ
 *
 */
public class WASPersonaWebServicesHandler implements Handler, WASPersonaWebServicesPMIService{
	private static String componentName = "com.ibm.wsspi.webservices.persona.handler";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = WASPersonaWebServicesHandler.class.getName();


	
	private static Map<String,WASPersonaWebServicesPMIDataBean> jaxWSOperationsDictionary= new ConcurrentHashMap<String,WASPersonaWebServicesPMIDataBean>();

	@Override
	public void handleFault(GlobalHandlerMessageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMessage(GlobalHandlerMessageContext messageContext) throws Exception {
		String methodName="handleMessage";
    	logger.logp(Level.FINE, className, methodName, "Entered into handleMessage method");
		
		String key = 
				messageContext.getProperty(javax.xml.ws.handler.MessageContext.WSDL_SERVICE).toString()+","+messageContext.getProperty(javax.xml.ws.handler.MessageContext.WSDL_OPERATION).toString();
		
		if(jaxWSOperationsDictionary !=null){
			WASPersonaWebServicesPMIDataBean currentDataBean=jaxWSOperationsDictionary.get(key);
			if(currentDataBean==null){
				currentDataBean = new WASPersonaWebServicesPMIDataBean();
				currentDataBean.setServiceName(getFormattedString(messageContext.getProperty(javax.xml.ws.handler.MessageContext.WSDL_SERVICE).toString(), "}"));
				currentDataBean.setOperationName(getFormattedString(messageContext.getProperty(javax.xml.ws.handler.MessageContext.WSDL_OPERATION).toString(), "}"));
				currentDataBean.setAtomicLong(new AtomicLong());
				currentDataBean.setCurrentCount(currentDataBean.getAtomicLong().incrementAndGet());
				currentDataBean.setServiceType("JAX-WS");
			}
			else{
				currentDataBean.setCurrentCount(currentDataBean.getAtomicLong().incrementAndGet());
			}
			jaxWSOperationsDictionary.put(key,currentDataBean);
			logger.logp(Level.FINE, className, methodName, "Begin ##################### WASPersonaWebServicesHandler ################### Begin");
			logger.logp(Level.FINE, className, methodName, "The Data is +++++++:  "+ currentDataBean.toString()+"+++++++");
			logger.logp(Level.FINE, className, methodName, "End ###################### WASPersonaWebServicesHandle r################## End");

		}
	}
	
	@Override
	public Map<String,WASPersonaWebServicesPMIDataBean> getJAXWSMetricsFromHandler() throws Exception{
		return jaxWSOperationsDictionary;
	}
	
	/**
	 * 
	 * @param inputString
	 * @param formatString
	 * @return
	 */
	private String getFormattedString(String inputString,String formatString) throws Exception{
		String methodName="getFormatedString";
    	logger.logp(Level.FINE, className, methodName, "Entered into getFormatedString method");
		String formattedString="";
		if(inputString !=null ){
			int index=inputString.lastIndexOf(formatString);
			if (index!=-1 && index!=inputString.length()){
				formattedString=inputString.substring(index+1);
				
			}
		}
		return formattedString;
	}

}
