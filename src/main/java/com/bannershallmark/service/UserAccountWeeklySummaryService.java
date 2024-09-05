package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UserAccountWeeklySummary;

public interface UserAccountWeeklySummaryService {

	List<UserAccountWeeklySummary> FindAll();

	List<UserAccountWeeklySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<UserAccountWeeklySummary> FindByUserAndPair(int userId, String pair);

	List<UserAccountWeeklySummary> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountWeeklySummary> FindByUser(int userId);

	List<UserAccountWeeklySummary> FindByPair(String pair);

}
