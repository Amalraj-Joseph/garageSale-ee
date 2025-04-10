//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.ccdb.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;

@WebServiceClient(name = "GarageSaleCCManagerService", targetNamespace = "http://session.ccdb.gs.svt.websphere.ibm.com/", wsdlLocation = "META-INF/wsdl/GarageSaleCCManagerService.wsdl")
public class GarageSaleCCManagerService
    extends Service
{

    private final static URL GARAGESALECCMANAGERSERVICE_WSDL_LOCATION;
    private final static WebServiceException GARAGESALECCMANAGERSERVICE_EXCEPTION;
    private final static QName GARAGESALECCMANAGERSERVICE_QNAME = new QName("http://session.ccdb.gs.svt.websphere.ibm.com/", "GarageSaleCCManagerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("META-INF/wsdl/GarageSaleCCManagerService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GARAGESALECCMANAGERSERVICE_WSDL_LOCATION = url;
        GARAGESALECCMANAGERSERVICE_EXCEPTION = e;
    }

    public GarageSaleCCManagerService() {
        super(__getWsdlLocation(), GARAGESALECCMANAGERSERVICE_QNAME);
    }

    public GarageSaleCCManagerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GARAGESALECCMANAGERSERVICE_QNAME, features);
    }

    public GarageSaleCCManagerService(URL wsdlLocation) {
        super(wsdlLocation, GARAGESALECCMANAGERSERVICE_QNAME);
    }

    public GarageSaleCCManagerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GARAGESALECCMANAGERSERVICE_QNAME, features);
    }

    public GarageSaleCCManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GarageSaleCCManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GarageSaleCCManagerLocal
     */
    @WebEndpoint(name = "GarageSaleCCManagerPort")
    public GarageSaleCCManagerLocal getGarageSaleCCManagerPort() {
        return super.getPort(new QName("http://session.ccdb.gs.svt.websphere.ibm.com/", "GarageSaleCCManagerPort"), GarageSaleCCManagerLocal.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GarageSaleCCManagerLocal
     */
    @WebEndpoint(name = "GarageSaleCCManagerPort")
    public GarageSaleCCManagerLocal getGarageSaleCCManagerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://session.ccdb.gs.svt.websphere.ibm.com/", "GarageSaleCCManagerPort"), GarageSaleCCManagerLocal.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GARAGESALECCMANAGERSERVICE_EXCEPTION!= null) {
            throw GARAGESALECCMANAGERSERVICE_EXCEPTION;
        }
        return GARAGESALECCMANAGERSERVICE_WSDL_LOCATION;
    }

}
