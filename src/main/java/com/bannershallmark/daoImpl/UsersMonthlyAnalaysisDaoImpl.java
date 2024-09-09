package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UsersMonthlyAnalaysisDao;
import com.bannershallmark.entity.UsersMonthlyAnalaysis;

@Repository
public class UsersMonthlyAnalaysisDaoImpl implements UsersMonthlyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UsersMonthlyAnalaysis> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UsersMonthlyAnalaysis> query = session.createQuery("from UsersMonthlyAnalaysis where userId = :userId",
				UsersMonthlyAnalaysis.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
