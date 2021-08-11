package com.ibm.websphere.svt.gs.gsdb.session;

import java.util.List;

import jakarta.annotation.Resource;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import javax.sql.DataSource;

import com.ibm.websphere.svt.gs.gsdb.entities.TaxRate;
import com.ibm.websphere.svt.gs.gsdb.session.view.TaxRateSessionLocal1;

@SuppressWarnings("unchecked")
@Stateless
@Local(TaxRateSessionLocal1.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/gsdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class TaxRateSessionBean1 {

	@PersistenceContext(unitName="GarageSaleDBJPA")
	private EntityManager em;
	public TaxRateSessionBean1() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createTaxRate(TaxRate taxRate) throws Exception {
		EntityManager em = getEntityManager();
		try {
			//utx.begin();
			em.joinTransaction();
			em.persist(taxRate);
			//utx.commit();
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			//em.close();
		}
		return "";
	}

	public String deleteTaxRate(TaxRate taxRate) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			taxRate = em.merge(taxRate);
			em.remove(taxRate);
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			//em.close();
		}
		return "";
	}

	public String updateTaxRate(TaxRate taxRate) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			taxRate = em.merge(taxRate);
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			//em.close();
		}
		return "";
	}

	public TaxRate findTaxRateByStateId(String stateId) {
		TaxRate taxRate = null;
		EntityManager em = getEntityManager();
		try {
			taxRate = (TaxRate) em.find(TaxRate.class, stateId);
		} finally {
			//em.close();
		}
		return taxRate;
	}

	public TaxRate getNewTaxRate() {
	
		TaxRate taxRate = new TaxRate();
	
		return taxRate;
	}
	
	public List<TaxRate> getAllTaxRateList() {
		EntityManager em = getEntityManager();
		List<TaxRate> results = null;
		try {
			Query query = em.createNamedQuery("getAllTaxRateList");
			results = (List<TaxRate>) query.getResultList();
		} finally {
			//em.close();
		}
		return results;
	}


}
