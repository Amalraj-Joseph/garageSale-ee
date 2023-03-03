package com.ibm.websphere.svt.gs.cdi.extensions;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.faces.context.FacesContext;

public class CDICustomScopedContext implements Context {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8440457732154247510L;
	private ConcurrentHashMap<String, CDIBean> context = null;
	private  static CDICustomScopedContext INSTANCE = new CDICustomScopedContext();
	private boolean active;

	private CDICustomScopedContext() {
		context = new ConcurrentHashMap<String, CDIBean>();
		active = true;
	}
	

	public static CDICustomScopedContext getInstance() {
		return INSTANCE;
	}

	@Override
	public Class<? extends Annotation> getScope() {
		return CDICustomScoped.class;
	}

	@Override
	public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
		//System.out.println("Context: " + context + " Contextual " + contextual + " CreationalContext: " + creationalContext);
		FacesContext ctx = FacesContext.getCurrentInstance();
		String sessionID = ctx.getExternalContext().getSessionId(false);
		final Bean bean = (Bean) contextual;
		final String beanName = bean.getBeanClass().getName();
		final String beanID = beanName + sessionID;
		final T foundBean = get(contextual);
		if (foundBean != null) {
			return foundBean;
		} else {
			final CDIBean cdiBean = new CDIBean(contextual, creationalContext,beanID);
			context.put(beanID, cdiBean);
			return (T) cdiBean.getBean();
		}
	}

	@Override
	public <T> T get(Contextual<T> contextual) {
		//System.out.println("---Contextual: " + contextual);
		FacesContext ctx = FacesContext.getCurrentInstance();
		String sessionID = ctx.getExternalContext().getSessionId(false);
		final String beanName = ((Bean) contextual).getBeanClass().getName();
		final String beanID = beanName + sessionID;
		final CDIBean cdiBean = context.get(beanID);
		if (cdiBean == null) {
			return null;
		}
		return (T) cdiBean.getBean();
	}

	@Override
	public boolean isActive() {
		//System.out.println("isActive : "+active);
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Map<String, CDIBean> getBeanContext() {
		return context;
	}

	public void shutdown() {
		for (final CDIBean contextual : context.values()) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			String sessionID = ctx.getExternalContext().getSessionId(false);
			if (contextual.getBeanID().contains(sessionID)) {
				contextual.destroy();
			}
		}
	}

}
