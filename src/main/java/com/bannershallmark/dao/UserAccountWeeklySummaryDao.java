package com.bannershallmark.dao;

import java.util.List;

import com.bannershallmark.entity.UserAccountWeeklySummary;
import com.bannershallmark.entity.WeeklyAnalaysisByPair;
import com.bannershallmark.entity.WeeklyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.WeeklyAnalaysisByUserAndPair;

public interface UserAccountWeeklySummaryDao {

	List<UserAccountWeeklySummary> FindAll();

	List<UserAccountWeeklySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<WeeklyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair);

	List<WeeklyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountWeeklySummary> FindByUser(int userId);

	List<WeeklyAnalaysisByPair> FindByPair(String pair);

}
