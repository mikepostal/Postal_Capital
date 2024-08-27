package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.AffectedByCalanderDao;
import com.bannershallmark.entity.AffectedByCalander;
import com.bannershallmark.service.AffectedByCalanderService;
@Service
public class AffectedByCalanderServiceImpl implements AffectedByCalanderService{
	@Autowired
	private AffectedByCalanderDao affectedByCalanderDao;

	@Override
	@Transactional
	public List<AffectedByCalander> FindAll() {
		return affectedByCalanderDao.FindAll();
	}

	@Override
	@Transactional
	public void save(AffectedByCalander affectedByCalander) {
		affectedByCalanderDao.save(affectedByCalander);
	}

	@Override
	@Transactional
	public AffectedByCalander FindById(int id) {
		return affectedByCalanderDao.FindById(id);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		affectedByCalanderDao.DeleteById(id);
	}
}
