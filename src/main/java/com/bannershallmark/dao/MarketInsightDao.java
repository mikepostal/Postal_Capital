package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.MarketInsight;

public interface MarketInsightDao {

	List<MarketInsight> FindAll();

	MarketInsight FindById(int id);

	void DeleteById(int id);

	void save(MarketInsight marketInsight);

}
