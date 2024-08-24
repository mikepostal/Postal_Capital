package com.bannershallmark.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bannershallmark.dao.AccountsDao;
import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.TradersAccounts;
import com.bannershallmark.service.AccountsService;

@Service
public class AccountsServiceImpl  implements AccountsService{

	@Autowired
	private AccountsDao accountsDao;
	
	@Override
	@Transactional
	public List<Accounts> findAllAccounts() {
		return accountsDao.findAllAccounts();
	}
	
	@Override
	@Transactional
	public Accounts findAccountsById(Integer accountId) {
		return accountsDao.findAccountsById(accountId);
	}

	@Override
	@Transactional
	public void save(Accounts account) {
		accountsDao.save(account);
	}

	@Override
	@Transactional
	public void deleteAccountById(Integer accountId) {
		accountsDao.deleteAccountById(accountId);
	}
	
    //////Linking Account with a trader ///////
	
	@Override
	@Transactional
	public List<TradersAccounts> findTraderAccountsByTraderID(Integer traderId) {
		return accountsDao.findTraderAccountsByTraderID(traderId);
	}
	
	@Override
	@Transactional
	public TradersAccounts findTraderAccountById(Integer trdAccountID) {
		return accountsDao.findTraderAccountById(trdAccountID);
	}
	
	@Override
	@Transactional
	public void save(TradersAccounts tradersAccount) {
		accountsDao.save(tradersAccount);
	}
	
	@Override
	@Transactional
	public void deleteTraderAccountById(Integer trdAccountID) {
		accountsDao.deleteTraderAccountById(trdAccountID);
	}

}
