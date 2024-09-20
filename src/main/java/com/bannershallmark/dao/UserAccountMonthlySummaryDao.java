package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.MonthlyAnalaysisByPair;
import com.bannershallmark.entity.MonthlyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.MonthlyAnalaysisByUserAndPair;
import com.bannershallmark.entity.UserAccountMonthlySummary;

public interface UserAccountMonthlySummaryDao {

	List<UserAccountMonthlySummary> FindAll();

	List<UserAccountMonthlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<MonthlyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair);

	List<MonthlyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountMonthlySummary> FindByUser(int userId);

	List<MonthlyAnalaysisByPair> FindByPair(String pair);

}
