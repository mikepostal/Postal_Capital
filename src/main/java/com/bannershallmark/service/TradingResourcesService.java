package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.TradingResources;

public interface TradingResourcesService {

	List<TradingResources> FindAll();

	void save(TradingResources tradingResources);

	TradingResources FindById(int id);

	void DeleteById(int id);

}
