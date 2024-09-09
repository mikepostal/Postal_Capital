package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.TradingResources;

public interface TradingResourcesDao {

	List<TradingResources> FindAll();

	void save(TradingResources tradingResources);

	TradingResources FindById(int id);

	void DeleteById(int id);

}
