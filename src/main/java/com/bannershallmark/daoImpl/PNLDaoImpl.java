package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.PNLDao;
import com.bannershallmark.entity.PNL;

@Repository
public class PNLDaoImpl implements PNLDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PNL> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<PNL> query = session.createQuery("from PNL", PNL.class);
		return query.getResultList();
	}

	@Override
	public PNL FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PNL pnl = session.get(PNL.class, id);
		return pnl;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PNL pnl = FindById(id);
		session.delete(pnl);
	}

	@Override
	public void save(PNL pnl) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pnl);
	}
}
