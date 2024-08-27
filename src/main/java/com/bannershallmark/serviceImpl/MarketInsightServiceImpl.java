package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.MarketInsightDao;
import com.bannershallmark.entity.MarketInsight;
import com.bannershallmark.service.MarketInsightService;

@Service
public class MarketInsightServiceImpl implements MarketInsightService {
	@Autowired
	private MarketInsightDao marketInsightDao;

	@Override
	@Transactional
	public List<MarketInsight> FindAll() {
		return marketInsightDao.FindAll();
	}

	@Override
	@Transactional
	public void save(MarketInsight marketInsight) {
		marketInsightDao.save(marketInsight);
	}

	@Override
	@Transactional
	public MarketInsight FindById(int id) {
		return marketInsightDao.FindById(id);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		marketInsightDao.DeleteById(id);
	}

}
