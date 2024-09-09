package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UsersYearlyAnalaysisDao;
import com.bannershallmark.entity.UsersYearlyAnalaysis;

@Repository
public class UsersYearlyAnalaysisDaoImpl implements UsersYearlyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UsersYearlyAnalaysis> FindByUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UsersYearlyAnalaysis> query = session.createQuery("from UsersYearlyAnalaysis where userId = :userId",
				UsersYearlyAnalaysis.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
