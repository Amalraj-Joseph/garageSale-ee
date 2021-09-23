//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.gsdb.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;

@WebServiceClient(name = "GarageSaleStoreManagerService", targetNamespace = "http://session.gsdb.gs.svt.websphere.ibm.com/", wsdlLocation = "META-INF/wsdl/GarageSaleStoreManagerService.wsdl")
public class GarageSaleStoreManagerService
    extends Service
{

    private final static URL GARAGESALESTOREMANAGERSERVICE_WSDL_LOCATION;
    private final static WebServiceException GARAGESALESTOREMANAGERSERVICE_EXCEPTION;
    private final static QName GARAGESALESTOREMANAGERSERVICE_QNAME = new QName("http://session.gsdb.gs.svt.websphere.ibm.com/", "GarageSaleStoreManagerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("META-INF/wsdl/GarageSaleStoreManagerService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GARAGESALESTOREMANAGERSERVICE_WSDL_LOCATION = url;
        GARAGESALESTOREMANAGERSERVICE_EXCEPTION = e;
    }

    public GarageSaleStoreManagerService() {
        super(__getWsdlLocation(), GARAGESALESTOREMANAGERSERVICE_QNAME);
    }

    public GarageSaleStoreManagerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GARAGESALESTOREMANAGERSERVICE_QNAME, features);
    }

    public GarageSaleStoreManagerService(URL wsdlLocation) {
        super(wsdlLocation, GARAGESALESTOREMANAGERSERVICE_QNAME);
    }

    public GarageSaleStoreManagerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GARAGESALESTOREMANAGERSERVICE_QNAME, features);
    }

    public GarageSaleStoreManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GarageSaleStoreManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GarageSaleStoreManagerLocal
     */
    @WebEndpoint(name = "GarageSaleStoreManagerPort")
    public GarageSaleStoreManagerLocal getGarageSaleStoreManagerPort() {
        return super.getPort(new QName("http://session.gsdb.gs.svt.websphere.ibm.com/", "GarageSaleStoreManagerPort"), GarageSaleStoreManagerLocal.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GarageSaleStoreManagerLocal
     */
    @WebEndpoint(name = "GarageSaleStoreManagerPort")
    public GarageSaleStoreManagerLocal getGarageSaleStoreManagerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://session.gsdb.gs.svt.websphere.ibm.com/", "GarageSaleStoreManagerPort"), GarageSaleStoreManagerLocal.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GARAGESALESTOREMANAGERSERVICE_EXCEPTION!= null) {
            throw GARAGESALESTOREMANAGERSERVICE_EXCEPTION;
        }
        return GARAGESALESTOREMANAGERSERVICE_WSDL_LOCATION;
    }

}
