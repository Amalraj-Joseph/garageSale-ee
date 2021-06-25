package com.ibm.websphere.svt.gs.gsjsfweb.websockets;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
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