package com.bannershallmark.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.TradersAccountsDao;
import com.bannershallmark.entity.TradersAccounts;
import com.bannershallmark.service.TradersAccountsService;

@Service
public class TradersAccountsServiceImpl implements TradersAccountsService {
	@Autowired
	private TradersAccountsDao tradersAccountsDao;

	@Override
	@Transactional
	public List<TradersAccounts> FindAll() {
		return tradersAccountsDao.FindAll();
	}

	@Override
	@Transactional
	public void save(TradersAccounts tradersAccounts) {
		tradersAccountsDao.save(tradersAccounts);
	}

	@Override
	@Transactional
	public TradersAccounts FindById(int id) {
		return tradersAccountsDao.FindById(id);
	}

	@Override
	@Transactional
	public void DeleteById(int id) {
		tradersAccountsDao.DeleteById(id);
	}

	@Override
	@Transactional
	public List<TradersAccounts> findByUserId(int userId) {
		return tradersAccountsDao.findByUserId(userId);
	}
}
