package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.TradingResourcesDao;
import com.bannershallmark.entity.TradingResources;
import com.bannershallmark.service.TradingResourcesService;

@Service
public class TradingResourcesServiceImpl implements TradingResourcesService {
	@Autowired
	private TradingResourcesDao tradingResourcesDao;

	@Override
	@Transactional
	public List<TradingResources> FindAll() {
		return tradingResourcesDao.FindAll();
	}

	@Override
	@Transactional
	public void save(TradingResources tradingResources) {
		tradingResourcesDao.save(tradingResources);
	}

	@Override
	@Transactional
	public TradingResources FindById(int id) {
		return tradingResourcesDao.FindById(id);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		tradingResourcesDao.DeleteById(id);
	}
}
