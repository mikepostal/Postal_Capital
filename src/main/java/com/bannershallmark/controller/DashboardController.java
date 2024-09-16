package com.bannershallmark.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.DailyAnalaysis;
import com.bannershallmark.entity.DayOfWeekAnalaysis;
import com.bannershallmark.entity.MonthlyAnalaysis;
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
import com.bannershallmark.entity.UsersDailyAnalaysis;
import com.bannershallmark.entity.UsersDayOfWeekAnalaysis;
import com.bannershallmark.entity.UsersMonthlyAnalaysis;
import com.bannershallmark.entity.UsersWeeklyAnalaysis;
import com.bannershallmark.entity.UsersYearlyAnalaysis;
import com.bannershallmark.entity.WeeklyAnalaysis;
import com.bannershallmark.entity.YearlyAnalaysis;
import com.bannershallmark.service.AccountsService;
import com.bannershallmark.service.DailyAnalaysisService;
import com.bannershallmark.service.DayOfWeekAnalaysisService;
import com.bannershallmark.service.MonthlyAnalaysisService;
import com.bannershallmark.service.MyUserDetails;
import com.bannershallmark.service.TradePairsService;
import com.bannershallmark.service.TradersAccountsService;
import com.bannershallmark.service.UserAccountDailySummaryService;
import com.bannershallmark.service.UserAccountDayOfWeekSummaryService;
import com.bannershallmark.service.UserAccountMonthlySummaryService;
import com.bannershallmark.service.UserAccountPnlSummaryService;
import com.bannershallmark.service.UserAccountShortSummaryService;
import com.bannershallmark.service.UserAccountWeeklySummaryService;
import com.bannershallmark.service.UserAccountYearlySummaryService;
import com.bannershallmark.service.UsersDailyAnalaysisService;
import com.bannershallmark.service.UsersDayOfWeekAnalaysisService;
import com.bannershallmark.service.UsersDetailsService;
import com.bannershallmark.service.UsersMonthlyAnalaysisService;
import com.bannershallmark.service.UsersWeeklyAnalaysisService;
import com.bannershallmark.service.UsersYearlyAnalaysisService;
import com.bannershallmark.service.WeeklyAnalaysisService;
import com.bannershallmark.service.YearlyAnalaysisService;
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
	private UsersDailyAnalaysisService usersDailyAnalaysisService;
	@Autowired
	private UsersWeeklyAnalaysisService usersWeeklyAnalaysisService;
	@Autowired
	private UsersMonthlyAnalaysisService usersMonthlyAnalaysisService;
	@Autowired
	private UsersYearlyAnalaysisService usersYearlyAnalaysisService;
	@Autowired
	private UsersDayOfWeekAnalaysisService usersDayOfWeekAnalaysisService;

	@Autowired
	private DailyAnalaysisService dailyAnalaysisService;
	@Autowired
	private WeeklyAnalaysisService weeklyAnalaysisService;
	@Autowired
	private MonthlyAnalaysisService monthlyAnalaysisService;
	@Autowired
	private YearlyAnalaysisService yearlyAnalaysisService;
	@Autowired
	private DayOfWeekAnalaysisService dayOfWeekAnalaysisService;

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

		MyUserDetails user1 = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user1.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);

		List<TradersAccounts> accountt1 = tradersAccountsService.FindAll();
		List<Users> usersList = userDetailsService.findAll();
		List<TradePairs> tradePairsList = tradePairsService.findAll();

		List<UserAccountPnlSummary> accountPnlSummaryList = userAccountPnlSummaryService.FindAll();
		List<UserAccountShortSummary> userAccountShortSummaries = userAccountShortSummaryService.FindAll();
		List<UserAccountDailySummary> userAccountDailySummaries;
		List<UserAccountDayOfWeekSummary> userAccountDayOfWeekSummaries;
		List<UserAccountMonthlySummary> userAccountMonthlySummaries;
		List<UserAccountWeeklySummary> userAccountWeeklySummaries;
		List<UserAccountYearlySummary> userAccountYearlySummaries;

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
			List<UsersDailyAnalaysis> usersDailyAnalaysis = usersDailyAnalaysisService.FindByUser(userId);
			List<UsersDayOfWeekAnalaysis> usersDayOfWeekAnalaysis = usersDayOfWeekAnalaysisService.FindByUser(userId);
			List<UsersMonthlyAnalaysis> usersMonthlyAnalaysis = usersMonthlyAnalaysisService.FindByUser(userId);
			List<UsersWeeklyAnalaysis> usersWeeklyAnalaysis = usersWeeklyAnalaysisService.FindByUser(userId);
			List<UsersYearlyAnalaysis> usersYearlyAnalaysis = usersYearlyAnalaysisService.FindByUser(userId);

			usersDayOfWeekAnalaysis.sort(Comparator.comparing(d -> {
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

			Collections.sort(usersDailyAnalaysis, new Comparator<UsersDailyAnalaysis>() {
				@Override
				public int compare(UsersDailyAnalaysis o1, UsersDailyAnalaysis o2) {
					return o1.getTradingDate().compareTo(o2.getTradingDate());
				}
			});

			usersMonthlyAnalaysis.sort(Comparator.comparing(UsersMonthlyAnalaysis::getTradingMonth));
			usersWeeklyAnalaysis.sort(Comparator.comparing(UsersWeeklyAnalaysis::getTradingYear)
					.thenComparing(UsersWeeklyAnalaysis::getTradingWeek));
			usersYearlyAnalaysis.sort(Comparator.comparing(UsersYearlyAnalaysis::getTradingYear));

			model.addAttribute("accountPnlSummaryList", accountPnlSummaryList);
			model.addAttribute("userAccountShortSummaries", userAccountShortSummaries);
			model.addAttribute("userAccountDailySummaries", usersDailyAnalaysis);
			model.addAttribute("userAccountDayOfWeekSummaries", usersDayOfWeekAnalaysis);
			model.addAttribute("userAccountMonthlySummaries", usersMonthlyAnalaysis);
			model.addAttribute("userAccountWeeklySummaries", usersWeeklyAnalaysis);
			model.addAttribute("userAccountYearlySummaries", usersYearlyAnalaysis);

			model.addAttribute("usersList", usersList);
			model.addAttribute("tradePairsList", tradePairsList);
			model.addAttribute("accounts", accounts);
			if (accounts == null) {
				model.addAttribute("accounts", accountt1);
			}
			model.addAttribute("userId", userId);
			return "/dashboard/dashboard.html";

		} else if (pair != "" && pair != null) {
			userAccountDailySummaries = userAccountDailySummaryService.FindByPair(pair);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByPair(pair);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByPair(pair);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByPair(pair);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByPair(pair);
			model.addAttribute("pair", pair);
		} else {
			List<DailyAnalaysis> dailyAnalaysis = dailyAnalaysisService.FindAll();
			List<DayOfWeekAnalaysis> dayOfWeekAnalaysis = dayOfWeekAnalaysisService.FindAll();
			List<WeeklyAnalaysis> weeklyAnalaysis = weeklyAnalaysisService.FindAll();
			List<MonthlyAnalaysis> monthlyAnalaysis = monthlyAnalaysisService.FindAll();
			List<YearlyAnalaysis> yearlyAnalaysis = yearlyAnalaysisService.FindAll();

			dayOfWeekAnalaysis.sort(Comparator.comparing(d -> {
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

			Collections.sort(dailyAnalaysis, new Comparator<DailyAnalaysis>() {
				@Override
				public int compare(DailyAnalaysis o1, DailyAnalaysis o2) {
					return o1.getTradingDate().compareTo(o2.getTradingDate());
				}
			});

			monthlyAnalaysis.sort(Comparator.comparing(MonthlyAnalaysis::getTradingMonth));
			weeklyAnalaysis.sort(Comparator.comparing(WeeklyAnalaysis::getTradingYear)
					.thenComparing(WeeklyAnalaysis::getTradingWeek));
			yearlyAnalaysis.sort(Comparator.comparing(YearlyAnalaysis::getTradingYear));

			model.addAttribute("accountPnlSummaryList", accountPnlSummaryList);
			model.addAttribute("userAccountShortSummaries", userAccountShortSummaries);
			model.addAttribute("userAccountDailySummaries", dailyAnalaysis);
			model.addAttribute("userAccountDayOfWeekSummaries", dayOfWeekAnalaysis);
			model.addAttribute("userAccountMonthlySummaries", monthlyAnalaysis);
			model.addAttribute("userAccountWeeklySummaries", weeklyAnalaysis);
			model.addAttribute("userAccountYearlySummaries", yearlyAnalaysis);

			model.addAttribute("usersList", usersList);
			model.addAttribute("tradePairsList", tradePairsList);
			model.addAttribute("accounts", accounts);
			if (accounts == null) {
				model.addAttribute("accounts", accountt1);
			}

			return "/dashboard/dashboard.html";
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
		if (accounts == null) {
			model.addAttribute("accounts", accountt1);
		}

		return "/dashboard/dashboard.html";
	}

	@GetMapping("/tradersAccountsByUser")
	public ResponseEntity<List<TradersAccounts>> getAccountsByUser(@RequestParam("userId") int userId, Model model) {
		
		try {
			List<TradersAccounts> accounts = tradersAccountsService.findByUserId(userId);
			if (accounts == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
			}
			System.out.println("acccc =========================== " + accounts.size());
			return ResponseEntity.ok(accounts);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
		}
	}

	@GetMapping("/tradersDashboard")
	public String TradersDashboard(@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "accountLogin", required = false) String accountLogin, Model model) {

		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int userId = users.getId();
		int role = users.getRole().getId();
		model.addAttribute("role", role);

		List<TradePairs> tradePairsList = tradePairsService.findAll();
		List<TradersAccounts> accountsList = tradersAccountsService.findByUserId(userId);

		List<UserAccountShortSummary> userAccountShortSummaries = userAccountShortSummaryService.findByUserId(userId);
		List<UserAccountDailySummary> userAccountDailySummaries = userAccountDailySummaryService.FindByUser(userId);
		List<UserAccountDayOfWeekSummary> userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService
				.FindByUser(userId);
		List<UserAccountMonthlySummary> userAccountMonthlySummaries = userAccountMonthlySummaryService
				.FindByUser(userId);
		List<UserAccountWeeklySummary> userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByUser(userId);
		List<UserAccountYearlySummary> userAccountYearlySummaries = userAccountYearlySummaryService.FindByUser(userId);

		if (pair != "" && pair != null && accountLogin != "" && accountLogin != null) {
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
			model.addAttribute("pair", pair);
			model.addAttribute("accountLogin", accountLogin);
		} else if (pair != "" && pair != null) {
			userAccountDailySummaries = userAccountDailySummaryService.FindByUserAndPair(userId, pair);
			userAccountDayOfWeekSummaries = userAccountDayOfWeekSummaryService.FindByUserAndPair(userId, pair);
			userAccountMonthlySummaries = userAccountMonthlySummaryService.FindByUserAndPair(userId, pair);
			userAccountWeeklySummaries = userAccountWeeklySummaryService.FindByUserAndPair(userId, pair);
			userAccountYearlySummaries = userAccountYearlySummaryService.FindByUserAndPair(userId, pair);
			model.addAttribute("userId", userId);
			model.addAttribute("pair", pair);
		} else if (accountLogin != "" && accountLogin != null) {
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
		} else {

			List<UsersDailyAnalaysis> usersDailyAnalaysis = usersDailyAnalaysisService.FindByUser(userId);
			List<UsersDayOfWeekAnalaysis> usersDayOfWeekAnalaysis = usersDayOfWeekAnalaysisService.FindByUser(userId);
			List<UsersMonthlyAnalaysis> usersMonthlyAnalaysis = usersMonthlyAnalaysisService.FindByUser(userId);
			List<UsersWeeklyAnalaysis> usersWeeklyAnalaysis = usersWeeklyAnalaysisService.FindByUser(userId);
			List<UsersYearlyAnalaysis> usersYearlyAnalaysis = usersYearlyAnalaysisService.FindByUser(userId);

			usersDayOfWeekAnalaysis.sort(Comparator.comparing(d -> {
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

			Collections.sort(usersDailyAnalaysis, new Comparator<UsersDailyAnalaysis>() {
				@Override
				public int compare(UsersDailyAnalaysis o1, UsersDailyAnalaysis o2) {
					return o1.getTradingDate().compareTo(o2.getTradingDate());
				}
			});

			usersMonthlyAnalaysis.sort(Comparator.comparing(UsersMonthlyAnalaysis::getTradingMonth));
			usersWeeklyAnalaysis.sort(Comparator.comparing(UsersWeeklyAnalaysis::getTradingYear)
					.thenComparing(UsersWeeklyAnalaysis::getTradingWeek));
			usersYearlyAnalaysis.sort(Comparator.comparing(UsersYearlyAnalaysis::getTradingYear));

			model.addAttribute("userAccountShortSummaries", userAccountShortSummaries);
			model.addAttribute("userAccountDailySummaries", usersDailyAnalaysis);
			model.addAttribute("userAccountDayOfWeekSummaries", usersDayOfWeekAnalaysis);
			model.addAttribute("userAccountMonthlySummaries", usersMonthlyAnalaysis);
			model.addAttribute("userAccountWeeklySummaries", usersWeeklyAnalaysis);
			model.addAttribute("userAccountYearlySummaries", usersYearlyAnalaysis);

			model.addAttribute("tradePairsList", tradePairsList);
			model.addAttribute("accounts", accountsList);

			return "/dashboard/traderDashboard.html";
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

		model.addAttribute("userAccountShortSummaries", userAccountShortSummaries);
		model.addAttribute("userAccountDailySummaries", userAccountDailySummaries);
		model.addAttribute("userAccountDayOfWeekSummaries", userAccountDayOfWeekSummaries);
		model.addAttribute("userAccountMonthlySummaries", userAccountMonthlySummaries);
		model.addAttribute("userAccountWeeklySummaries", userAccountWeeklySummaries);
		model.addAttribute("userAccountYearlySummaries", userAccountYearlySummaries);

		model.addAttribute("tradePairsList", tradePairsList);
		model.addAttribute("accounts", accountsList);

		return "/dashboard/traderDashboard.html";
	}
}
