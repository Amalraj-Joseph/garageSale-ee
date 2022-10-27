package com.ibm.websphere.persona.pmi.jsfweb;

import com.ibm.wsspi.webservices.persona.api.WASPersonaRestfulServicesPMIService;
import com.ibm.wsspi.webservices.persona.api.WASPersonaWebServicesPMIService;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

//@Named(name="myJSFManagedBean")
//@RequestScoped
@Named("myJSFManagedBean")
@RequestScoped
public class MyJSFManagedBean {
	@Resource(lookup="personaWebServicesPMIService")
	private WASPersonaWebServicesPMIService personaWebServicesPMIService;
	
	@Resource(lookup="personaRestfulervicesPMIService")
	private WASPersonaRestfulServicesPMIService personaRestfulervicesPMIService;
	
	


}
