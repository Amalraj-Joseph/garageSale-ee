//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.gsdb.session.view.jaxws;

import java.util.Vector;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "orderShipped", namespace = "http://view.session.gsdb.gs.svt.websphere.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderShipped", namespace = "http://view.session.gsdb.gs.svt.websphere.ibm.com/", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class OrderShipped {

    @XmlElement(name = "arg0", namespace = "")
    private com.ibm.websphere.svt.gs.wrapper.PaymentInfoWrapper arg0;
    @XmlElement(name = "arg1", namespace = "")
    private Vector<com.ibm.websphere.svt.gs.cart.CartItem> arg1;
    @XmlElement(name = "arg2", namespace = "")
    private com.ibm.websphere.svt.gs.wrapper.CustomerInfoWrapper arg2;

    /**
     * 
     * @return
     *     returns PaymentInfoWrapper
     */
    public com.ibm.websphere.svt.gs.wrapper.PaymentInfoWrapper getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.ibm.websphere.svt.gs.wrapper.PaymentInfoWrapper arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns Vector<CartItem>
     */
    public Vector<com.ibm.websphere.svt.gs.cart.CartItem> getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(Vector<com.ibm.websphere.svt.gs.cart.CartItem> arg1) {
        this.arg1 = arg1;
    }

    /**
     * 
     * @return
     *     returns CustomerInfoWrapper
     */
    public com.ibm.websphere.svt.gs.wrapper.CustomerInfoWrapper getArg2() {
        return this.arg2;
    }

    /**
     * 
     * @param arg2
     *     the value for the arg2 property
     */
    public void setArg2(com.ibm.websphere.svt.gs.wrapper.CustomerInfoWrapper arg2) {
        this.arg2 = arg2;
    }

}
