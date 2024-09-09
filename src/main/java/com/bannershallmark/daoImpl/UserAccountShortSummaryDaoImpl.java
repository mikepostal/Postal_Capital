package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountShortSummaryDao;
import com.bannershallmark.entity.UserAccountShortSummary;

@Repository
public class UserAccountShortSummaryDaoImpl implements UserAccountShortSummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountShortSummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountShortSummary> query = session.createQuery("from UserAccountShortSummary",
				UserAccountShortSummary.class);
		return query.getResultList();
	}

	@Override
	public List<UserAccountShortSummary> findByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountShortSummary> query = session
				.createQuery("from UserAccountShortSummary where userId = :userId", UserAccountShortSummary.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
