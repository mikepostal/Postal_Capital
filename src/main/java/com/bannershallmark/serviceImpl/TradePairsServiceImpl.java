package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.TradePairsDao;
import com.bannershallmark.entity.TradePairs;
import com.bannershallmark.service.TradePairsService;

@Service
public class TradePairsServiceImpl implements TradePairsService {
	@Autowired
	private TradePairsDao tradePairsDao;

	@Override
	@Transactional
	public void save(TradePairs tradePairs) {
		tradePairsDao.save(tradePairs);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		tradePairsDao.DeleteById(id);
	}

	@Override
	@Transactional
	public TradePairs FindById(int id) {
		return tradePairsDao.FindById(id);
	}

	@Override
	@Transactional
	public List<TradePairs> findAll() {
		return tradePairsDao.findAll();
	}
}
