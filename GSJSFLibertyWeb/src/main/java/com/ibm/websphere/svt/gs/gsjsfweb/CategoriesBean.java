/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.model.DataModel;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * @author root
 *
 */
//@Named(name="categoriesBean")
//@RequestScoped
@Named
@RequestScoped

public class CategoriesBean {
	/**
	 * @return the garageSaleJSFActions
	 */
	public GarageSaleJSFActions getGarageSaleJSFActions() {
		return garageSaleJSFActions;
	}

	/**
	 * @param garageSaleJSFActions the garageSaleJSFActions to set
	 */
	public void setGarageSaleJSFActions(GarageSaleJSFActions garageSaleJSFActions) {
		this.garageSaleJSFActions = garageSaleJSFActions;
	}

	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb";
	
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = CategoriesBean.class.getName();
	@SuppressWarnings("rawtypes")
	private transient DataModel categoriesDataModel=null;
	@SuppressWarnings("rawtypes")
	private transient DataModel tempCategoriesDataModel=null;
	//@ManagedProperty(name="garageSaleJSFActions",value="#{garageSaleJSFActions}")
	@Inject
    private GarageSaleJSFActions garageSaleJSFActions;


	public CategoriesBean(){
    	logger.logp(Level.FINER, className, "constructor", "constructing ...");
		//GSJSFController categoryManagedBean=new GSJSFController();
		if(tempCategoriesDataModel==null){
			this.tempCategoriesDataModel=garageSaleJSFActions.getCategories();
		}
    	
	}
	
	@SuppressWarnings("rawtypes")
	public DataModel getCategoriesDataModel() {
		String methodName="getCategoriesDataModel";
    	logger.logp(Level.FINER, className,methodName,"Inside getCategoriesDataModel" );
		//GSJSFController categoryManagedBean=new GSJSFController();
		FacesContext facesContext=FacesContext.getCurrentInstance();
		Flash flashScope = facesContext.getExternalContext().getFlash();
		this.categoriesDataModel=(DataModel) flashScope.get("categoriesDataModel");
		if(categoriesDataModel==null){
	    	logger.logp(Level.FINER, className,methodName,"Categories Data Model Not in Flash scope" );
	    	if(tempCategoriesDataModel!=null){
		    	logger.logp(Level.FINER, className,methodName,"Set tempCategoriesDataModel into Flash scope" );
		    	flashScope.put("categoriesDataModel", tempCategoriesDataModel);
	    	}
	    	else{
		    	logger.logp(Level.SEVERE, className,methodName,"Categories can not be null" );
	    	}
			
		}
		else {
	    	logger.logp(Level.FINE, className,methodName,"Category DataModel is pulled from Flash scope" );
	    	setCategoriesDataModel(categoriesDataModel);
		}
		return categoriesDataModel;
	}

	@SuppressWarnings("rawtypes")
	public void setCategoriesDataModel(DataModel categoriesDataModel) {
		this.categoriesDataModel = categoriesDataModel;
	}
	
	

}
