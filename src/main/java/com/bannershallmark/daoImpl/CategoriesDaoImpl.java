package com.bannershallmark.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.CategoriesDao;
import com.bannershallmark.entity.Categories;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Categories> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Categories> query = session.createQuery("from Categories", Categories.class);
		return query.getResultList();
	}

	@Override
	public void save(Categories categories) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(categories);

	}

	@Override
	public Categories FindById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Categories categories = session.get(Categories.class, id);
		return categories;
	}

	@Override
	public void DeleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Categories categories = FindById(id);
		session.delete(categories);
	}
}
