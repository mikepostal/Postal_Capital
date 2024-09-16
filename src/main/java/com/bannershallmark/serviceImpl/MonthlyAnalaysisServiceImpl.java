package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.MonthlyAnalaysisDao;
import com.bannershallmark.entity.MonthlyAnalaysis;
import com.bannershallmark.service.MonthlyAnalaysisService;


@Service
public class MonthlyAnalaysisServiceImpl implements MonthlyAnalaysisService {
	@Autowired
	private MonthlyAnalaysisDao monthlyAnalaysisDao;

	@Override
	@Transactional
	public List<MonthlyAnalaysis> FindAll() {
		return monthlyAnalaysisDao.FindAll();
	}
}
