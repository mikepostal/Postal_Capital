package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.AffectedByCalanderDao;
import com.bannershallmark.entity.AffectedByCalander;

@Repository
public class AffectedByCalanderDaoImpl implements AffectedByCalanderDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AffectedByCalander> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<AffectedByCalander> query = session.createQuery("from AffectedByCalander", AffectedByCalander.class);
		return query.getResultList();
	}

	@Override
	public void save(AffectedByCalander affectedByCalander) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(affectedByCalander);
	}

	@Override
	public AffectedByCalander FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		AffectedByCalander affectedByCalander = session.get(AffectedByCalander.class, id);
		return affectedByCalander;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		AffectedByCalander affectedByCalander = FindById(id);
		session.delete(affectedByCalander);
	}
}
