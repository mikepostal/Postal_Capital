package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UserAccountDayOfWeekSummary;

public interface UserAccountDayOfWeekSummaryDao {

	List<UserAccountDayOfWeekSummary> FindAll();

	List<UserAccountDayOfWeekSummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<UserAccountDayOfWeekSummary> FindByUserAndPair(int userId, String pair);

	List<UserAccountDayOfWeekSummary> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountDayOfWeekSummary> FindByUser(int userId);

	List<UserAccountDayOfWeekSummary> FindByPair(String pair);

}
