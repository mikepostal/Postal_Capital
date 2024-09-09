package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UsersDailyAnalaysisDao;
import com.bannershallmark.entity.UsersDailyAnalaysis;
import com.bannershallmark.service.UsersDailyAnalaysisService;

@Service
public class UsersDailyAnalaysisServiceImpl implements UsersDailyAnalaysisService {
	@Autowired
	private UsersDailyAnalaysisDao usersDailyAnalaysisDao;

	@Override
	@Transactional
	public List<UsersDailyAnalaysis> FindByUser(int userId) {
		return usersDailyAnalaysisDao.FindByUser(userId);
	}
}
