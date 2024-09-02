package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UserAccountShortSummaryDao;
import com.bannershallmark.entity.UserAccountShortSummary;
import com.bannershallmark.service.UserAccountShortSummaryService;

@Service
public class UserAccountShortSummaryServiceImpl implements UserAccountShortSummaryService {
	@Autowired
	private UserAccountShortSummaryDao userAccountShortSummaryDao;

	@Override
	@Transactional
	public List<UserAccountShortSummary> FindAll() {
		return userAccountShortSummaryDao.FindAll();
	}
}
