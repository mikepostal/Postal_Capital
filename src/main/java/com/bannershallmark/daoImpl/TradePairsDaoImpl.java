package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.TradePairsDao;
import com.bannershallmark.entity.TradePairs;

@Repository
public class TradePairsDaoImpl implements TradePairsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TradePairs> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<TradePairs> query = session.createQuery("from TradePairs", TradePairs.class);
		return query.getResultList();
	}

	@Override
	public TradePairs FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradePairs tradePairs = session.get(TradePairs.class, id);
		return tradePairs;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradePairs tradePairs = FindById(id);
		session.delete(tradePairs);
	}

	@Override
	public void save(TradePairs tradePairs) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tradePairs);
	}
}
