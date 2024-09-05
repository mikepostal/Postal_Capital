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

	@Override
	@Transactional
	public List<UserAccountYearlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		return userAccountYearlySummaryDao.FindByUserPairAndAccountLogin(userId,pair,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountYearlySummary> FindByUserAndPair(int userId, String pair) {
		return userAccountYearlySummaryDao.FindByUserAndPair(userId,pair);
	}

	@Override
	@Transactional
	public List<UserAccountYearlySummary> FindByUserAndAccountLogin(int userId, String accountLogin) {
		return userAccountYearlySummaryDao.FindByUserAndAccountLogin(userId,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountYearlySummary> FindByUser(int userId) {
		return userAccountYearlySummaryDao.FindByUser(userId);
	}

	@Override
	@Transactional
	public List<UserAccountYearlySummary> FindByPair(String pair) {
		return userAccountYearlySummaryDao.FindByPair(pair);
	}
}
