package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UsersDailyAnalaysisDao;
import com.bannershallmark.entity.UsersDailyAnalaysis;

@Repository
public class UsersDailyAnalaysisDaoImpl implements UsersDailyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UsersDailyAnalaysis> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UsersDailyAnalaysis> query = session.createQuery("from UsersDailyAnalaysis where userId = :userId",UsersDailyAnalaysis.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
