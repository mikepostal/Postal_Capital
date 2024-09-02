package com.bannershallmark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bannershallmark.dao.UserAccountYearlySummaryDao;
import com.bannershallmark.service.UserAccountYearlySummaryService;

@Service
public class UserAccountYearlySummaryServiceImpl implements UserAccountYearlySummaryService {
	@Autowired
	private UserAccountYearlySummaryDao userAccountYearlySummaryDao;
}
