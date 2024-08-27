package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.TradePairs;

public interface TradePairsDao {

	List<TradePairs> findAll();

	TradePairs FindById(int id);

	void DeleteById(int id);

	void save(TradePairs tradePairs);

}
