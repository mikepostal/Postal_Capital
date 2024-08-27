package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.MarketInsightDao;
import com.bannershallmark.entity.MarketInsight;

@Repository
public class MarketInsightDaoImpl implements MarketInsightDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MarketInsight> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<MarketInsight> query = session.createQuery("from MarketInsight", MarketInsight.class);
		return query.getResultList();
	}

	@Override
	public MarketInsight FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		MarketInsight marketInsight = session.get(MarketInsight.class, id);
		return marketInsight;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		MarketInsight marketInsight = FindById(id);
		session.delete(marketInsight);
	}

	@Override
	public void save(MarketInsight marketInsight) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(marketInsight);
	}
}
