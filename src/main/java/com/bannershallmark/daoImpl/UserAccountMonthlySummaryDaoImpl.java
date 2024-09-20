package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;
import com.bannershallmark.entity.MonthlyAnalaysisByPair;
import com.bannershallmark.entity.MonthlyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.MonthlyAnalaysisByUserAndPair;
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
				"from UserAccountMonthlySummary where userId = :userId AND pair LIKE :pair AND accountLogin = :accountLogin",
				UserAccountMonthlySummary.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<MonthlyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<MonthlyAnalaysisByUserAndPair> query = session.createQuery(
				"from MonthlyAnalaysisByUserAndPair where userId = :userId AND pair LIKE :pair",
				MonthlyAnalaysisByUserAndPair.class);
		query.setParameter("userId", userId);
		query.setParameter("pair", pair + "%");
		return query.getResultList();
	}

	@Override
	public List<MonthlyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<MonthlyAnalaysisByUserAndAccount> query = session.createQuery(
				"from MonthlyAnalaysisByUserAndAccount where userId = :userId AND accountLogin = :accountLogin",
				MonthlyAnalaysisByUserAndAccount.class);
		query.setParameter("userId", userId);
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
	public List<MonthlyAnalaysisByPair> FindByPair(String pair) {
		Session session = sessionFactory.getCurrentSession();
		Query<MonthlyAnalaysisByPair> query = session
				.createQuery("from MonthlyAnalaysisByPair where pair LIKE :pair", MonthlyAnalaysisByPair.class);
		query.setParameter("pair", pair+"%");
		return query.getResultList();
	}
}
