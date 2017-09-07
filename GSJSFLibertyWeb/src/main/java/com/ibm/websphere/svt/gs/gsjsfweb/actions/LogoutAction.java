package com.ibm.websphere.svt.gs.gsjsfweb.actions;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.websphere.svt.gs.gsjsfweb.utils.GarageSaleLargeSessionUtil;

@ManagedBean(name="logout")
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

	public String logout() {
		String methodName="logout";
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext exCtx=fc.getExternalContext();
		HttpServletResponse response = (HttpServletResponse)exCtx.getResponse();
		HttpServletRequest request = (HttpServletRequest) exCtx.getRequest();
		
		HttpSession session = request.getSession(false);
		if(GarageSaleLargeSessionUtil.LS_TEST_ENABLE!=null && (GarageSaleLargeSessionUtil.LS_TEST_ENABLE).equalsIgnoreCase("true")){
			String customerName=(String)session.getAttribute("custID");
			int maxUserSession=GarageSaleLargeSessionUtil.LS_TEST_USER_RANGE_MAX;
			int currentUserNumber=Integer.parseInt(customerName.substring(4));
			if(currentUserNumber <= maxUserSession){
				logger.logp(Level.FINEST, className, methodName, "Large Session Test Session is not invalidated");
			}
			else{
				session.invalidate();
			}
		}
		else{
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
