package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.PNL;

public interface PNLDao {

	List<PNL> findAll();

	PNL FindById(int id);

	void DeleteById(int id);

	void save(PNL pnl);

}
