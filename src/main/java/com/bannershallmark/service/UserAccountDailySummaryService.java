package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UserAccountDailySummary;

public interface UserAccountDailySummaryService {

	List<UserAccountDailySummary> FindAll();

	List<UserAccountDailySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<UserAccountDailySummary> FindByUserAndPair(int userId, String pair);

}
