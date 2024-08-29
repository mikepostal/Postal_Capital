package com.bannershallmark.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.MarketInsightDescriptionDao;

@Repository
public class MarketInsightDescriptionDaoImpl implements MarketInsightDescriptionDao {
	@Autowired
	private SessionFactory sessionFactory;
}
