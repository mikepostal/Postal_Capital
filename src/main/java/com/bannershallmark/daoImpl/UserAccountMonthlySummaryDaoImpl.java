package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;
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
}
