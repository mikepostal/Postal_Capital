package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UsersYearlyAnalaysisDao;
import com.bannershallmark.dao.YearlyAnalaysisDao;
import com.bannershallmark.entity.UsersYearlyAnalaysis;
import com.bannershallmark.entity.YearlyAnalaysis;

@Repository
public class YearlyAnalaysisDaoImpl implements YearlyAnalaysisDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<YearlyAnalaysis> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<YearlyAnalaysis> query = session.createQuery("from YearlyAnalaysis",
				YearlyAnalaysis.class);
		return query.getResultList();
	}
}
