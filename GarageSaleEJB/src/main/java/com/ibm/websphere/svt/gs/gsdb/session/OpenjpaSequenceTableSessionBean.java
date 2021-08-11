package com.ibm.websphere.svt.gs.gsdb.session;

import jakarta.annotation.Resource;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.sql.DataSource;

import com.ibm.websphere.svt.gs.gsdb.entities.OpenjpaSequenceTable;
import com.ibm.websphere.svt.gs.gsdb.session.view.OpenjpaSequenceTableSessionLocal;

@SuppressWarnings("unchecked")
@Stateless
@Local(OpenjpaSequenceTableSessionLocal.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/gsdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class OpenjpaSequenceTableSessionBean {

	@PersistenceContext(unitName="GarageSaleDBJPA")
	private EntityManager em;

	public OpenjpaSequenceTableSessionBean() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createOpenjpaSequenceTable(
			OpenjpaSequenceTable openjpaSequenceTable) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			em.persist(openjpaSequenceTable);
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

	public String deleteOpenjpaSequenceTable(
			OpenjpaSequenceTable openjpaSequenceTable) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			openjpaSequenceTable = em.merge(openjpaSequenceTable);
			em.remove(openjpaSequenceTable);
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

	public String updateOpenjpaSequenceTable(
			OpenjpaSequenceTable openjpaSequenceTable) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			openjpaSequenceTable = em.merge(openjpaSequenceTable);
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

	public OpenjpaSequenceTable findOpenjpaSequenceTableById(int id) {
		OpenjpaSequenceTable openjpaSequenceTable = null;
		EntityManager em = getEntityManager();
		try {
			openjpaSequenceTable = (OpenjpaSequenceTable) em.find(
					OpenjpaSequenceTable.class, id);
		} finally {
			//em.close();
		}
		return openjpaSequenceTable;
	}

	public OpenjpaSequenceTable getNewOpenjpaSequenceTable() {
	
		OpenjpaSequenceTable openjpaSequenceTable = new OpenjpaSequenceTable();
	
		return openjpaSequenceTable;
	}

}
