/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb.utils;

import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.ExceptionHandlerFactory;



/**
 * @author JAGRAJ
 *
 */
public class GSJSFExceptionHandlerFactory extends ExceptionHandlerFactory{

    private ExceptionHandlerFactory parent;
    
    
    
    public GSJSFExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }
 
 
 
    @Override
 
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler result = parent.getExceptionHandler();
        result = new GSJSFExceptionHandler(result);
        return result;
    }
 
	

}
