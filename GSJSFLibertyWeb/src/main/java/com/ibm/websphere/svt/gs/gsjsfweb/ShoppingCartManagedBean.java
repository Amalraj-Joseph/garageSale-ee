/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.websphere.svt.gs.cart.beans.CartItemWrapper;
import com.ibm.websphere.svt.gs.cdi.extensions.CDICustomScoped;
import com.ibm.websphere.svt.gs.cdi.extensions.CDICustomScopedContext;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


/**
 * @author root
 *
 */
@Named("shoppingCartManagedBean")
@CDICustomScoped
public class ShoppingCartManagedBean implements Serializable{
	
	private static final long serialVersionUID = 6400978223722041014L;
	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb";

	private static Logger logger = Logger.getLogger(componentName);
	private static String className = ShoppingCartManagedBean.class.getName();
	private ArrayList<CartItemWrapper> cartItemWrapperList;
	private static final String SCOPE_NAME = "cdiCustomScope";

	
	public ShoppingCartManagedBean () {
	} 
	public ArrayList<CartItemWrapper> getCartItemWrapperList() {
		if(cartItemWrapperList==null){
			cartItemWrapperList= new ArrayList<CartItemWrapper>();
		}
		return cartItemWrapperList;
	}

	public void setCartItemWrapperList(ArrayList<CartItemWrapper> cartItemWrapperList) {
		this.cartItemWrapperList = cartItemWrapperList;
	}

	private String subTotal=null;
	private Date myDate=null;

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

    
    public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	
    // ------------------------------------------------------- Lifecycle Methods



	@PostConstruct
    public void postConstruct() {
    	String methodName="postConstruct";
        FacesContext ctx = FacesContext.getCurrentInstance();
        //Map<String,Object> sessionMap = ctx.getExternalContext().getSessionMap();
        //sessionMap.put(SCOPE_NAME, CDICustomScopedContext.getInstance());
        try{
    		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			//Date currentDate = new Date();
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			String currentDateText=dateFormat.format(calendar.getTime());
			Date parsedCurrentDate=dateFormat.parse(currentDateText);
			this.myDate=parsedCurrentDate;
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
        ctx.getExternalContext().getRequestMap().put("postConstructStatus", "Invoked");
		logger.logp(Level.FINE, className, methodName, "postConstruct invoked");
    }


    @PreDestroy
    public void preDestroy() {
    	String methodName="preDestroy";
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().getRequestMap().put("preDestroyStatus", "Invoked");
		logger.logp(Level.FINE, className, methodName, "preDestroyStatus invoked");
    }


    // ---------------------------------------------------------- Public Methods


    public String destroyScope() {
    	String methodName="destroyScope";
		logger.logp(Level.FINE, className, methodName, "Destroy current scope");
        FacesContext ctx = FacesContext.getCurrentInstance();
        //Map<String,Object> sessionMap = ctx.getExternalContext().getSessionMap();
        //CDICustomScopedContext cdiCustomScopedContext = (CDICustomScopedContext) sessionMap.get(SCOPE_NAME);
        CDICustomScopedContext cdiCustomScopedContext = CDICustomScopedContext.getInstance();
        cdiCustomScopedContext.shutdown();
        //sessionMap.remove(SCOPE_NAME);
        return null;

    }
	

}
