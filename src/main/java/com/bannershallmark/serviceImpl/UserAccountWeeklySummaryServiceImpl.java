package com.bannershallmark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bannershallmark.dao.UserAccountWeeklySummaryDao;
import com.bannershallmark.service.UserAccountWeeklySummaryService;

@Service
public class UserAccountWeeklySummaryServiceImpl implements UserAccountWeeklySummaryService {
	@Autowired
	private UserAccountWeeklySummaryDao userAccountWeeklySummaryDao;
}
