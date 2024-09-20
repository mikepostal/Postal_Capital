package com.bannershallmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.TradersAccounts;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.AccountsService;
import com.bannershallmark.service.MyUserDetails;
import com.bannershallmark.service.TradersAccountsService;
import com.bannershallmark.service.UsersDetailsService;

@Controller
@RequestMapping("/tradersAccounts")
public class TradersAccountsController {
	@Autowired
	private TradersAccountsService tradersAccountsService;
	@Autowired
	private UsersDetailsService usersDetailsService;
	@Autowired
	private AccountsService accountsService;

	@GetMapping("/allTradersAccounts")
	public String allTradersAccounts(Model model) {
		List<TradersAccounts> tradersAccountsList = tradersAccountsService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("tradersAccountsList", tradersAccountsList);
		return "tradersAccounts/allTradersAccounts.html";
	}

	@GetMapping("/addTradersAccounts")
	public String addTradersAccounts(Model model) {
		List<Users> usersList = usersDetailsService.findAll();
		List<Accounts> accountsList = accountsService.findAllAccounts();
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("accountsList", accountsList);
		model.addAttribute("usersList", usersList);
		return "tradersAccounts/tradersAccounts.html";
	}

	@PostMapping("/saveTradersAccounts")
	public String saveTradersAccounts(TradersAccounts tradersAccounts, @RequestParam("userId") int userId,
			@RequestParam("accId") int accId) {
		Accounts accounts = accountsService.findAccountsById(accId);
		Users users = usersDetailsService.findById(userId);
		tradersAccounts.setUser(users);
		tradersAccounts.setAccount(accounts);
		tradersAccountsService.save(tradersAccounts);
		return "redirect:/tradersAccounts/allTradersAccounts";
	}

	@GetMapping("/editTradersAccounts")
	public String editTradersAccounts(@RequestParam("id") int id, Model model) {
		TradersAccounts tradersAccounts = tradersAccountsService.FindById(id);
		List<Users> usersList = usersDetailsService.findAll();
		List<Accounts> accountsList = accountsService.findAllAccounts();
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("accountsList", accountsList);
		model.addAttribute("usersList", usersList);
		model.addAttribute("tradersAccounts", tradersAccounts);
		return "tradersAccounts/tradersAccounts.html";
	}

	@GetMapping("/deleteTradersAccounts")
	public String deleteTradersAccounts(@RequestParam("id") int id) {
		tradersAccountsService.DeleteById(id);
		return "redirect:/tradersAccounts/allTradersAccounts";
	}
	
	@GetMapping("/checkAssignedAccount")
    public ResponseEntity<Boolean> existsByAccountId(@RequestParam("accountId") int accountId) {
        boolean exists = accountsService.existsByAccountId(accountId);
        return ResponseEntity.ok(exists);
    }
}
