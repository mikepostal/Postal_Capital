package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.DayOfWeekAnalaysisDao;
import com.bannershallmark.entity.DayOfWeekAnalaysis;

@Repository
public class DayOfWeekAnalaysisDaoImpl implements DayOfWeekAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DayOfWeekAnalaysis> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<DayOfWeekAnalaysis> query = session.createQuery("from DayOfWeekAnalaysis", DayOfWeekAnalaysis.class);
		return query.getResultList();
	}
}
