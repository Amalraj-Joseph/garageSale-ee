package com.ibm.websphere.svt.gs.tax.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
@NamedQueries({@NamedQuery(name = "getAllCustomersByOrder", query = "SELECT t from Customer t ORDER BY t.custId"),
@NamedQuery(name = "getTotalNoOfInvoices", query = "select sum(t.numInvoicesCompleted) as totalNumberOfInvoicesCompleted, sum(t.numInvoicesCreated) as totalNumberOfInvoicesCreated from Customer t")})

@XmlRootElement(name="Customer", namespace="http://entity.tax.gs.svt.websphere.ibm.com")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUSTID",unique=true, nullable=false, length=250)
	private String custId;

	@Column(name="CUSTNAME",length=250)
	private String custName;

	@Column(name="CUSTPWD",length=250)
	private String custPWD;

	@Column(name="NUMINVOICESCOMPLETED",nullable=false)
	private int numInvoicesCompleted;

	@Column(name="NUMINVOICESCREATED",nullable=false)
	private int numInvoicesCreated;
	
	@Transient
	private int totalNumberOfInvoicesCreated;
	
	@Transient
	private int totalNumberOfInvoicesCompleted;

	


    public Customer() {
    }

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPWD() {
		return this.custPWD;
	}

	public void setCustPWD(String custPWD) {
		this.custPWD = custPWD;
	}

	public int getNumInvoicesCompleted() {
		return this.numInvoicesCompleted;
	}

	public void setNumInvoicesCompleted(int numInvoicesCompleted) {
		this.numInvoicesCompleted = numInvoicesCompleted;
	}

	public int getNumInvoicesCreated() {
		return this.numInvoicesCreated;
	}

	public void setNumInvoicesCreated(int numInvoicesCreated) {
		this.numInvoicesCreated = numInvoicesCreated;
	}

	public int getTotalNumberOfInvoicesCreated() {
		return totalNumberOfInvoicesCreated;
	}

	public void setTotalNumberOfInvoicesCreated(int totalNumberOfInvoicesCreated) {
		this.totalNumberOfInvoicesCreated = totalNumberOfInvoicesCreated;
	}

	public int getTotalNumberOfInvoicesCompleted() {
		return totalNumberOfInvoicesCompleted;
	}

	public void setTotalNumberOfInvoicesCompleted(int totalNumberOfInvoicesCompleted) {
		this.totalNumberOfInvoicesCompleted = totalNumberOfInvoicesCompleted;
	}

	
	
}
