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

import com.ibm.websphere.svt.gs.gsdb.entities.Setting;
import com.ibm.websphere.svt.gs.gsdb.session.view.SettingSessionLocal;

@SuppressWarnings("unchecked")
@Stateless
@Local(SettingSessionLocal.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/gsdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class SettingSessionBean {

	@PersistenceContext(unitName="GarageSaleDBJPA")
	private EntityManager em;
	public SettingSessionBean() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createSetting(Setting setting) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			em.persist(setting);
		} catch (Exception ex) {
			try {
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

	public String deleteSetting(Setting setting) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			setting = em.merge(setting);
			em.remove(setting);
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

	public String updateSetting(Setting setting) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			setting = em.merge(setting);
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

	public Setting findSettingById(int id) {
		Setting setting = null;
		EntityManager em = getEntityManager();
		try {
			setting = (Setting) em.find(Setting.class, id);
		} finally {
			//em.close();
		}
		return setting;
	}

	public Setting getNewSetting() {
	
		Setting setting = new Setting();
	
		return setting;
	}

}
