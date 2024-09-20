package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.Calander;

public interface CalanderService {

    List<Calander> findAllCalanders();

	Calander findCalanderById(Integer calanderId);

	void save(Calander calander);
	
	void deleteCalanderById(Integer calanderId);

	void deleteOldCalanders();
	
}
