package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.AffectedByCalander;

public interface AffectedByCalanderService {

	List<AffectedByCalander> FindAll();

	void save(AffectedByCalander affectedByCalander);

	AffectedByCalander FindById(int id);

	void DeleteById(int id);

}
