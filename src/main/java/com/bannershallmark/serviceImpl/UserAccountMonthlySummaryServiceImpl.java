package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;
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
}
