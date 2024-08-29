package com.bannershallmark.serviceImpl;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.PNLDao;
import com.bannershallmark.entity.PNL;
import com.bannershallmark.service.PNLService;

@Service
public class PNLServiceImpl implements PNLService {
	@Autowired
	private PNLDao pnlDao;

	@Override
	@Transactional
	public void save(PNL pnl) {
		pnlDao.save(pnl);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		pnlDao.DeleteById(id);
	}

	@Override
	@Transactional
	public PNL FindById(int id) {
		return pnlDao.FindById(id);
	}

	@Override
	@Transactional
	public List<PNL> findAll() {
		return pnlDao.findAll();
	}
}
