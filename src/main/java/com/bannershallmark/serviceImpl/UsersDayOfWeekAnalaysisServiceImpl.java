package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UsersDayOfWeekAnalaysisDao;
import com.bannershallmark.entity.UsersDayOfWeekAnalaysis;
import com.bannershallmark.service.UsersDayOfWeekAnalaysisService;

@Service
public class UsersDayOfWeekAnalaysisServiceImpl implements UsersDayOfWeekAnalaysisService {
	@Autowired
	private UsersDayOfWeekAnalaysisDao usersDayOfWeekAnalaysisDao;

	@Override
	@Transactional
	public List<UsersDayOfWeekAnalaysis> FindByUser(int userId) {
		return usersDayOfWeekAnalaysisDao.FindByUser(userId);
	}
}
