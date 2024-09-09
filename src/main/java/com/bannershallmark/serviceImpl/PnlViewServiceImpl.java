package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.PnlViewDao;
import com.bannershallmark.entity.PnlView;
import com.bannershallmark.service.PnlViewService;

@Service
public class PnlViewServiceImpl implements PnlViewService {
	@Autowired
	private PnlViewDao pnlViewDao;

	@Override
	@Transactional
	public List<PnlView> findByUserId(int userId) {
		return pnlViewDao.findByUserId(userId);
	}

	@Override
	@Transactional
	public List<PnlView> findAll() {
		return pnlViewDao.findAll();
	}
}
