package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.PNL;

public interface PNLService {

	void save(PNL pnl);

	void DeleteById(int id);

	PNL FindById(int id);

	List<PNL> findAll();

}
