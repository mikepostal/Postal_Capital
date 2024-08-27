package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.TradePairs;

public interface TradePairsService {

	void save(TradePairs tradePairs);

	void DeleteById(int id);

	TradePairs FindById(int id);

	List<TradePairs> findAll();

}
