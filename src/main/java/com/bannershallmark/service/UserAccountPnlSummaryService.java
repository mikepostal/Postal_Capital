package com.bannershallmark.service;

import java.util.List;

import com.bannershallmark.entity.UserAccountPnlSummary;
import com.bannershallmark.entity.UsersEquityChart;

public interface UserAccountPnlSummaryService {

	List<UserAccountPnlSummary> FindAll();

	List<UserAccountPnlSummary> FindByUserIdAndAccountLogin(int userId, String accountLogin);

	List<UsersEquityChart> FindEquityChartByUserIdAndAccountLogin(int userId, String accountLogin);

}
