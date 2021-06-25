package com.ibm.websphere.svt.gs.gsjsfweb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ibm.websphere.svt.gs.cinfocc.CInfo;
import com.ibm.websphere.svt.gs.gsdb.jaxws.client.CustomerInfoWrapper;
import com.ibm.websphere.svt.gs.gsjsfweb.exceptions.GSJSF12WebException;
import com.ibm.websphere.svt.gs.gsjsfweb.utils.GSJSFWebUtil;


@ManagedBean(name="ee8Info")
@ViewScoped
public class EE8Info implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7635593566795244961L;
	
	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = EE8Info.class.getName();
	
	public String gotoee8Info() {
		String methodName = "gotoee8Info";
		
		String custID = GSJSFWebUtil.getUserID();
	    
	    if (custID == null ) {
			logger.logp(Level.SEVERE, className, methodName, "Severe error Customer ID is null: ");
	    	return "foundNull";
	    }

		return "gotoee8";
	}

}
