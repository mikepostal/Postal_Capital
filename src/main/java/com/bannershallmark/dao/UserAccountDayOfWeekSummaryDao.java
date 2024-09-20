package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.DayOfWeekAnalaysisByPair;
import com.bannershallmark.entity.DayOfWeekAnalaysisByUserAndAccount;
import com.bannershallmark.entity.DayOfWeekAnalaysisByUserAndPair;
import com.bannershallmark.entity.UserAccountDayOfWeekSummary;

public interface UserAccountDayOfWeekSummaryDao {

	List<UserAccountDayOfWeekSummary> FindAll();

	List<UserAccountDayOfWeekSummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<DayOfWeekAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair);

	List<DayOfWeekAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountDayOfWeekSummary> FindByUser(int userId);

	List<DayOfWeekAnalaysisByPair> FindByPair(String pair);

}
