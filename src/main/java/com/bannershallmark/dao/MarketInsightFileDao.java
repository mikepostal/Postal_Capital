package com.bannershallmark.dao;

import com.bannershallmark.entity.MarketInsightFile;

public interface MarketInsightFileDao {

	void save(MarketInsightFile file2);

	MarketInsightFile FindById(int documentId);

}
