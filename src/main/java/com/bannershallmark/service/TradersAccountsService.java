package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.TradersAccounts;

public interface TradersAccountsService {

	List<TradersAccounts> FindAll();

	void save(TradersAccounts tradersAccounts);

	TradersAccounts FindById(int id);

	void DeleteById(int id);

	List<TradersAccounts> findByUserId(int userId);

}
