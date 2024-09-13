package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.MonthlyAnalaysisDao;
import com.bannershallmark.entity.MonthlyAnalaysis;

@Repository
public class MonthlyAnalaysisDaoImpl implements MonthlyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MonthlyAnalaysis> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<MonthlyAnalaysis> query = session.createQuery("from MonthlyAnalaysis", MonthlyAnalaysis.class);
		return query.getResultList();
	}
}
