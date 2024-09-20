package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountDailySummaryDao;
import com.bannershallmark.entity.DailyAnalaysisByPair;
import com.bannershallmark.entity.DailyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.DailyAnalaysisByUserAndPair;
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
				"from UserAccountDailySummary where userId = :userId AND pair LIKE :pair AND accountLogin = :accountLogin",
				UserAccountDailySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<DailyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<DailyAnalaysisByUserAndPair> query = session.createQuery(
				"from DailyAnalaysisByUserAndPair where userId = :userId AND pair LIKE :pair", DailyAnalaysisByUserAndPair.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		return query.getResultList();
	}

	@Override
	public List<DailyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<DailyAnalaysisByUserAndAccount> query = session.createQuery(
				"from DailyAnalaysisByUserAndAccount where userId = :userId AND accountLogin = :accountLogin",
				DailyAnalaysisByUserAndAccount.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UserAccountDailySummary> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDailySummary> query = session.createQuery(
				"from UserAccountDailySummary where userId = :userId", UserAccountDailySummary.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<DailyAnalaysisByPair> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<DailyAnalaysisByPair> query = session.createQuery(
				"from DailyAnalaysisByPair where pair LIKE :pair", DailyAnalaysisByPair.class);
		query.setParameter("pair", pair+"%");
		return query.getResultList();
	}
}
