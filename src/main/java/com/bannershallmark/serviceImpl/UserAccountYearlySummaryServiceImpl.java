package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountYearlySummaryDao;
import com.bannershallmark.entity.UserAccountYearlySummary;
import com.bannershallmark.service.UserAccountYearlySummaryService;

@Service
public class UserAccountYearlySummaryServiceImpl implements UserAccountYearlySummaryService {
	@Autowired
	private UserAccountYearlySummaryDao userAccountYearlySummaryDao;

	@Override
	@Transactional
	public List<UserAccountYearlySummary> FindAll() {
		return userAccountYearlySummaryDao.FindAll();
	}
}
