package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.TradersAccountsDao;
import com.bannershallmark.entity.TradersAccounts;

@Repository
public class TradersAccountsDaoImpl implements TradersAccountsDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TradersAccounts> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<TradersAccounts> query = session.createQuery("from TradersAccounts", TradersAccounts.class);
		return query.getResultList();
	}

	@Override
	public void save(TradersAccounts tradersAccounts) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tradersAccounts);
	}

	@Override
	public TradersAccounts FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradersAccounts tradersAccounts = session.get(TradersAccounts.class, id);
		return tradersAccounts;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradersAccounts tradersAccounts = FindById(id);
		session.delete(tradersAccounts);
	}
}
