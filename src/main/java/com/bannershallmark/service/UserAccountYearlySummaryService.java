package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UserAccountYearlySummary;

public interface UserAccountYearlySummaryService {

	List<UserAccountYearlySummary> FindAll();

	List<UserAccountYearlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<UserAccountYearlySummary> FindByUserAndPair(int userId, String pair);

	List<UserAccountYearlySummary> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountYearlySummary> FindByUser(int userId);

	List<UserAccountYearlySummary> FindByPair(String pair);

}
