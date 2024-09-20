package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UserAccountYearlySummary;
import com.bannershallmark.entity.YearlyAnalaysisByPair;
import com.bannershallmark.entity.YearlyAnalaysisByUserAndAccount;
import com.bannershallmark.entity.YearlyAnalaysisByUserAndPair;

public interface UserAccountYearlySummaryService {

	List<UserAccountYearlySummary> FindAll();

	List<UserAccountYearlySummary> FindByUserPairAndAccountLogin(int userId, String pair, String accountLogin);

	List<YearlyAnalaysisByUserAndPair> FindByUserAndPair(int userId, String pair);

	List<YearlyAnalaysisByUserAndAccount> FindByUserAndAccountLogin(int userId, String accountLogin);

	List<UserAccountYearlySummary> FindByUser(int userId);

	List<YearlyAnalaysisByPair> FindByPair(String pair);

}
