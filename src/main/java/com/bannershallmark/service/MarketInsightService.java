package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.MarketInsight;

public interface MarketInsightService {

	List<MarketInsight> FindAll();

	void save(MarketInsight marketInsight);

	MarketInsight FindById(int id);

	void DeleteById(int id);

}
