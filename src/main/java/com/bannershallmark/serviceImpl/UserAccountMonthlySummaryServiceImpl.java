package com.bannershallmark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bannershallmark.dao.UserAccountMonthlySummaryDao;
import com.bannershallmark.service.UserAccountMonthlySummaryService;

@Service
public class UserAccountMonthlySummaryServiceImpl implements UserAccountMonthlySummaryService {
	@Autowired
	private UserAccountMonthlySummaryDao userAccountMonthlySummaryDao;
}
