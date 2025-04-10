package com.ibm.websphere.svt.gs.tax.session;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath(value="/rest")
public class ProductTaxShipSessionApplication extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ProductTaxShipSessionBean.class);
		return classes;
	}

}
