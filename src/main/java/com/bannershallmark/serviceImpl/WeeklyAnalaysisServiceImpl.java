package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.WeeklyAnalaysisDao;
import com.bannershallmark.entity.WeeklyAnalaysis;
import com.bannershallmark.service.WeeklyAnalaysisService;

@Service
public class WeeklyAnalaysisServiceImpl implements WeeklyAnalaysisService {
	@Autowired
	private WeeklyAnalaysisDao weeklyAnalaysisDao;

	@Override
	@Transactional
	public List<WeeklyAnalaysis> FindAll() {
		return weeklyAnalaysisDao.FindAll();
	}
}
