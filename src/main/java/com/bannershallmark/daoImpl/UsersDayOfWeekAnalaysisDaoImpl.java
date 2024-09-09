package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UsersDayOfWeekAnalaysisDao;
import com.bannershallmark.entity.UsersDayOfWeekAnalaysis;

@Repository
public class UsersDayOfWeekAnalaysisDaoImpl implements UsersDayOfWeekAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UsersDayOfWeekAnalaysis> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UsersDayOfWeekAnalaysis> query = session.createQuery("from UsersDayOfWeekAnalaysis where userId = :userId",UsersDayOfWeekAnalaysis.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
