//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:27 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:17 AM(foreman)-)
//


package com.ibm.websphere.svt.gs.gsdb.jaxws.client;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for populateCustomers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="populateCustomers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://view.session.gsdb.gs.svt.websphere.ibm.com/}settingsWrapper" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://wrapper.cc.svt.websphere.ibm.com}CCInfoWrapper" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "populateCustomers", propOrder = {
    "arg0",
    "arg1"
})
public class PopulateCustomers {

    protected SettingsWrapper arg0;
    @XmlElement(nillable = true)
    protected List<CCInfoWrapper> arg1;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link SettingsWrapper }
     *     
     */
    public SettingsWrapper getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettingsWrapper }
     *     
     */
    public void setArg0(SettingsWrapper value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CCInfoWrapper }
     * 
     * 
     */
    public List<CCInfoWrapper> getArg1() {
        if (arg1 == null) {
            arg1 = new ArrayList<CCInfoWrapper>();
        }
        return this.arg1;
    }

}
