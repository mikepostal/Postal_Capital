package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountDayOfWeekSummaryDao;
import com.bannershallmark.entity.DayOfWeekAnalaysisByPair;
import com.bannershallmark.entity.DayOfWeekAnalaysisByUserAndAccount;
import com.bannershallmark.entity.DayOfWeekAnalaysisByUserAndPair;
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
	public List<UserAccountDayOfWeekSummary> FindByUserPairAndAccountLogin(int userId, String pair,
			String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDayOfWeekSummary> query = session.createQuery(
				"from UserAccountDayOfWeekSummary where userId = :userId AND pair LIKE :pair AND accountLogin = :accountLogin",
				UserAccountDayOfWeekSummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<DayOfWeekAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<DayOfWeekAnalaysisByUserAndPair> query = session.createQuery(
				"from DayOfWeekAnalaysisByUserAndPair where userId = :userId AND pair LIKE :pair",
				DayOfWeekAnalaysisByUserAndPair.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		return query.getResultList();
	}

	@Override
	public List<DayOfWeekAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<DayOfWeekAnalaysisByUserAndAccount> query = session.createQuery(
				"from DayOfWeekAnalaysisByUserAndAccount where userId = :userId AND accountLogin = :accountLogin",
				DayOfWeekAnalaysisByUserAndAccount.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		System.out.println("User ID: " + userId + ", Account Login: " + accountLogin);

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
	public List<DayOfWeekAnalaysisByPair> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<DayOfWeekAnalaysisByPair> query = session
				.createQuery("from DayOfWeekAnalaysisByPair where pair LIKE :pair", DayOfWeekAnalaysisByPair.class);
		query.setParameter("pair", pair + "%");
		return query.getResultList();
	}
}
