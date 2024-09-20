package com.bannershallmark.daoImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.CalanderDao;
import com.bannershallmark.entity.Calander;

@Repository
public class CalanderDaoImpl implements CalanderDao {

	 @Autowired
	  private SessionFactory sessionFactory;
	
	@Override
	public List<Calander> findAllCalanders() {
		Session session=sessionFactory.getCurrentSession();
		Query<Calander> query=session.createQuery("from Calander", Calander.class);
		return query.getResultList();
	}

	@Override
	public Calander findCalanderById(Integer calanderId) {
		Session session=sessionFactory.getCurrentSession();
		Calander calander=session.get(Calander.class, calanderId);
		return calander;
	}
	
	@Override
	public void save(Calander calander) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(calander);
	}

	@Override
	public void deleteCalanderById(Integer calanderId) {
		Session session=sessionFactory.getCurrentSession();
		Calander calander=findCalanderById(calanderId);
		session.delete(calander);
	}

	@Override
	public List<Calander> findByDateBefore(LocalDateTime thresholdDate) {
		Session session=sessionFactory.getCurrentSession();
		Query<Calander> query=session.createQuery("from Calander where startfrom < :thresholdDate", Calander.class);
		query.setParameter("thresholdDate", thresholdDate);
		return query.getResultList();
	}

	@Override
	public void delete(Calander calander) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(calander);
		
	}

}
