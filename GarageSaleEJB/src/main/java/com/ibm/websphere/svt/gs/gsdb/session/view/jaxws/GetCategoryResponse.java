//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.gsdb.session.view.jaxws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCategoryResponse", namespace = "http://view.session.gsdb.gs.svt.websphere.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCategoryResponse", namespace = "http://view.session.gsdb.gs.svt.websphere.ibm.com/")
public class GetCategoryResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ibm.websphere.svt.gs.wrapper.CategoryWrapper _return;

    /**
     * 
     * @return
     *     returns CategoryWrapper
     */
    public com.ibm.websphere.svt.gs.wrapper.CategoryWrapper getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ibm.websphere.svt.gs.wrapper.CategoryWrapper _return) {
        this._return = _return;
    }

}
