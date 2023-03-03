package com.ibm.websphere.svt.gs.gsjsfweb.actions;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.websphere.svt.gs.gsjsfweb.utils.GarageSaleLargeSessionUtil;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Named("logout")
@RequestScoped
public class LogoutAction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3210934679445701756L;

	private static final String LOGOUT_OUTCOME = "logout";
	private static String componentName = "com.ibm.websphere.svt.gs.actions";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = LogoutAction.class.getName();
	private static ConcurrentHashMap<String, Object> cookieAtributes = new ConcurrentHashMap<String, Object>();


	public String logout() {
		String methodName="logout";
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext exCtx=fc.getExternalContext();
		HttpServletResponse response = (HttpServletResponse)exCtx.getResponse();
		HttpServletRequest request = (HttpServletRequest) exCtx.getRequest();
		
		HttpSession session = request.getSession(false);
		/*
		 * Adding this new feature for faces 4.0 Jakarta EE10 release
		 */
		cookieAtributes.put("maxAge",0);
		if(GarageSaleLargeSessionUtil.LS_TEST_ENABLE!=null && (GarageSaleLargeSessionUtil.LS_TEST_ENABLE).equalsIgnoreCase("true")){
			String customerName=(String)session.getAttribute("custID");
			int maxUserSession=GarageSaleLargeSessionUtil.LS_TEST_USER_RANGE_MAX;
			int currentUserNumber=Integer.parseInt(customerName.substring(4));
			if(currentUserNumber <= maxUserSession){
				logger.logp(Level.FINEST, className, methodName, "Large Session Test Session is not invalidated");
			}
			else{
				/*
				 * Adding this new feature for faces 4.0 Jakarta EE10 release
				 */
				if(exCtx.isSecure()) {
					exCtx.addResponseCookie("currentUserLogin", "", cookieAtributes);
				}
				session.invalidate();
				
			}
		}
		else{
			/*
			 * Adding this new feature for faces 4.0 Jakarta EE10 release
			 */
			if(exCtx.isSecure()) {
				exCtx.addResponseCookie("currentUserLogin", "", cookieAtributes);
			}
			session.invalidate();
		}
		fc.responseComplete();
		try {
			//response.sendRedirect("logout.html");
			response.sendRedirect(request.getContextPath() + "/logout.html");			
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Added for Servlet 4.0
/* 	
		HttpServletMapping mapping = request.getHttpServletMapping();
		String mappingS = mapping.getMappingMatch().name();
		String value = mapping.getMatchValue();
		String pattern = mapping.getPattern();
		String servletName = mapping.getServletName();
		
		System.out.println("logging out and printing Servlet 4.0 mapping values: ");
		System.out.println("-- mapping.getMappingMatch().name() = "+mappingS);
		System.out.println("-- mapping.getMatchValue() = "+value);
		System.out.println("-- mapping.getPattern() = "+pattern);
		System.out.println("-- mapping.getServletName() = "+servletName);
		System.out.println("end of printing Servlet 4.0 mapping values");	
*/			
		// End of Added for Servlet 4.0

		return null;
		//return LOGOUT_OUTCOME;
	}
	
	@PostConstruct
	public void postCreate(){
		
	    logger.fine("RequestScopeSample bean is created");
	}
	
	@PreDestroy
	public void preDestroy(){
	    logger.fine("RequestScopeSample bean is destroyed");
	}


}
