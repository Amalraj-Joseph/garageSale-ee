package com.ibm.websphere.svt.gs.tax.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the TAXRATE database table.
 * 
 */
@Entity
@Table(name="TAXRATE")
@NamedQuery(name = "getTaxInfoForAllStates", query = "SELECT t from TaxRate t ORDER BY t.stateId")
@XmlRootElement(name="TaxRate", namespace="http://entity.tax.gs.svt.websphere.ibm.com")
public class TaxRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STATEID",unique=true, nullable=false, length=5)
	private String stateId;

	@Column(name="STATENAME",nullable=false, length=50)
	private String stateName;

	@Column(name="TAXRATE",nullable=false)
	private float taxRate;

    public TaxRate() {
    }

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public float getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

}
