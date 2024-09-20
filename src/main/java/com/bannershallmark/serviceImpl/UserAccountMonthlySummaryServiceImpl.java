package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;
import com.bannershallmark.entity.MonthlyAnalaysisByPair;
import com.bannershallmark.entity.MonthlyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.MonthlyAnalaysisByUserAndPair;
import com.bannershallmark.entity.UserAccountMonthlySummary;
import com.bannershallmark.service.UserAccountMonthlySummaryService;

@Service
public class UserAccountMonthlySummaryServiceImpl implements UserAccountMonthlySummaryService {
	@Autowired
	private UserAccountMonthlySummaryDao userAccountMonthlySummaryDao;

	@Override
	@Transactional
	public List<UserAccountMonthlySummary> FindAll() {
		return userAccountMonthlySummaryDao.FindAll();
	}

	@Override
	@Transactional
	public List<UserAccountMonthlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin) {
		return userAccountMonthlySummaryDao.FindByUserPairAndAccountLogin(userId,pair,accountLogin);
	}

	@Override
	@Transactional
	public List<MonthlyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair) {
		return userAccountMonthlySummaryDao.FindByUserAndPair(userId,pair);
	}

	@Override
	@Transactional
	public List<MonthlyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin) {
		return userAccountMonthlySummaryDao.FindByUserAndAccountLogin(userId,accountLogin);
	}

	@Override
	@Transactional
	public List<UserAccountMonthlySummary> FindByUser(int userId) {
		return userAccountMonthlySummaryDao.FindByUser(userId);
	}

	@Override
	@Transactional
	public List<MonthlyAnalaysisByPair> FindByPair(String pair) {
		return userAccountMonthlySummaryDao.FindByPair(pair);
	}
}
