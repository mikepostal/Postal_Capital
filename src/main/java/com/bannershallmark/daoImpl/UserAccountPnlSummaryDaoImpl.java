package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountPnlSummaryDao;
import com.bannershallmark.entity.UserAccountPnlSummary;
import com.bannershallmark.entity.UsersEquityChart;

@Repository
public class UserAccountPnlSummaryDaoImpl implements UserAccountPnlSummaryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccountPnlSummary> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountPnlSummary> query = session.createQuery("from UserAccountPnlSummary",
				UserAccountPnlSummary.class);
		return query.getResultList();
	}

	@Override
	public List<UserAccountPnlSummary> FindByUserIdAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountPnlSummary> query = session.createQuery(
				"from UserAccountPnlSummary where userId = :userId AND accountLogin = :accountLogin",
				UserAccountPnlSummary.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}

	@Override
	public List<UsersEquityChart> FindEquityChartByUserIdAndAccountLogin(int userId, String accountLogin) {
		Session session = sessionFactory.getCurrentSession();
		Query<UsersEquityChart> query = session.createQuery(
				"from UsersEquityChart where userId = :userId AND accountLogin = :accountLogin",
				UsersEquityChart.class);
		query.setParameter("userId", userId);
		query.setParameter("accountLogin", accountLogin);
		return query.getResultList();
	}
}
