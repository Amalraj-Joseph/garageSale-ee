package com.ibm.wsspi.webservices.persona.handler;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.ibm.wsspi.webservices.handler.Handler;
import com.ibm.wsspi.webservices.handler.HandlerConstants;
import com.ibm.wsspi.webservices.persona.api.WASPersonaRestfulServicesPMIService;
import com.ibm.wsspi.webservices.persona.api.WASPersonaWebServicesPMIService;

public class WASPersonaWebServicesHandlerActivator implements BundleActivator {

	
	private static String componentName = "com.ibm.wsspi.webservices.persona.handler";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = WASPersonaWebServicesHandlerActivator.class.getName();

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		String methodName="start(BundleContext context)";
    	logger.logp(Level.FINE, className, methodName, "Entered into start method");
		
		//JAX-WS Handler Activation
		final Hashtable<String, Object> handlerProps = new Hashtable<String, Object>();
		WASPersonaWebServicesHandler wasPersonaWebServicesHandler=new WASPersonaWebServicesHandler();
        handlerProps.put(HandlerConstants.ENGINE_TYPE, HandlerConstants.ENGINE_TYPE_JAXWS);
        handlerProps.put(HandlerConstants.FLOW_TYPE, HandlerConstants.FLOW_TYPE_IN);
        handlerProps.put(HandlerConstants.IS_CLIENT_SIDE, true);
        handlerProps.put(HandlerConstants.IS_SERVER_SIDE, true);
        handlerProps.put(org.osgi.framework.Constants.SERVICE_RANKING, 3);
        handlerProps.put("osgi.jndi.service.name", "personaWebServicesHandler");
        context.registerService(Handler.class, wasPersonaWebServicesHandler, handlerProps);
    	logger.logp(Level.INFO, className, methodName, "Registered Persona JAXWSHandler as 'personaWebServicesHandler' JNDI name");

        // Registering PMI service as for JNDI lookup.
        final Hashtable<String, Object> jaxwsDataServiceProps = new Hashtable<String, Object>();
        jaxwsDataServiceProps.put("osgi.jndi.service.name", "personaWebServicesPMIService");
        context.registerService(WASPersonaWebServicesPMIService.class,wasPersonaWebServicesHandler,jaxwsDataServiceProps);
    	logger.logp(Level.INFO, className, methodName, "Registered Persona JAXWSHandler DataAccessService as 'personaWebServicesPMIService' JNDI name");
        
      //JAX-RS Handler Activation
		final Hashtable<String, Object> handlerJAXRSProps = new Hashtable<String, Object>();
		WASPersonaRestfulServicesHandler wasPersonaRestfulServicesHandler=new WASPersonaRestfulServicesHandler();
		handlerJAXRSProps.put(HandlerConstants.ENGINE_TYPE, HandlerConstants.ENGINE_TYPE_JAXRS);
		handlerJAXRSProps.put(HandlerConstants.FLOW_TYPE, HandlerConstants.FLOW_TYPE_IN);
		handlerJAXRSProps.put(HandlerConstants.IS_CLIENT_SIDE, true);
		handlerJAXRSProps.put(HandlerConstants.IS_SERVER_SIDE, true);
		handlerJAXRSProps.put(org.osgi.framework.Constants.SERVICE_RANKING, 1);
		handlerJAXRSProps.put("osgi.jndi.service.name", "personaRestfulServicesHandler");
        context.registerService(Handler.class, wasPersonaRestfulServicesHandler, handlerJAXRSProps);
        
    	logger.logp(Level.INFO, className, methodName, "Registered Persona JAXRSHandler as 'personaRestfulServicesHandler' JNDI name");
        // Registering PMI service as for JNDI lookup.
        final Hashtable<String, Object> jaxrsDataServiceProps = new Hashtable<String, Object>();
        jaxrsDataServiceProps.put("osgi.jndi.service.name", "personaRestfulServicesPMIService");
        context.registerService(WASPersonaRestfulServicesPMIService.class,wasPersonaRestfulServicesHandler,jaxrsDataServiceProps);
    	logger.logp(Level.INFO, className, methodName, "Registered Persona JAXRSHandler DataAccessService as 'personaRestfulServicesPMIService' JNDI name");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		
	}

}
