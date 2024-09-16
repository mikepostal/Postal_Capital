package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.YearlyAnalaysisDao;
import com.bannershallmark.entity.YearlyAnalaysis;
import com.bannershallmark.service.YearlyAnalaysisService;

@Service
public class YearlyAnalaysisServiceImpl implements YearlyAnalaysisService {
	@Autowired
	private YearlyAnalaysisDao yearlyAnalaysisDao;

	@Override
	@Transactional
	public List<YearlyAnalaysis> FindAll() {
		return yearlyAnalaysisDao.FindAll();
	}
}
