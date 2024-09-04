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

	@Override
	public List<UserAccountDailySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDailySummary> query = session.createQuery(
				"from UserAccountDailySummary where userId = :userId AND pair = :pair AND accountLogin = :accountLogin",
				UserAccountDailySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountDailySummary> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDailySummary> query = session.createQuery(
				"from UserAccountDailySummary where userId = :userId AND pair = :pair", UserAccountDailySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		return query.getResultList();
	}
}
