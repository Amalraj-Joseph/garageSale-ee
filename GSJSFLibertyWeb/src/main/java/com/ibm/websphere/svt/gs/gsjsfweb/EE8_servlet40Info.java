package com.ibm.websphere.svt.gs.gsjsfweb;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.websphere.svt.gs.gsjsfweb.utils.GSJSFWebUtil;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named("ee8_servlet40Info")
@ViewScoped
public class EE8_servlet40Info implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7635593566795244961L;
	
	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = EE8_servlet40Info.class.getName();
	
	public String gotoee8_servlet40Info() {
		String methodName = "gotoee8_servlet40Info";
		
		String custID = GSJSFWebUtil.getUserID();
	    
	    if (custID == null ) {
			logger.logp(Level.SEVERE, className, methodName, "Severe error Customer ID is null: ");
	    	return "foundNull";
	    }

		return "gotoee8_servlet40";
	}

}
