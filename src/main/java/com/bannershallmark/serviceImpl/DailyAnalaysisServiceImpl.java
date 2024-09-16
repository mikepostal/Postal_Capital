package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.DailyAnalaysisDao;
import com.bannershallmark.entity.DailyAnalaysis;
import com.bannershallmark.service.DailyAnalaysisService;

@Service
public class DailyAnalaysisServiceImpl implements DailyAnalaysisService {
	@Autowired
	private DailyAnalaysisDao dailyAnalaysisDao;

	@Override
	@Transactional
	public List<DailyAnalaysis> FindAll() {
		return dailyAnalaysisDao.FindAll();
	}
}
