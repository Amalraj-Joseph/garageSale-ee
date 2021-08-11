package com.ibm.websphere.svt.gs.gsjsfweb;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.validation.constraints.Past;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MyLastSuperbowlBean implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    private @Past LocalDate lastSuperbowlDate = LocalDate.of(1992, 1, 26);
    //private LocalDate lastSuperbowlDate = LocalDate.of(1992, 1, 26);
    private String redskinsCity = "Washington";

    public MyLastSuperbowlBean() {
    	lastSuperbowlDate = LocalDate.of(1992, 1, 26);    	
    	String redskinsCity = "Washington";
    }

    public LocalDate getLastSuperbowlDate () {
    	return lastSuperbowlDate;
    }

    public String getRedskinsCity() {
    	return redskinsCity;
    }
    
}
