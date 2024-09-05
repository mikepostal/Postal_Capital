package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UserAccountMonthlySummary;

public interface UserAccountMonthlySummaryService {

	List<UserAccountMonthlySummary> FindAll();

	List<UserAccountMonthlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<UserAccountMonthlySummary> FindByUserAndPair(int userId, String pair);

	List<UserAccountMonthlySummary> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountMonthlySummary> FindByUser(int userId);

	List<UserAccountMonthlySummary> FindByPair(String pair);

}
