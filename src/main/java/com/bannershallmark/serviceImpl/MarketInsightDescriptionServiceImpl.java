package com.bannershallmark.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bannershallmark.dao.MarketInsightDescriptionDao;
import com.bannershallmark.service.MarketInsightDescriptionService;

@Service
public class MarketInsightDescriptionServiceImpl implements MarketInsightDescriptionService {
	@Autowired
	private MarketInsightDescriptionDao marketInsightDescriptionDao;
}
