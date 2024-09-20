package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.DailyAnalaysisByPair;
import com.bannershallmark.entity.DailyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.DailyAnalaysisByUserAndPair;
import com.bannershallmark.entity.UserAccountDailySummary;

public interface UserAccountDailySummaryService {

	List<UserAccountDailySummary> FindAll();

	List<UserAccountDailySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<DailyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair);

	List<DailyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountDailySummary> FindByUser(int userId);

	List<DailyAnalaysisByPair> FindByPair(String pair);

}
