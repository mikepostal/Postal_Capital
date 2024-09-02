package com.bannershallmark.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountYearlySummaryDao;

@Repository
public class UserAccountYearlySummaryDaoImpl implements UserAccountYearlySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;
}
