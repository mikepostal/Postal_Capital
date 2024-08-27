package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.AffectedByCalander;

public interface AffectedByCalanderDao {

	List<AffectedByCalander> FindAll();

	void save(AffectedByCalander affectedByCalander);

	AffectedByCalander FindById(int id);

	void DeleteById(int id);

}
