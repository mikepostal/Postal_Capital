package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountPnlSummaryDao;
import com.bannershallmark.entity.UserAccountPnlSummary;

@Repository
public class UserAccountPnlSummaryDaoImpl implements UserAccountPnlSummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountPnlSummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountPnlSummary> query = session.createQuery("from UserAccountPnlSummary",
				UserAccountPnlSummary.class);
		return query.getResultList();
	}
}
