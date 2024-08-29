package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.TradersAccounts;

public interface TradersAccountsDao {

	List<TradersAccounts> FindAll();

	void save(TradersAccounts tradersAccounts);

	TradersAccounts FindById(int id);

	void DeleteById(int id);

}
