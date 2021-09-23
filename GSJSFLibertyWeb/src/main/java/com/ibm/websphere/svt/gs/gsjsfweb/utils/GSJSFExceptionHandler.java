/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.faces.FacesException;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.application.ViewExpiredException;
import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.ExceptionHandlerWrapper;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ExceptionQueuedEvent;
import jakarta.faces.event.ExceptionQueuedEventContext;

/**
 * @author JAGRAJ
 * 
 */
public class GSJSFExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;
	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb.utils";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = GSJSFExceptionHandler.class.getName();
	

	public GSJSFExceptionHandler(ExceptionHandler wrapped) {

		this.wrapped = wrapped;

	}

	@Override
	public ExceptionHandler getWrapped() {

		return this.wrapped;

	}

	@Override
	public void handle() throws FacesException, ViewExpiredException {
		
		String methodName="handle";
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator(); i.hasNext();) {

			ExceptionQueuedEvent event = i.next();

			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();

			Throwable t = context.getException();
			// if (t instanceof ViewExpiredException) {

			// ViewExpiredException vee = (ViewExpiredException) t;
			
			FacesContext fc = FacesContext.getCurrentInstance();

			Map<String, Object> requestMap = fc.getExternalContext()
					.getRequestMap();

			NavigationHandler nav =
			fc.getApplication().getNavigationHandler();

			try {
				logger.logp(Level.SEVERE, className, methodName, "Severe Error is "+t.getMessage());
				t.printStackTrace();
				String redirectPage="/error.xhtml";	
				//fc.getExternalContext().redirect(fc.getExternalContext().getRequestContextPath() + (redirectPage != null ? redirectPage : ""));
				nav.handleNavigation(fc, null, "error");
				fc.renderResponse();
				fc.responseComplete();
				//fc.release();

			} /*catch (IOException e) {
				// TODO Auto-generated catch block
				logger.logp(Level.SEVERE, className, methodName, "Severe Error is "+e);
				e.printStackTrace();
			} */finally {

				i.remove();
			}

			// }

		}

		getWrapped().handle();

	}

}
