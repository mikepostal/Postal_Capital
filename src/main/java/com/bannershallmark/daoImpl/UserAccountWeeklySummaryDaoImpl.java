package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountWeeklySummaryDao;
import com.bannershallmark.entity.UserAccountWeeklySummary;

@Repository
public class UserAccountWeeklySummaryDaoImpl implements UserAccountWeeklySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountWeeklySummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountWeeklySummary> query = session.createQuery("from UserAccountWeeklySummary",
				UserAccountWeeklySummary.class);
		return query.getResultList();
	}
}
