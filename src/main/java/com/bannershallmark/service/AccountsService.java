package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.TradersAccounts;

public interface AccountsService {

	List<Accounts> findAllAccounts();

	Accounts findAccountsById(Integer accountId);

	void save(Accounts account);
	
	void deleteAccountById(Integer accountId);
	
	////// Linking Account with a trader ///////
	
	List<TradersAccounts> findTraderAccountsByTraderID(Integer traderId);
	
	TradersAccounts findTraderAccountById(Integer trdAccountID);
	
	void save(TradersAccounts tradersAccount);
	
	void deleteTraderAccountById(Integer trdAccountID);
	
}
