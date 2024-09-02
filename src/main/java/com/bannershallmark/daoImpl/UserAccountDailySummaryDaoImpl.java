package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountDailySummaryDao;
import com.bannershallmark.entity.UserAccountDailySummary;

@Repository
public class UserAccountDailySummaryDaoImpl implements UserAccountDailySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountDailySummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDailySummary> query = session.createQuery("from UserAccountDailySummary",
				UserAccountDailySummary.class);
		return query.getResultList();
	}
}
