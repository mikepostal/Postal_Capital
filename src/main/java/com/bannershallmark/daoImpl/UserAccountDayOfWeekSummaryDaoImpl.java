package com.bannershallmark.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bannershallmark.dao.UserAccountDayOfWeekSummaryDao;

@Repository
public class UserAccountDayOfWeekSummaryDaoImpl implements UserAccountDayOfWeekSummaryDao {
	@Autowired
	private SessionFactory sessionFactory;
}
