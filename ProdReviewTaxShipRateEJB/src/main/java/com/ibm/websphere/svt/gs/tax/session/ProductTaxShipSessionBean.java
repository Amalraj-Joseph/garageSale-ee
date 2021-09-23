package com.ibm.websphere.svt.gs.tax.session;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import com.ibm.websphere.svt.gs.tax.entity.ProdReview;
import com.ibm.websphere.svt.gs.tax.entity.ShipRate;
import com.ibm.websphere.svt.gs.tax.entity.TaxRate;

/**
 * Session Bean implementation class ProductTaxShipSessionBean
 */
@Path("/productTaxShipService")
@Stateless
@Local(ProductTaxShipSessionBeanLocal.class)
@Remote(ProductTaxShipSessionBeanRemote.class)
@TransactionManagement(jakarta.ejb.TransactionManagementType.CONTAINER)
public class ProductTaxShipSessionBean implements ProductTaxShipSessionBeanLocal{

	@EJB 
	private ProdReviewSession prodReviewSession;
	
	@EJB
	private TaxAndShipSingletonSessionBean  taxAndShipRateSingletonBean;
	
	private static String componentName = "com.ibm.websphere.svt.gs.tax.session";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = ProductTaxShipSessionBean.class.getName();

    /**
     * Default constructor. 
     */
    public ProductTaxShipSessionBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
	@GET
	@Path("getAllStatesTaxInfo")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public List<TaxRate> getAllStatesTaxInfo() throws Exception {
		String methodName="getAllStatesTaxInfo";
		logger.logp(Level.FINE, className, methodName, "Getting All States Tax Info");
		return taxAndShipRateSingletonBean.getTaxRateList();
	}
	
	@GET
	@Path("getAllProductsShippingInfo")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public List<ShipRate> getAllProductsShippingInfo() throws Exception {
		String methodName="getAllProductsShippingInfo";
		logger.logp(Level.FINE, className, methodName, "Getting All Products Shipping Info");
		return taxAndShipRateSingletonBean.getShipRateList();
	}
    
	@PUT
	@Path("saveProductReview")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void saveProductReview(ProdReview prodReview) throws Exception {
		String methodName="saveProductReview";
		logger.logp(Level.FINE, className, methodName, "Persist Product review into the Database.");
		prodReviewSession.createProdReview(prodReview);
	}
	/**
	 * 
	 * @param itemId
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("getShipRateByItemID")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public ShipRate getShipRateByItemID(@QueryParam("itemID")String itemID) throws Exception {
		String methodName ="getShipRateByItemID";
		ShipRate shipRate=null;
		try{
			logger.logp(Level.FINE, className, methodName, "Calling getShipRateByItemID");
			shipRate= taxAndShipRateSingletonBean.getShipRateByItemID(itemID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return shipRate;
	}

}
