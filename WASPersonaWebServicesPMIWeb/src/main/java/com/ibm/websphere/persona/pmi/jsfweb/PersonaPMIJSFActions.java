/**
 * 
 */
package com.ibm.websphere.persona.pmi.jsfweb;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;

import com.ibm.websphere.persona.pmi.websockets.PersonaWebServicesPMIWebSocketClientEndpoint;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

/**
 * @author JAGRAJ
 *
 */
@Named("personaPMIJSFActions")
@RequestScoped
public class PersonaPMIJSFActions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6381630971575764398L;
	
	//@ManagedProperty(name="personaPMIJSFJsonBean",value="#{personaPMIJSFJsonBean}")
	@Inject
	//@ManagedProperty(value="#{personaPMIJSFJsonBean}")
	private PersonaPMIJSFJsonBean personaPMIJSFJsonBean;
	
	
	
	/**
	 * @return the personaPMIJSFJsonBean
	 */
	public PersonaPMIJSFJsonBean getPersonaPMIJSFJsonBean() {
		return personaPMIJSFJsonBean;
	}

	/**
	 * @param personaPMIJSFJsonBean the personaPMIJSFJsonBean to set
	 */
	public void setPersonaPMIJSFJsonBean(PersonaPMIJSFJsonBean personaPMIJSFJsonBean) {
		this.personaPMIJSFJsonBean = personaPMIJSFJsonBean;
	}

	/**
	 * 
	 */
	public void updatePersonaPMIDashboard(){
		String methodName="updatePersonaPMIDashboard";
		try {
			initiatePersonaPMIDashboardWebSocketRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 */
	public void initiatePersonaPMIDashboardWebSocketRequest(){
		String methodName="initiatePersonaPMIDashboardWebSocketRequest";
		Session session=null;
		try {
			WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
			String endPointServerAddress =System.getProperty("PersonaPMIMetrics.endPoint.Address");
			String serverEP =  endPointServerAddress+"/personaWebServicesPMIWebSocketEndpoint";
			URI serverEndpointURI =null;
			serverEndpointURI = new URI(String.format(serverEP));
			
			session =webSocketContainer.connectToServer(PersonaWebServicesPMIWebSocketClientEndpoint.class, serverEndpointURI);
			personaPMIJSFJsonBean.setPersonaPMIJsonData(PersonaPMIStaticData.getPersonaPMIJsonData());
		} catch (Exception e) {
        	try {
        		if(session!=null){
        			session.close();
        		}
        		session=null;
    		} catch (IOException io) {
    			io.printStackTrace();
    		}
			e.printStackTrace();
		}

		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public void welcomePage() throws Exception{
		String outCome="facelets/welcomeUser.jsf";
		FacesContext facesContext= FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		//HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
		try{
			String url = getParentWebModuleContextPath()+"/"+outCome;
			externalContext.redirect(url);
		}
		catch(Exception e){
			outCome="error.jsf";
			String url = getParentWebModuleContextPath()+"/"+outCome;
			externalContext.redirect(url);			
		}
	}
	
    /**
     * 
     * @throws Exception
     */
    public String getParentWebModuleContextPath() throws Exception{
    	
    		
    		FacesContext facesContext= FacesContext.getCurrentInstance();
    		ExternalContext externalContext = facesContext.getExternalContext();
    		ServletContext servletContext = (ServletContext) externalContext.getContext();
    		ServletContext pmiWebAppContext = servletContext.getContext("/GSjsf40LibertyWeb");
    		String uri = pmiWebAppContext.getContextPath();
    		return uri;
    }
	

}
