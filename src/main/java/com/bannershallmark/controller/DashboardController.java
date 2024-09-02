package com.bannershallmark.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bannershallmark.entity.UserAccountDailySummary;
import com.bannershallmark.entity.UserAccountPnlSummary;
import com.bannershallmark.entity.UserAccountShortSummary;
import com.bannershallmark.service.UserAccountDailySummaryService;
import com.bannershallmark.service.UserAccountPnlSummaryService;
import com.bannershallmark.service.UserAccountShortSummaryService;
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

	private static Logger testNGlogger = Logger.getLogger(DashboardController.class);

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<UserAccountPnlSummary> accountPnlSummaryList = userAccountPnlSummaryService.FindAll();
		List<UserAccountShortSummary> userAccountShortSummaries = userAccountShortSummaryService.FindAll();
		List<UserAccountDailySummary> userAccountDailySummaries = userAccountDailySummaryService.FindAll();

		Collections.sort(userAccountDailySummaries, new Comparator<UserAccountDailySummary>() {
			@Override
			public int compare(UserAccountDailySummary o1, UserAccountDailySummary o2) {
				return o1.getTradingDate().compareTo(o2.getTradingDate());
			}
		});
		model.addAttribute("accountPnlSummaryList", accountPnlSummaryList);
		model.addAttribute("userAccountShortSummaries", userAccountShortSummaries);
		model.addAttribute("userAccountDailySummaries", userAccountDailySummaries);
		return "/dashboard/dashboard.html";
	}
}
