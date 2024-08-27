package com.bannershallmark.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.MarketInsightFileDao;
import com.bannershallmark.entity.MarketInsightFile;

@Repository
public class MarketInsightFileDaoImpl implements MarketInsightFileDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MarketInsightFile file2) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(file2);
	}

	@Override
	public MarketInsightFile FindById(int documentId) {
		Session session = sessionFactory.getCurrentSession();
		MarketInsightFile file = session.get(MarketInsightFile.class, documentId);
		return file;
	}

}
