package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountDailySummaryDao;
import com.bannershallmark.entity.DailyAnalaysisByPair;
import com.bannershallmark.entity.DailyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.DailyAnalaysisByUserAndPair;
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
	public List<DailyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		return userAccountDailySummaryDao.FindByUserAndPair(userId, pair);
	}

	@Override
	@Transactional
	public List<DailyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		return userAccountDailySummaryDao.FindByUserAndAccountLogin(userId, accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountDailySummary> FindByUser(int userId) {
		return userAccountDailySummaryDao.FindByUser(userId);
	}

	@Override
	@Transactional
	public List<DailyAnalaysisByPair> FindByPair(String pair) {
		return userAccountDailySummaryDao.FindByPair(pair);
	}
}
