package com.ibm.websphere.svt.gs.wsbankdb.session;

import jakarta.annotation.Resource;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.sql.DataSource;

import com.ibm.websphere.svt.gs.wsbankdb.entities.Account;
import com.ibm.websphere.svt.gs.wsbankdb.session.view.AccountSessionLocal;

@SuppressWarnings("unchecked")
@Stateless
@Local(AccountSessionLocal.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@Resource(name = "jdbc/wsbankdb", type = DataSource.class, authenticationType = Resource.AuthenticationType.CONTAINER, shareable = true)
public class AccountSessionBean {

	@PersistenceContext(unitName="WSBankDBJPA")
	private EntityManager em;
	public AccountSessionBean() {
	
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public String createAccount(Account account) throws Exception {
		EntityManager em = getEntityManager();
		try {
			
			em.joinTransaction();
			em.persist(account);
			
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

	public String deleteAccount(Account account) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			account = em.merge(account);
			em.remove(account);
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

	public String updateAccount(Account account) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.joinTransaction();
			account = em.merge(account);
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

	public Account findAccountById(int id) {
		Account account = null;
		EntityManager em = getEntityManager();
		try {
			account = (Account) em.find(Account.class, id);
		} finally {
			//em.close();
		}
		return account;
	}

	public Account getNewAccount() {
	
		Account account = new Account();
	
		return account;
	}

}
