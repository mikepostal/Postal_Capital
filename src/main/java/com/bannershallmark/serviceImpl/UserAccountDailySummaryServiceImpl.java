package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountDailySummaryDao;
import com.bannershallmark.entity.UserAccountDailySummary;
import com.bannershallmark.service.UserAccountDailySummaryService;

@Service
public class UserAccountDailySummaryServiceImpl implements UserAccountDailySummaryService {
	@Autowired
	private UserAccountDailySummaryDao userAccountDailySummaryDao;

	@Override
	@Transactional
	public List<UserAccountDailySummary> FindAll() {
		return userAccountDailySummaryDao.FindAll();
	}

	@Override
	@Transactional
	public List<UserAccountDailySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		return userAccountDailySummaryDao.FindByUserPairAndAccountLogin(userId, pair, accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountDailySummary> FindByUserAndPair(int userId, String pair) {
		return userAccountDailySummaryDao.FindByUserAndPair(userId,pair);
	}
}
