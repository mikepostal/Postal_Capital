package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountPnlSummaryDao;
import com.bannershallmark.entity.UserAccountPnlSummary;
import com.bannershallmark.service.UserAccountPnlSummaryService;

@Service
public class UserAccountPnlSummaryServiceImpl implements UserAccountPnlSummaryService {
	@Autowired
	private UserAccountPnlSummaryDao userAccountPnlSummaryDao;

	@Override
	@Transactional
	public List<UserAccountPnlSummary> FindAll() {
		return userAccountPnlSummaryDao.FindAll();
	}
}
