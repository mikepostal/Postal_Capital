package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountYearlySummaryDao;
import com.bannershallmark.entity.UserAccountDailySummary;
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

	@Override
	public List<UserAccountYearlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountYearlySummary> query = session.createQuery(
				"from UserAccountYearlySummary where userId = :userId AND pair = :pair AND accountLogin = :accountLogin",
				UserAccountYearlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountYearlySummary> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountYearlySummary> query = session.createQuery(
				"from UserAccountYearlySummary where userId = :userId AND pair = :pair",
				UserAccountYearlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		return query.getResultList();
	}

	@Override
	public List<UserAccountYearlySummary> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountYearlySummary> query = session.createQuery(
				"from UserAccountYearlySummary where userId = :userId AND accountLogin = :accountLogin AND accountLogin = :accountLogin",
				UserAccountYearlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountYearlySummary> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountYearlySummary> query = session
				.createQuery("from UserAccountYearlySummary where userId = :userId", UserAccountYearlySummary.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<UserAccountYearlySummary> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountYearlySummary> query = session.createQuery("from UserAccountYearlySummary where pair = :pair",
				UserAccountYearlySummary.class);
		query.setParameter("pair", pair);
		return query.getResultList();
	}
}
