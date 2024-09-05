package com.bannershallmark.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.TradePairs;
import com.bannershallmark.entity.TradersAccounts;
import com.bannershallmark.entity.UserAccountDailySummary;
import com.bannershallmark.entity.UserAccountDayOfWeekSummary;
import com.bannershallmark.entity.UserAccountMonthlySummary;
import com.bannershallmark.entity.UserAccountPnlSummary;
import com.bannershallmark.entity.UserAccountShortSummary;
import com.bannershallmark.entity.UserAccountWeeklySummary;
import com.bannershallmark.entity.UserAccountYearlySummary;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.AccountsService;
import com.bannershallmark.service.TradePairsService;
import com.bannershallmark.service.TradersAccountsService;
import com.bannershallmark.service.UserAccountDailySummaryService;
import com.bannershallmark.service.UserAccountDayOfWeekSummaryService;
import com.bannershallmark.service.UserAccountMonthlySummaryService;
import com.bannershallmark.service.UserAccountPnlSummaryService;
import com.bannershallmark.service.UserAccountShortSummaryService;
import com.bannershallmark.service.UserAccountWeeklySummaryService;
import com.bannershallmark.service.UserAccountYearlySummaryService;
import com.bannershallmark.service.UsersDetailsService;
import com.bannershallmark.util.AccessPermissionUtil;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	AccessPermissionUtil accessPermissionUtil;
	@Autowired
	private UserAccountPnlSummaryService userAccountPnlSummaryService;
	@Autowired
	private UserAccountShortSummaryService userAccountShortSummaryService;
	@Autowired
	private UserAccountDailySummaryService userAccountDailySummaryService;
	@Autowired
	private UserAccountDayOfWeekSummaryService userAccountDayOfWeekSummaryService;
	@Autowired
	private UserAccountMonthlySummaryService userAccountMonthlySummaryService;
	@Autowired
	private UserAccountWeeklySummaryService userAccountWeeklySummaryService;
	@Autowired
	private UserAccountYearlySummaryService userAccountYearlySummaryService;

	@Autowired
	private UsersDetailsService userDetailsService;
	@Autowired
	private TradePairsService tradePairsService;
	@Autowired
	private AccountsService accountsService;
	@Autowired
	private TradersAccountsService tradersAccountsService;

	private static Logger testNGlogger = Logger.getLogger(DashboardController.class);

	public List<TradersAccounts> accounts = null;

	@GetMapping("/dashboard")
	public String dashboard(@RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "accountLogin", required = false) String accountLogin, Model model) {

		List<Users> usersList = userDetailsService.findAll();
		List<TradePairs> tradePairsList = tradePairsService.findAll();

		List<UserAccountPnlSummary> accountPnlSummaryList = userAccountPnlSummaryService.FindAll();
		List<UserAccountShortSummary> userAccountShortSummaries = userAccountShortSummaryService.FindAll();
		List<UserAccountDailySummary> userAccountDailySummaries = userAccountDailySummaryService.FindAll();
		List<UserAccountDayOfWeekSummary> userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindAll();
		List<UserAccountMonthlySummary> userAccountMonthlySummaries = userAccountMonthlySummaryService.FindAll();
		List<UserAccountWeeklySummary> userAccountWeeklySummaries = userAccountWeeklySummaryService.FindAll();
		List<UserAccountYearlySummary> userAccountYearlySummaries = userAccountYearlySummaryService.FindAll();

		if (user != "" && user != null && pair != "" && pair != null && accountLogin != "" && accountLogin != null) {
			int userId = Integer.parseInt(user);
			userAccountDailySummaries = userAccountDailySummaryService.FindByUserPairAndAccountLogin(userId, pair,
					accountLogin);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByUserPairAndAccountLogin(userId,
					pair, accountLogin);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByUserPairAndAccountLogin(userId, pair,
					accountLogin);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByUserPairAndAccountLogin(userId, pair,
					accountLogin);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByUserPairAndAccountLogin(userId, pair,
					accountLogin);
			model.addAttribute("userId", userId);
			model.addAttribute("pair", pair);
			model.addAttribute("accountLogin", accountLogin);
		} else if (user != "" && user != null && pair != "" && pair != null) {
			int userId = Integer.parseInt(user);
			userAccountDailySummaries = userAccountDailySummaryService.FindByUserAndPair(userId, pair);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByUserAndPair(userId, pair);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByUserAndPair(userId, pair);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByUserAndPair(userId, pair);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByUserAndPair(userId, pair);
			model.addAttribute("userId", userId);
			model.addAttribute("pair", pair);
		} else if (user != "" && user != null && accountLogin != "" && accountLogin != null) {
			int userId = Integer.parseInt(user);
			userAccountDailySummaries = userAccountDailySummaryService.FindByUserAndAccountLogin(userId, accountLogin);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByUserAndAccountLogin(userId,
					accountLogin);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByUserAndAccountLogin(userId,
					accountLogin);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByUserAndAccountLogin(userId,
					accountLogin);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByUserAndAccountLogin(userId,
					accountLogin);
			model.addAttribute("userId", userId);
			model.addAttribute("accountLogin", accountLogin);
		} else if (user != "" && user != null) {
			int userId = Integer.parseInt(user);
			userAccountDailySummaries = userAccountDailySummaryService.FindByUser(userId);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByUser(userId);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByUser(userId);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByUser(userId);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByUser(userId);
			model.addAttribute("userId", userId);
		} else if (pair != "" && pair != null) {
			userAccountDailySummaries = userAccountDailySummaryService.FindByPair(pair);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByPair(pair);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByPair(pair);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByPair(pair);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByPair(pair);
			model.addAttribute("pair", pair);
		}

		userAccountDayOfWeekSummaries.sort(Comparator.comparing(d -> {
			switch (d.getDayOfWeek()) {
			case "Monday":
				return 1;
			case "Tuesday":
				return 2;
			case "Wednesday":
				return 3;
			case "Thursday":
				return 4;
			case "Friday":
				return 5;
			case "Saturday":
				return 6;
			case "Sunday":
				return 7;
			default:
				return 0;
			}
		}));

		Collections.sort(userAccountDailySummaries, new Comparator<UserAccountDailySummary>() {
			@Override
			public int compare(UserAccountDailySummary o1, UserAccountDailySummary o2) {
				return o1.getTradingDate().compareTo(o2.getTradingDate());
			}
		});

		userAccountMonthlySummaries.sort(Comparator.comparing(UserAccountMonthlySummary::getTradingMonth));
		userAccountWeeklySummaries.sort(Comparator.comparing(UserAccountWeeklySummary::getTradingYear)
				.thenComparing(UserAccountWeeklySummary::getTradingWeek));
		userAccountYearlySummaries.sort(Comparator.comparing(UserAccountYearlySummary::getTradingYear));

		model.addAttribute("accountPnlSummaryList", accountPnlSummaryList);
		model.addAttribute("userAccountShortSummaries", userAccountShortSummaries);
		model.addAttribute("userAccountDailySummaries", userAccountDailySummaries);
		model.addAttribute("userAccountDayOfWeekSummaries", userAccountDayOfWeekSummaries);
		model.addAttribute("userAccountMonthlySummaries", userAccountMonthlySummaries);
		model.addAttribute("userAccountWeeklySummaries", userAccountWeeklySummaries);
		model.addAttribute("userAccountYearlySummaries", userAccountYearlySummaries);

		model.addAttribute("usersList", usersList);
		model.addAttribute("tradePairsList", tradePairsList);
		model.addAttribute("accounts", accounts);

		return "/dashboard/dashboard.html";
	}

	@GetMapping("/tradersAccountsByUser")
	public ResponseEntity<List<TradersAccounts>> getAccountsByUser(@RequestParam("userId") int userId) {
		accounts = tradersAccountsService.findByUserId(userId);
		return ResponseEntity.ok(accounts);
	}
}
