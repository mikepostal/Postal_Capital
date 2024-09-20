package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountYearlySummaryDao;
import com.bannershallmark.entity.UserAccountYearlySummary;
import com.bannershallmark.entity.YearlyAnalaysisByPair;
import com.bannershallmark.entity.YearlyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.YearlyAnalaysisByUserAndPair;

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
				"from UserAccountYearlySummary where userId = :userId AND pair LIKE :pair AND accountLogin = :accountLogin",
				UserAccountYearlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<YearlyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<YearlyAnalaysisByUserAndPair> query = session.createQuery(
				"from YearlyAnalaysisByUserAndPair where userId = :userId AND pair LIKE :pair",
				YearlyAnalaysisByUserAndPair.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		return query.getResultList();
	}

	@Override
	public List<YearlyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<YearlyAnalaysisByUserAndAccount> query = session.createQuery(
				"from YearlyAnalaysisByUserAndAccount where userId = :userId AND accountLogin = :accountLogin",
				YearlyAnalaysisByUserAndAccount.class);
		query.setParameter("userId", userId);
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
	public List<YearlyAnalaysisByPair> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<YearlyAnalaysisByPair> query = session.createQuery("from YearlyAnalaysisByPair where pair LIKE :pair",
				YearlyAnalaysisByPair.class);
		query.setParameter("pair", pair+"%");
		return query.getResultList();
	}
}
