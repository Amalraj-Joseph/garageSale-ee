package com.ibm.websphere.persona.pmi.jsfweb;

import jakarta.annotation.Resource;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

import com.ibm.wsspi.webservices.persona.api.WASPersonaRestfulServicesPMIService;
import com.ibm.wsspi.webservices.persona.api.WASPersonaWebServicesPMIService;

@ManagedBean(name="myJSFManagedBean")
@RequestScoped
public class MyJSFManagedBean {
	@Resource(lookup="personaWebServicesPMIService")
	private WASPersonaWebServicesPMIService personaWebServicesPMIService;
	
	@Resource(lookup="personaRestfulervicesPMIService")
	private WASPersonaRestfulServicesPMIService personaRestfulervicesPMIService;
	
	


}
