package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountDayOfWeekSummaryDao;
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
}
