package com.bannershallmark.daoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.AccountsDao;
import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.TradersAccounts;

@Repository
public class AccountsDaoImpl implements AccountsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Accounts> findAllAccounts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Accounts> query = session.createQuery("from Accounts", Accounts.class);
		return query.getResultList();
	}

	@Override
	public Accounts findAccountsById(Integer accountId) {
		Session session = sessionFactory.getCurrentSession();
		Accounts account = session.get(Accounts.class, accountId);
		return account;
	}

	@Override
	public void save(Accounts account) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(account);
	}

	@Override
	public void deleteAccountById(Integer accountId) {
		Session session = sessionFactory.getCurrentSession();
		Accounts account = findAccountsById(accountId);
		session.delete(account);
	}

	@Override
	public boolean existsByAccountLogin(String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("select count(a) from Accounts a where a.accountLogin = :accountLogin",
				Long.class);
		query.setParameter("accountLogin", accountLogin);
		Long count = query.getSingleResult();
		return count != null && count > 0;
	}

	////// Linking Account with a trader ///////

	@Override
	public List<TradersAccounts> findTraderAccountsByTraderID(Integer traderId) {
		Session session = sessionFactory.getCurrentSession();
		Query<TradersAccounts> query = session.createQuery("from TradersAccounts where userId=:traderId",
				TradersAccounts.class);
		query.setParameter("traderId", traderId);
		return query.getResultList();
	}

	@Override
	public TradersAccounts findTraderAccountById(Integer trdAccountID) {
		Session session = sessionFactory.getCurrentSession();
		TradersAccounts tradersAccount = session.get(TradersAccounts.class, trdAccountID);
		return tradersAccount;
	}

	@Override
	public void save(TradersAccounts tradersAccount) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tradersAccount);
	}

	@Override
	public void deleteTraderAccountById(Integer traderId) {
		Session session = sessionFactory.getCurrentSession();
		TradersAccounts tradersAccount = findTraderAccountById(traderId);
		session.delete(tradersAccount);
	}

	@Override
	public boolean existsByAccountId(int accountId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("select count(a) from TradersAccounts a where a.account.accountID = :accountId",
				Long.class);
		query.setParameter("accountId", accountId);
		Long count = query.getSingleResult();
		return count != null && count > 0;
	}

}
