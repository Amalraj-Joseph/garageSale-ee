package com.ibm.websphere.svt.gs.gsjsfweb;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.validation.constraints.Past;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MyWebSphereCreationBean implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    private @Past LocalDate firstWebSphereDate = LocalDate.of(1998, 6, 22);
    private String websphereBrand = "IBM WebSphere Performance Pack";

    public MyWebSphereCreationBean() {
    	firstWebSphereDate = LocalDate.of(1998, 6, 22);    	
    	String websphereBrand = "IBM WebSphere Performance Pack";
    }

    public LocalDate getFirstWebSphereDate () {
    	return firstWebSphereDate;
    }

    public String getWebSphereBrand() {
    	return websphereBrand;
    }
    
}
