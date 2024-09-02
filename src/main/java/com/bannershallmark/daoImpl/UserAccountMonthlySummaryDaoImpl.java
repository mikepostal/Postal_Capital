package com.bannershallmark.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;

@Repository
public class UserAccountMonthlySummaryDaoImpl implements UserAccountMonthlySummaryDao {
	@Autowired
	private SessionFactory sessionFactory;
}
