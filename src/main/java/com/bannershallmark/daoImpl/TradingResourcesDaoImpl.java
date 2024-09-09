package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.TradingResourcesDao;
import com.bannershallmark.entity.TradingResources;

@Repository
public class TradingResourcesDaoImpl implements TradingResourcesDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TradingResources> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<TradingResources> query = session.createQuery("from TradingResources", TradingResources.class);
		return query.getResultList();
	}

	@Override
	public void save(TradingResources tradingResources) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tradingResources);
	}

	@Override
	public TradingResources FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradingResources tradingResources = session.get(TradingResources.class, id);
		return tradingResources;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradingResources tradingResources = FindById(id);
		session.delete(tradingResources);
	}
}
