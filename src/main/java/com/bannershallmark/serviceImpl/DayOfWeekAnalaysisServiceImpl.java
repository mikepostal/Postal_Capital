package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.DayOfWeekAnalaysisDao;
import com.bannershallmark.entity.DayOfWeekAnalaysis;
import com.bannershallmark.service.DayOfWeekAnalaysisService;

@Service
public class DayOfWeekAnalaysisServiceImpl implements DayOfWeekAnalaysisService {
	@Autowired
	private DayOfWeekAnalaysisDao dayOfWeekAnalaysisDao;

	@Override
	@Transactional
	public List<DayOfWeekAnalaysis> FindAll() {
		return dayOfWeekAnalaysisDao.FindAll();
	}
}
