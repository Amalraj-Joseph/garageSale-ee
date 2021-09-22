package com.ibm.websphere.svt.gs.tax.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SHIPRATE database table.
 * 
 */
@Entity
@Table(name="SHIPRATE")
@NamedQuery(name = "getAllProdShipRatesByOrder", query = "SELECT c  FROM ShipRate c ORDER BY c.itemId")
@XmlRootElement(name="ShipRate", namespace="http://entity.tax.gs.svt.websphere.ibm.com")
public class ShipRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ITEMID",unique=true, nullable=false, length=250)
	private String itemId;

	@Column(name="COST",nullable=false)
	private float cost;

    public ShipRate() {
    }

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public float getCost() {
		return this.cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
