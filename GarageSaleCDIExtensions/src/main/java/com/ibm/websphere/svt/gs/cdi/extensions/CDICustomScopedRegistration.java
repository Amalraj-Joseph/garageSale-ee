package com.ibm.websphere.svt.gs.cdi.extensions;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.Extension;

public class CDICustomScopedRegistration implements Extension {

	public void afterBeanDiscovery(@Observes AfterBeanDiscovery event, BeanManager manager) {
        event.addContext(CDICustomScopedContext.getInstance());
        System.out.println("Contextd: " + event);
	}
}
