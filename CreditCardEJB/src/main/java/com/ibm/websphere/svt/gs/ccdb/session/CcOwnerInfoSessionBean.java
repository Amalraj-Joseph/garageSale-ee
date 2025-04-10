package com.ibm.websphere.svt.gs.ccdb.session;

import jakarta.annotation.Resource;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.sql.DataSource;

import com.ibm.websphere.svt.gs.ccdb.entities.CcOwnerInfo;
import com.ibm.websphere.svt.gs.ccdb.session.view.CcOwnerInfoSessionLocal;

@SuppressWarnings("unchecked")
@Stateless
@Local(CcOwnerInfoSessionLocal.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/ccdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class CcOwnerInfoSessionBean {

	@PersistenceContext(unitName="CreditCardDBJPA")
	private EntityManager em;
	public CcOwnerInfoSessionBean() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createCcOwnerInfo(CcOwnerInfo ccOwnerInfo) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			em.persist(ccOwnerInfo);
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

	public String deleteCcOwnerInfo(CcOwnerInfo ccOwnerInfo) throws Exception {
		EntityManager em = getEntityManager();
		try {
			
			em.joinTransaction();
			ccOwnerInfo = em.merge(ccOwnerInfo);
			em.remove(ccOwnerInfo);
			
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

	public String updateCcOwnerInfo(CcOwnerInfo ccOwnerInfo) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			ccOwnerInfo = em.merge(ccOwnerInfo);
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

	public CcOwnerInfo findCcOwnerInfoByCcNum(String ccNum) {
		CcOwnerInfo ccOwnerInfo = null;
		EntityManager em = getEntityManager();
		try {
			ccOwnerInfo = (CcOwnerInfo) em.find(CcOwnerInfo.class, ccNum);
		} finally {
			//em.close();
		}
		return ccOwnerInfo;
	}

	public CcOwnerInfo getNewCcOwnerInfo() {
	
		CcOwnerInfo ccOwnerInfo = new CcOwnerInfo();
	
		return ccOwnerInfo;
	}

}
