package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.LinkAccounts;
import com.bannershallmark.entity.TradersAccounts;

public interface AccountsDao {

	List<Accounts> findAllAccounts();

	Accounts findAccountsById(Integer accountId);

	void save(Accounts account);

	void deleteAccountById(Integer accountId);

	boolean existsByAccountLogin(String accountLogin);
	List<Accounts> findAccountsByAccountType(String type);

	////// Linking Account with a trader ///////

	List<TradersAccounts> findTraderAccountsByTraderID(Integer traderId);

	TradersAccounts findTraderAccountById(Integer trdAccountID);

	void save(TradersAccounts tradersAccount);

	void deleteTraderAccountById(Integer trdAccountID);

	boolean existsByAccountId(int accountId);
	
////////////////////////////////Map Demo Account with Real Account////////////////////////////////

	List<LinkAccounts> findAllLinkedAccounts();

	void saveLinkedAccount(LinkAccounts linkAccounts);

	void deleteLinkedAccountById(int id);

	boolean existsInDemoAcc(int accountId);

	boolean existsInRealAcc(int accountId);

	Accounts findAccountByAccountLogin(String accountLogin);

	
}
