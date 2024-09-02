package com.bannershallmark.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountWeeklySummaryDao;

@Repository
public class UserAccountWeeklySummaryDaoImpl implements UserAccountWeeklySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;
}
