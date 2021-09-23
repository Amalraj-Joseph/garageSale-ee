package com.ibm.websphere.svt.gs.gsdb.session;

import java.util.Date;
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

import com.ibm.websphere.svt.gs.gsdb.entities.StoreCredit;
import com.ibm.websphere.svt.gs.gsdb.entities.StoreCreditPK;
import com.ibm.websphere.svt.gs.gsdb.session.view.StoreCreditSessionLocal;

@SuppressWarnings("unchecked")
@Stateless
@Local(StoreCreditSessionLocal.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/gsdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class StoreCreditSessionBean {

	@PersistenceContext(unitName="GarageSaleDBJPA")
	private EntityManager em;
	public StoreCreditSessionBean() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createStoreCredit(StoreCredit storeCredit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			em.persist(storeCredit);
		} catch (Exception ex) {
			try {
				//em.getTransaction().rollback();
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

	public String deleteStoreCredit(StoreCredit storeCredit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			
			em.joinTransaction();
			storeCredit = em.merge(storeCredit);
			em.remove(storeCredit);
			
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

	public String updateStoreCredit(StoreCredit storeCredit) throws Exception {
		EntityManager em = getEntityManager();
		try {
			
			em.joinTransaction();
			storeCredit = em.merge(storeCredit);
			
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

	public StoreCredit findStoreCreditByPrimaryKey(String custId, Date time1) {
		StoreCredit storeCredit = null;
		EntityManager em = getEntityManager();
		StoreCreditPK pk = new StoreCreditPK();
		pk.setCustId(custId);
		pk.setTime1(time1);
		try {
			storeCredit = (StoreCredit) em.find(StoreCredit.class, pk);
		} finally {
			//em.close();
		}
		return storeCredit;
	}

	public StoreCredit getNewStoreCredit() {
	
		StoreCredit storeCredit = new StoreCredit();
	
		StoreCreditPK id = new StoreCreditPK();
		storeCredit.setId(id);
	
		return storeCredit;
	}

	public List<StoreCredit> getAllStoreCredit() {
		EntityManager em = getEntityManager();
		List<StoreCredit> results = null;
		try {
			Query query = em.createNamedQuery("getAllStoreCredit");
			results = (List<StoreCredit>) query.getResultList();
		} finally {
			//em.close();
		}
		return results;
	}

}
