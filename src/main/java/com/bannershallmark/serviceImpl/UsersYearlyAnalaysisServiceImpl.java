package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.UsersYearlyAnalaysisDao;
import com.bannershallmark.entity.UsersYearlyAnalaysis;
import com.bannershallmark.service.UsersYearlyAnalaysisService;

@Service
public class UsersYearlyAnalaysisServiceImpl implements UsersYearlyAnalaysisService {
	@Autowired
	private UsersYearlyAnalaysisDao usersYearlyAnalaysisDao;

	@Override
	@Transactional
	public List<UsersYearlyAnalaysis> FindByUser(int userId) {
		return usersYearlyAnalaysisDao.FindByUser(userId);
	}
}
