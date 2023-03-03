package com.ibm.websphere.svt.gs.cdi.extensions;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;

public class CDIBean  {
	/**
	 * 
	 */
	//private static final long serialVersionUID = -5398452817321886389L;
	private final Object bean;
	private final Contextual contextual;
	private final CreationalContext creationalContext;
	private final String beanID;

	public CDIBean(Contextual contextual, CreationalContext creationalContext, String beanID) {
		bean = contextual.create(creationalContext);
		this.contextual = contextual;
		this.creationalContext = creationalContext;
		this.beanID=beanID;
	}
	

	public Object getBean() {
		return bean;
	}
	
	public String getBeanID() {
		return beanID;
	}

	public void destroy() {
		contextual.destroy(bean, creationalContext);
	}

	@Override
	public String toString() {
		return "CDIBean{" + "bean=" + bean + '}';
	}
}