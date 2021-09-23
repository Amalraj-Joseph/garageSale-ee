package com.ibm.websphere.svt.gs.tax.session;
import java.util.List;

import jakarta.ejb.Remote;
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
 * 
 * @author jagraj
 *
 */
@Path("/productTaxShipServiceRemote")
@Remote
public interface ProductTaxShipSessionBeanRemote {
	@GET
	@Path("getAllStatesTaxInfo")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public List<TaxRate> getAllStatesTaxInfo() throws Exception;
	
	@GET
	@Path("getAllProductsShippingInfo")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public List<ShipRate> getAllProductsShippingInfo() throws Exception;
	
	@GET
	@Path("getShipRateByItemID")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public ShipRate getShipRateByItemID(@QueryParam("itemID")String itemID) throws Exception;
	
	
	@PUT
	@Path("saveProductReview")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void saveProductReview(ProdReview prodReview) throws Exception;
	

}
