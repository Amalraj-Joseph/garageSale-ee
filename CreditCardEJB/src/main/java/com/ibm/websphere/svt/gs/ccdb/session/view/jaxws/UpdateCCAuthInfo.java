//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.ccdb.session.view.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "updateCCAuthInfo", namespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCCAuthInfo", namespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
public class UpdateCCAuthInfo {

    @XmlElement(name = "arg0", namespace = "")
    private com.ibm.websphere.svt.gs.ccdb.entities.CcAuthInfo arg0;

    /**
     * 
     * @return
     *     returns CcAuthInfo
     */
    public com.ibm.websphere.svt.gs.ccdb.entities.CcAuthInfo getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.ibm.websphere.svt.gs.ccdb.entities.CcAuthInfo arg0) {
        this.arg0 = arg0;
    }

}
