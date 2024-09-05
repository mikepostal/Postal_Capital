package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UserAccountDailySummary;

public interface UserAccountDailySummaryDao {

	List<UserAccountDailySummary> FindAll();

	List<UserAccountDailySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<UserAccountDailySummary> FindByUserAndPair(int userId, String pair);

	List<UserAccountDailySummary> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountDailySummary> FindByUser(int userId);

	List<UserAccountDailySummary> FindByPair(String pair);

}
