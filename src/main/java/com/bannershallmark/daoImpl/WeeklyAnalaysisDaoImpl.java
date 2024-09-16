package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.WeeklyAnalaysisDao;
import com.bannershallmark.entity.WeeklyAnalaysis;

@Repository
public class WeeklyAnalaysisDaoImpl implements WeeklyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<WeeklyAnalaysis> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<WeeklyAnalaysis> query = session.createQuery("from WeeklyAnalaysis", WeeklyAnalaysis.class);
		return query.getResultList();
	}
}
