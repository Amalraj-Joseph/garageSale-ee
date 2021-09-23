package com.ibm.websphere.svt.gs.gsjsfweb;

import java.io.Serializable;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * RequestScoped bean to test Java time support
 */
@Named
@RequestScoped
public class MyHTTPServletMappingBean implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    private final FacesContext fc = FacesContext.getCurrentInstance();
	private final ExternalContext exCtx=fc.getExternalContext();
	private final HttpServletResponse response = (HttpServletResponse)exCtx.getResponse();
	private final HttpServletRequest request = (HttpServletRequest) exCtx.getRequest();
	private final HttpServletMapping mapping = request.getHttpServletMapping();
    private final String mappingMatchName = mapping.getMappingMatch().name();
    private final String mappingMatchValue = mapping.getMatchValue();
    private final String mappingPattern = mapping.getPattern();
    private final String mappingServletName = mapping.getServletName();

    public MyHTTPServletMappingBean() {
   	
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext exCtx=fc.getExternalContext();
		HttpServletResponse response = (HttpServletResponse)exCtx.getResponse();
		HttpServletRequest request = (HttpServletRequest) exCtx.getRequest();
		HttpServletMapping mapping = request.getHttpServletMapping();
		String mappingMatchName = mapping.getMappingMatch().name();
		String mappingMatchValue = mapping.getMatchValue();
		String mappingPattern = mapping.getPattern();
		String mappingServletName = mapping.getServletName();
		
    }

    public String getMappingMatchName() {
        return mappingMatchName;
    }

    public String getMappingMatchValue() {
        return mappingMatchValue;
    }

    public String getMappingPattern() {
        return mappingPattern;
    }

    public String getMappingServletName() {
        return mappingServletName;
    }



}
