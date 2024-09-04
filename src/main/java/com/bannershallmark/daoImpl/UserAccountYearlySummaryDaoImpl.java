package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountYearlySummaryDao;
import com.bannershallmark.entity.UserAccountYearlySummary;

@Repository
public class UserAccountYearlySummaryDaoImpl implements UserAccountYearlySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountYearlySummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountYearlySummary> query = session.createQuery("from UserAccountYearlySummary",
				UserAccountYearlySummary.class);
		return query.getResultList();
	}
}
