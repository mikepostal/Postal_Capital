package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.PnlViewDao;
import com.bannershallmark.entity.PnlView;

@Repository
public class PnlViewDaoImpl implements PnlViewDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PnlView> findByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query<PnlView> query = session.createQuery("from PnlView where userId = :userId", PnlView.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<PnlView> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<PnlView> query = session.createQuery("from PnlView", PnlView.class);
		return query.getResultList();
	}
}
