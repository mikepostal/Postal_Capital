package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountDayOfWeekSummaryDao;
import com.bannershallmark.entity.UserAccountDayOfWeekSummary;
import com.bannershallmark.service.UserAccountDayOfWeekSummaryService;

@Service
public class UserAccountDayOfWeekSummaryServiceImpl implements UserAccountDayOfWeekSummaryService {
	@Autowired
	private UserAccountDayOfWeekSummaryDao userAccountDayOfWeekSummaryDao;

	@Override
	@Transactional
	public List<UserAccountDayOfWeekSummary> FindAll() {
		return userAccountDayOfWeekSummaryDao.FindAll();
	}
}
