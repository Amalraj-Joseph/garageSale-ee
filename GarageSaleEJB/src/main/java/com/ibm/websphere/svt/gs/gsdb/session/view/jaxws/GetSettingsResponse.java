//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.gsdb.session.view.jaxws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getSettingsResponse", namespace = "http://view.session.gsdb.gs.svt.websphere.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSettingsResponse", namespace = "http://view.session.gsdb.gs.svt.websphere.ibm.com/")
public class GetSettingsResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ibm.websphere.svt.gs.wrapper.SettingsWrapper _return;

    /**
     * 
     * @return
     *     returns SettingsWrapper
     */
    public com.ibm.websphere.svt.gs.wrapper.SettingsWrapper getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ibm.websphere.svt.gs.wrapper.SettingsWrapper _return) {
        this._return = _return;
    }

}
