package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.Calander;

public interface CalanderDao {
	
	List<Calander> findAllCalanders();

	Calander findCalanderById(Integer calanderId);

	void save(Calander calander);
	
	void deleteCalanderById(Integer calanderId);
}
