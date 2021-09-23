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

import com.ibm.websphere.svt.gs.gsdb.entities.ShipRate;
import com.ibm.websphere.svt.gs.gsdb.session.view.ShipRateSessionLocal1;

@SuppressWarnings("unchecked")
@Stateless
@Local(ShipRateSessionLocal1.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/gsdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class ShipRateSessionBean1 {

	@PersistenceContext(unitName="GarageSaleDBJPA")
	private EntityManager em;
	public ShipRateSessionBean1() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createShipRate(ShipRate shipRate) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			em.persist(shipRate);
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

	public String deleteShipRate(ShipRate shipRate) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			shipRate = em.merge(shipRate);
			em.remove(shipRate);
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

	public String updateShipRate(ShipRate shipRate) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			shipRate = em.merge(shipRate);
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

	public ShipRate findShipRateByItemId(String itemId) {
		ShipRate shipRate = null;
		EntityManager em = getEntityManager();
		try {
			shipRate = (ShipRate) em.find(ShipRate.class, itemId);
		} finally {
			//em.close();
		}
		return shipRate;
	}

	public ShipRate getNewShipRate() {
	
		ShipRate shipRate = new ShipRate();
	
		return shipRate;
	}

	public List<ShipRate> getAllShipRateList() {
		EntityManager em = getEntityManager();
		List<ShipRate> results = null;
		try {
			Query query = em.createNamedQuery("getAllShipRateList");
			results = (List<ShipRate>) query.getResultList();
		} finally {
			//em.close();
		}
		return results;
	}


}
