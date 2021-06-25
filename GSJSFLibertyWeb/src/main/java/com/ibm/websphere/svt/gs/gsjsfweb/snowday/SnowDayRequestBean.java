package com.ibm.websphere.svt.gs.gsjsfweb.snowday;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.inject.Named;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;


@Named
public class SnowDayRequestBean {
    private static final Logger LOGGER = Logger.getLogger(SnowDayRequestBean.class.getName());

	@Inject
	@SnowDayType(value = "emergency")
	Event<SnowDayEvent> emergencyEvent;
	   
    //@NotEmpty
    private String weather;
    //@NotNull
    private Boolean waitForEmail;
    //@NotNull
    private Boolean isEmergency;

    public SnowDayRequestBean() {
    	emergencyEvent = null;
    	weather = "sunny";
    	waitForEmail = Boolean.FALSE;
    	isEmergency = Boolean.FALSE;
    }
    
    public String getWeather() {
        //System.out.println("in getWeather");
        return weather;
    }

    public void setWeather(String weather) {
        //System.out.println("in setWeather : "+weather);
        this.weather = weather;        
    }

    public Boolean getWaitForEmail() {
        //System.out.println("in getWaitForEmail");
        return waitForEmail;
    }

    public void setWaitForEmail(Boolean waitForAsynchEvents) {
        //System.out.println("in setWaitForEmail");
        this.waitForEmail = waitForAsynchEvents;
    }

    public Boolean getEmergency() {
        //System.out.println("in getEmergency");
        return isEmergency;
    }

    public void setEmergency(Boolean emergency) {
        //System.out.println("in setEmergency");
        isEmergency = emergency;
    }
    
    public void fireAsyncEmergency() {
        //LOGGER.log(Level.INFO, "in fireAsyncEmergency");
        //System.out.println("in fireAsyncEmergency");
        emergencyEvent.fireAsync(new SnowDayEvent(weather));
        //LOGGER.log(Level.INFO, "immediately after fireAsync command");
        //System.out.println("immediately after fireAsync command");       
        try {
         Thread.sleep(1000);
        } catch (InterruptedException e) {
         //LOGGER.log(Level.INFO, "InterruptedException in fireAsyncEmergency");
         //System.out.println("InterruptedException in fireAsyncEmergency");
        }
        //LOGGER.log(Level.INFO, "leaving fireAsyncEmergency");
        //System.out.println("leaving fireAsyncEmergency");
    }
}