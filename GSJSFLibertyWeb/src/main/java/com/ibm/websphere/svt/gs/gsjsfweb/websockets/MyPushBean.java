package com.ibm.websphere.svt.gs.gsjsfweb.websockets;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import java.util.concurrent.locks.*;


@Named
@ApplicationScoped
public class MyPushBean implements Serializable {
   
 private static final Logger LOG = Logger.getLogger(MyPushBean.class.getName());
       
 @Inject
 @Push(channel = "clock")
 private PushContext push;
 
   
 public void clockAction(){
   Calendar now = Calendar.getInstance();       
   String time = now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
   //LOG.log(Level.INFO, "Time: {0}", time);  
   push.send(time);
 }
}
