package com.bannershallmark.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.CalanderDao;
import com.bannershallmark.entity.Calander;
import com.bannershallmark.service.CalanderService;

@Service
public class CalanderServiceImpl  implements CalanderService{

	@Autowired
	private CalanderDao calanderDao;
	
	@Override
	@Transactional
	public List<Calander> findAllCalanders() {
		return calanderDao.findAllCalanders();
	}
	
	@Override
	@Transactional
	public Calander findCalanderById(Integer calanderId) {
		return calanderDao.findCalanderById(calanderId);
	}

	@Override
	@Transactional
	public void save(Calander calander) {
		 calanderDao.save(calander);
	}

	@Override
	@Transactional
	public void deleteCalanderById(Integer calanderId) {
		calanderDao.deleteCalanderById(calanderId);
	}


}
