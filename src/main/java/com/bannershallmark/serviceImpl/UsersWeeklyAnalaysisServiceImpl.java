package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UsersWeeklyAnalaysisDao;
import com.bannershallmark.entity.UsersWeeklyAnalaysis;
import com.bannershallmark.service.UsersWeeklyAnalaysisService;

@Service
public class UsersWeeklyAnalaysisServiceImpl implements UsersWeeklyAnalaysisService {
	@Autowired
	private UsersWeeklyAnalaysisDao usersWeeklyAnalaysisDao;

	@Override
	@Transactional
	public List<UsersWeeklyAnalaysis> FindByUser(int userId) {
		return usersWeeklyAnalaysisDao.FindByUser(userId);
	}
}
