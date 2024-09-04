package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountWeeklySummaryDao;
import com.bannershallmark.entity.UserAccountWeeklySummary;
import com.bannershallmark.service.UserAccountWeeklySummaryService;

@Service
public class UserAccountWeeklySummaryServiceImpl implements UserAccountWeeklySummaryService {
	@Autowired
	private UserAccountWeeklySummaryDao userAccountWeeklySummaryDao;

	@Override
	@Transactional
	public List<UserAccountWeeklySummary> FindAll() {
		return userAccountWeeklySummaryDao.FindAll();
	}
}
