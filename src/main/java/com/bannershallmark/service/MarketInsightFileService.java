package com.bannershallmark.service;

import com.bannershallmark.entity.MarketInsightFile;

public interface MarketInsightFileService {

	MarketInsightFile FindById(int documentId);

	void Save(MarketInsightFile file2);

}
