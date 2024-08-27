package com.bannershallmark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.MarketInsightFileDao;
import com.bannershallmark.entity.MarketInsightFile;
import com.bannershallmark.service.MarketInsightFileService;

@Service
public class MarketInsightFileServiceImpl implements MarketInsightFileService {
	@Autowired
	private MarketInsightFileDao marketInsightFileDao;

	@Override
	@Transactional
	public MarketInsightFile FindById(int documentId) {
		return marketInsightFileDao.FindById(documentId);
	}

	@Override
	@Transactional
	public void Save(MarketInsightFile file2) {
		marketInsightFileDao.save(file2);
		
	}
}
