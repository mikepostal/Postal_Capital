package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UsersWeeklyAnalaysisDao;
import com.bannershallmark.entity.UsersWeeklyAnalaysis;

@Repository
public class UsersWeeklyAnalaysisDaoImpl implements UsersWeeklyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UsersWeeklyAnalaysis> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UsersWeeklyAnalaysis> query = session.createQuery("from UsersWeeklyAnalaysis where userId = :userId",
				UsersWeeklyAnalaysis.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
