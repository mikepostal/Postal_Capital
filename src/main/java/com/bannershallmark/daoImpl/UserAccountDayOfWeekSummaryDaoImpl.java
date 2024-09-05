package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountDayOfWeekSummaryDao;
import com.bannershallmark.entity.UserAccountDailySummary;
import com.bannershallmark.entity.UserAccountDayOfWeekSummary;

@Repository
public class UserAccountDayOfWeekSummaryDaoImpl implements UserAccountDayOfWeekSummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountDayOfWeekSummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery("from UserAccountDayOfWeekSummary",
				UserAccountDayOfWeekSummary.class);
		return query.getResultList();
	}
	
	@Override
	public List<UserAccountDayOfWeekSummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery(
				"from UserAccountDayOfWeekSummary where userId = :userId AND pair = :pair AND accountLogin = :accountLogin",
				UserAccountDayOfWeekSummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountDayOfWeekSummary> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery(
				"from UserAccountDayOfWeekSummary where userId = :userId AND pair = :pair", UserAccountDayOfWeekSummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		return query.getResultList();
	}

	@Override
	public List<UserAccountDayOfWeekSummary> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery(
				"from UserAccountDayOfWeekSummary where userId = :userId AND accountLogin = :accountLogin AND accountLogin = :accountLogin",
				UserAccountDayOfWeekSummary.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountDayOfWeekSummary> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery(
				"from UserAccountDayOfWeekSummary where userId = :userId", UserAccountDayOfWeekSummary.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<UserAccountDayOfWeekSummary> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery(
				"from UserAccountDayOfWeekSummary where pair = :pair", UserAccountDayOfWeekSummary.class);
		query.setParameter("pair", pair);
		return query.getResultList();
	}
}
