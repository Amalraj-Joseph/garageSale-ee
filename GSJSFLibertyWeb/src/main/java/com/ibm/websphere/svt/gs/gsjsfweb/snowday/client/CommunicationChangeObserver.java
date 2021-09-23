package com.ibm.websphere.svt.gs.gsjsfweb.snowday.client;

import com.ibm.websphere.svt.gs.gsjsfweb.snowday.SnowDayEvent;

import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.ObservesAsync;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class CommunicationChangeObserver {
    private static final Logger LOGGER = Logger.getLogger(CommunicationChangeObserver.class.getName());

    public void sendDetailedReport(@ObservesAsync SnowDayEvent weatherEvent) {
        //LOGGER.log(Level.INFO, "ASYNC : start sendEmail");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            //LOGGER.warning("Interrupted exception");
            Thread.currentThread().interrupt();
        }
        weatherEvent.addEvent("ASYNCH : Communication, detailed email report sent");

        //LOGGER.log(Level.INFO, "ASYNC : end sendEmail");
    }
}
