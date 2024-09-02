package com.bannershallmark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bannershallmark.dao.UserAccountDayOfWeekSummaryDao;
import com.bannershallmark.service.UserAccountDayOfWeekSummaryService;

@Service
public class UserAccountDayOfWeekSummaryServiceImpl implements UserAccountDayOfWeekSummaryService {
	@Autowired
	private UserAccountDayOfWeekSummaryDao userAccountDayOfWeekSummaryDao;
}
