//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.ccdb.session.view.jaxws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCCInfoWrapperResponse", namespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCCInfoWrapperResponse", namespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
public class GetCCInfoWrapperResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ibm.websphere.svt.cc.wrapper.CCInfoWrapper _return;

    /**
     * 
     * @return
     *     returns CCInfoWrapper
     */
    public com.ibm.websphere.svt.cc.wrapper.CCInfoWrapper getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ibm.websphere.svt.cc.wrapper.CCInfoWrapper _return) {
        this._return = _return;
    }

}
