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

	@Override
	@Transactional
	public List<UserAccountWeeklySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		return userAccountWeeklySummaryDao.FindByUserPairAndAccountLogin(userId,pair,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountWeeklySummary> FindByUserAndPair(int userId, String pair) {
		return userAccountWeeklySummaryDao.FindByUserAndPair(userId,pair);
	}

	@Override
	@Transactional
	public List<UserAccountWeeklySummary> FindByUserAndAccountLogin(int userId, String accountLogin) {
		return userAccountWeeklySummaryDao.FindByUserAndAccountLogin(userId,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountWeeklySummary> FindByUser(int userId) {
		return userAccountWeeklySummaryDao.FindByUser(userId);
	}

	@Override
	@Transactional
	public List<UserAccountWeeklySummary> FindByPair(String pair) {
		return userAccountWeeklySummaryDao.FindByPair(pair);
	}
}
