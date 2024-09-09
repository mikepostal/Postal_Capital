package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UsersMonthlyAnalaysisDao;
import com.bannershallmark.entity.UsersMonthlyAnalaysis;
import com.bannershallmark.service.UsersMonthlyAnalaysisService;

@Service
public class UsersMonthlyAnalaysisServiceImpl implements UsersMonthlyAnalaysisService {
	@Autowired
	private UsersMonthlyAnalaysisDao usersMonthlyAnalaysisDao;

	@Override
	@Transactional
	public List<UsersMonthlyAnalaysis> FindByUser(int userId) {
		return usersMonthlyAnalaysisDao.FindByUser(userId);
	}
}
