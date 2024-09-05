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

	@Override
	@Transactional
	public List<UserAccountDayOfWeekSummary> FindByUserPairAndAccountLogin(int userId, String pair,
			String accountLogin) {
		return userAccountDayOfWeekSummaryDao.FindByUserPairAndAccountLogin(userId,pair,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountDayOfWeekSummary> FindByUserAndPair(int userId, String pair) {
		return userAccountDayOfWeekSummaryDao.FindByUserAndPair(userId,pair);
	}

	@Override
	@Transactional
	public List<UserAccountDayOfWeekSummary> FindByUserAndAccountLogin(int userId, String accountLogin) {
		return userAccountDayOfWeekSummaryDao.FindByUserAndAccountLogin(userId,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountDayOfWeekSummary> FindByUser(int userId) {
		return userAccountDayOfWeekSummaryDao.FindByUser(userId);
	}

	@Override
	@Transactional
	public List<UserAccountDayOfWeekSummary> FindByPair(String pair) {
		return userAccountDayOfWeekSummaryDao.FindByPair(pair);
	}
}
