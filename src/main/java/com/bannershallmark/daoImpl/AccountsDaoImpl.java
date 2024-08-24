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
		Session session=sessionFactory.getCurrentSession();
		Query<Accounts> query=session.createQuery("from Accounts", Accounts.class);
		return query.getResultList();
	}

	@Override
	public Accounts findAccountsById(Integer accountId) {
		Session session=sessionFactory.getCurrentSession();
		Accounts account=session.get(Accounts.class, accountId);
		return account;
	}
	
	@Override
	public void save(Accounts account) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(account);
	}

	@Override
	public void deleteAccountById(Integer accountId) {
		Session session=sessionFactory.getCurrentSession();
		Accounts account=findAccountsById(accountId);
		session.delete(account);
	}
	
    //////Linking Account with a trader ///////
	
	@Override
	public List<TradersAccounts> findTraderAccountsByTraderID(Integer traderId) {
		Session session=sessionFactory.getCurrentSession();
		Query<TradersAccounts> query=session.createQuery("from TradersAccounts where userId=:traderId", TradersAccounts.class);
		query.setParameter("traderId",traderId);
		return query.getResultList();
	}
	
	@Override
	public TradersAccounts findTraderAccountById(Integer trdAccountID) {
		Session session=sessionFactory.getCurrentSession();
		TradersAccounts tradersAccount=session.get(TradersAccounts.class, trdAccountID);
		return tradersAccount;
	}
	
	@Override
	public void save(TradersAccounts tradersAccount) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tradersAccount);
	}
	
	@Override
	public void deleteTraderAccountById(Integer traderId) {
		Session session=sessionFactory.getCurrentSession();
		TradersAccounts tradersAccount=findTraderAccountById(traderId);
		session.delete(tradersAccount);
	}

}
