package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;
import com.bannershallmark.entity.UserAccountDailySummary;
import com.bannershallmark.entity.UserAccountMonthlySummary;

@Repository
public class UserAccountMonthlySummaryDaoImpl implements UserAccountMonthlySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountMonthlySummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountMonthlySummary> query = session.createQuery("from UserAccountMonthlySummary",
				UserAccountMonthlySummary.class);
		return query.getResultList();
	}

	@Override
	public List<UserAccountMonthlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountMonthlySummary> query = session.createQuery(
				"from UserAccountMonthlySummary where userId = :userId AND pair = :pair AND accountLogin = :accountLogin",
				UserAccountMonthlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountMonthlySummary> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountMonthlySummary> query = session.createQuery(
				"from UserAccountMonthlySummary where userId = :userId AND pair = :pair",
				UserAccountMonthlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair);
		return query.getResultList();
	}

	@Override
	public List<UserAccountMonthlySummary> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountMonthlySummary> query = session.createQuery(
				"from UserAccountMonthlySummary where userId = :userId AND accountLogin = :accountLogin AND accountLogin = :accountLogin",
				UserAccountMonthlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountMonthlySummary> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountMonthlySummary> query = session
				.createQuery("from UserAccountMonthlySummary where userId = :userId", UserAccountMonthlySummary.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<UserAccountMonthlySummary> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountMonthlySummary> query = session
				.createQuery("from UserAccountMonthlySummary where pair = :pair", UserAccountMonthlySummary.class);
		query.setParameter("pair", pair);
		return query.getResultList();
	}
}
