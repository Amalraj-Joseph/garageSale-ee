//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.ccdb.session.view.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "createAccountForGSResponse", namespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAccountForGSResponse", namespace = "http://view.session.ccdb.gs.svt.websphere.ibm.com/")
public class CreateAccountForGSResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private com.ibm.websphere.svt.cc.wrapper.CCInfoWrapper[] _return;

    /**
     * 
     * @return
     *     returns CCInfoWrapper[]
     */
    public com.ibm.websphere.svt.cc.wrapper.CCInfoWrapper[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ibm.websphere.svt.cc.wrapper.CCInfoWrapper[] _return) {
        this._return = _return;
    }

}
