package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountWeeklySummaryDao;
import com.bannershallmark.entity.UserAccountWeeklySummary;
import com.bannershallmark.entity.WeeklyAnalaysisByPair;
import com.bannershallmark.entity.WeeklyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.WeeklyAnalaysisByUserAndPair;

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

	@Override
	public List<UserAccountWeeklySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountWeeklySummary> query = session.createQuery(
				"from UserAccountWeeklySummary where userId = :userId AND pair LIKE :pair AND accountLogin = :accountLogin",
				UserAccountWeeklySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<WeeklyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<WeeklyAnalaysisByUserAndPair> query = session.createQuery(
				"from WeeklyAnalaysisByUserAndPair where userId = :userId AND pair LIKE :pair",
				WeeklyAnalaysisByUserAndPair.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		return query.getResultList();
	}

	@Override
	public List<WeeklyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<WeeklyAnalaysisByUserAndAccount> query = session.createQuery(
				"from WeeklyAnalaysisByUserAndAccount where userId = :userId AND accountLogin = :accountLogin",
				WeeklyAnalaysisByUserAndAccount.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountWeeklySummary> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountWeeklySummary> query = session
				.createQuery("from UserAccountWeeklySummary where userId = :userId", UserAccountWeeklySummary.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<WeeklyAnalaysisByPair> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<WeeklyAnalaysisByPair> query = session.createQuery("from WeeklyAnalaysisByPair where pair LIKE :pair",
				WeeklyAnalaysisByPair.class);
		query.setParameter("pair", pair+"%");
		return query.getResultList();
	}
}
