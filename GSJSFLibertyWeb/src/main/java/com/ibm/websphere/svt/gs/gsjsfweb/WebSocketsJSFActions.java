/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

import com.ibm.websphere.svt.gs.gsjsfweb.websockets.GarageSaleProdctVideosCacheBean;
import com.ibm.websphere.svt.gs.gsjsfweb.websockets.GarageSaleUploadVideoClientEndpoint;
import com.ibm.websphere.svt.gs.gsjsfweb.websockets.GarageSaleWebSocketsUtil;
import com.ibm.websphere.svt.gs.gsjsfweb.websockets.ProductUploadManagedBean;

/**
 * @author JAGRAJ
 *
 */
@ManagedBean(name="webSocketsJSFActions")
@RequestScoped
public class WebSocketsJSFActions implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -67022638858019141L;
	private static String componentName = "com.ibm.websphere.svt.gs.gsjsfweb";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = WebSocketsJSFActions.class.getName();
	
	@Inject
	private GarageSaleCDIApplicationScopped garageSaleCDIApplicationScopped;
	

	
	@Inject
	private GarageSaleProdctVideosCacheBean garageSaleProdctVideosCacheBean;
	
	@ManagedProperty(name="productUploadManagedBean",value="#{productUploadManagedBean}")
	private ProductUploadManagedBean productUploadManagedBean;
	
	
	/**
	 * @return the productUploadManagedBean
	 */
	public ProductUploadManagedBean getProductUploadManagedBean() {
		return productUploadManagedBean;
	}

	/**
	 * @param productUploadManagedBean the productUploadManagedBean to set
	 */
	public void setProductUploadManagedBean(
			ProductUploadManagedBean productUploadManagedBean) {
		this.productUploadManagedBean = productUploadManagedBean;
	}

	/**
	 * @return the garageSaleProdctVideosCacheBean
	 */
	public GarageSaleProdctVideosCacheBean getGarageSaleProdctVideosCacheBean() {
		return garageSaleProdctVideosCacheBean;
	}

	/**
	 * @param garageSaleProdctVideosCacheBean the garageSaleProdctVideosCacheBean to set
	 */
	public void setGarageSaleProdctVideosCacheBean(
			GarageSaleProdctVideosCacheBean garageSaleProdctVideosCacheBean) {
		this.garageSaleProdctVideosCacheBean = garageSaleProdctVideosCacheBean;
	}



	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String inventoryOnSale() throws Exception{
		String outCome="/facelets/showOnSaleInventory";
		try{
			outCome="/facelets/showOnSaleInventory";
			return outCome;
		}
		catch(Exception e){
			outCome="error";
			return outCome;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String uploadDemos() throws Exception{
		String outCome="/facelets/showOnSaleInventoryForUploads";
		try{
			outCome="/facelets/showOnSaleInventoryForUploads";
			return outCome;
		}
		catch(Exception e){
			outCome="error";
			return outCome;
		}
	}
	
	
	

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String gsDashboard() throws Exception{
		String outCome="/dashboard/gsDashboardFacelet";
		try{
			outCome="/dashboard/gsDashboardFacelet";
			return outCome;
		}
		catch(Exception e){
			outCome="error";
			return outCome;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String webSocketsDashboard() throws Exception{
		String outCome="/dashboard/webSocketsDashboardFacelet";
		try{
			outCome="/dashboard/webSocketsDashboardFacelet";
			return outCome;
		}
		catch(Exception e){
			outCome="error";
			return outCome;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String personaPMIMetricsDashboard() throws Exception{
		String outCome="index.jsf";
		try{
			FacesContext facesContext= FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
			/*ServletContext servletContext = (ServletContext) externalContext.getContext();
			ServletContext pmiWebAppContext = servletContext.getContext("/WASPersonaWebServicesPMIWeb");*/
			String url = garageSaleCDIApplicationScopped.getWebModuleContextPath()+"/"+outCome;
			response.sendRedirect(url);
			return null;
			
		}
		catch(Exception e){
			outCome="error";
			return outCome;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String upload(){
		String methodName="upload";
		String outCome="uploadGarageSaleDemoVideoFileStatus";
		Session session=null;
		try {
			ExternalContext externalContext= FacesContext.getCurrentInstance().getExternalContext();
			WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
			String endPointServerAddress =System.getProperty("GarageSaleWebSocket.endPoint.Address");
			String serverEP =  endPointServerAddress+"/garageSaleProductDemosWebSocketEndpoint/uploadRequest";
			URI serverEndpointURI =null;
			serverEndpointURI = new URI(String.format(serverEP));
			
			ServletContext context = (ServletContext)externalContext.getContext();
			String path=context.getRealPath("resources/videos");
			
			// This is required for the bug in liberty runtime where it does not return real path for videos to be loaded.
			if(path ==null){
            	logger.logp(Level.FINE, className, methodName, "The videos location path is NULL from Servlet context getRealPath() Trying to load videos from path provided in jvm.options ");
				path= GarageSaleWebSocketsUtil.getGarageSaleVideosLocation();
			}
			if(path==null){
	        	logger.logp(Level.SEVERE, className, methodName, "The videos location path is NULL and we can not load videos into memory : Please define path in jvm.options");
				
			}else{
				session =webSocketContainer.connectToServer(GarageSaleUploadVideoClientEndpoint.class, serverEndpointURI);
				Thread.sleep(3000);
	        	if(garageSaleProdctVideosCacheBean.getPublishProductVideos()==null || garageSaleProdctVideosCacheBean.getPublishProductVideos().size()==0){
	        		ConcurrentHashMap<String,ByteBuffer> videosMap= GarageSaleWebSocketsUtil.loadVideosFromFileSystem(path);
	        		garageSaleProdctVideosCacheBean.setPublishProductVideos(videosMap);
	        	}
	        	else if(garageSaleProdctVideosCacheBean.getProductDemoVideosMap()==null || garageSaleProdctVideosCacheBean.getProductDemoVideosMap().size()==0){
	        		ConcurrentHashMap<String,ByteBuffer> videosMap= GarageSaleWebSocketsUtil.loadVideosFromFileSystem(path);
	        		garageSaleProdctVideosCacheBean.setProductDemoVideosMap(videosMap);
	        	}
	        	logger.logp(Level.FINE, className, methodName, "The fileName is :  "+productUploadManagedBean.getFileName());        	
	        	ByteBuffer videoFile=garageSaleProdctVideosCacheBean.getPublishProductVideos().get(productUploadManagedBean.getFileName());
	        	ByteBuffer videoFileCopy= videoFile.duplicate();
	        	
	        	if(videoFileCopy==null){
	            	logger.logp(Level.SEVERE, className, methodName, "The videos file in map is : NULL");
	        	}
	        	videoFileCopy.position(0);
	        	logger.logp(Level.FINE, className, methodName, "The Video file size from client :  "+videoFileCopy.array().length);
	        	session.setMaxBinaryMessageBufferSize(videoFileCopy.array().length);
	        	logger.logp(Level.FINE, className, methodName, "videoFile position: " + videoFileCopy.position() + " limit: " + videoFileCopy.limit());
	           	session.getBasicRemote().sendBinary(videoFileCopy);
			}
			
		} catch (Exception e) {
        	try {
        		if(session!=null){
        			session.close();
        		}
        		session=null;
        		e.printStackTrace();
    		} catch (IOException io) {
    			io.printStackTrace();
    		}
			e.printStackTrace();
			outCome="error";
		} catch (Throwable t){
        	try {
        		if(session!=null){
        			session.close();
        		}
        		session=null;
        		t.printStackTrace();
    		} catch (IOException io) {
    			io.printStackTrace();
    		}
			t.printStackTrace();
			outCome="error";			
		}
		
		return outCome;
	}
}
