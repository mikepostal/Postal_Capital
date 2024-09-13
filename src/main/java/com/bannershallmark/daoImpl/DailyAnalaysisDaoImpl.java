package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.DailyAnalaysisDao;
import com.bannershallmark.entity.DailyAnalaysis;

@Repository
public class DailyAnalaysisDaoImpl implements DailyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DailyAnalaysis> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<DailyAnalaysis> query = session.createQuery("from DailyAnalaysis",
				DailyAnalaysis.class);
		return query.getResultList();
	}
}
