/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb.websockets;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.FacesConfig.Version;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * @author JAGRAJ
 *
 */
//@FacesConfig(version = Version.JSF_2_3)
@Named("productUploadManagedBean")
@RequestScoped
//@Model
public class ProductUploadManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4576992460861507497L;
	
    @Inject
	@ManagedProperty("#{param.itemID}")
	private String itemID;
    @Inject
	@ManagedProperty("#{param.unitPrice}")
	private String unitPrice;
    @Inject
	@ManagedProperty("#{param.salePrice}")
	private String salePrice;
	@Inject
	@ManagedProperty("#{param.fileName}")
	private String fileName;
	
	/**
	 * @return the itemID
	 */
	public String getItemID() {
		/*FacesContext facesContext = FacesContext.getCurrentInstance();
		String uploadMe=(String) facesContext.getExternalContext().getRequestParameterMap().get("uploadMe");
		if(itemID==null && uploadMe.equals("true")){
			this.itemID=(String) facesContext.getExternalContext().getRequestParameterMap().get("itemID");		
		}*/
				
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the unitPrice
	 */
	public String getUnitPrice() {
		/*FacesContext facesContext = FacesContext.getCurrentInstance();
		String uploadMe=(String) facesContext.getExternalContext().getRequestParameterMap().get("uploadMe");
		if(unitPrice==null && uploadMe.equals("true")){
			this.unitPrice=(String) facesContext.getExternalContext().getRequestParameterMap().get("unitPrice");		
		}*/
				
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the salePrice
	 */
	public String getSalePrice() {
		/*FacesContext facesContext = FacesContext.getCurrentInstance();
		String uploadMe=(String) facesContext.getExternalContext().getRequestParameterMap().get("uploadMe");
		if(salePrice==null && uploadMe.equals("true")){
			this.salePrice=(String) facesContext.getExternalContext().getRequestParameterMap().get("salePrice");		
		}*/
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		/*FacesContext facesContext = FacesContext.getCurrentInstance();
		String uploadMe=(String) facesContext.getExternalContext().getRequestParameterMap().get("uploadMe");
		if(fileName==null && uploadMe.equals("true")){
			this.fileName=(String) facesContext.getExternalContext().getRequestParameterMap().get("fileName");		
		}*/
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
