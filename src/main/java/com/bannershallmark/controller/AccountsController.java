package com.bannershallmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bannershallmark.entity.Accounts;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.AccountsService;
import com.bannershallmark.service.MyUserDetails;
import com.bannershallmark.util.Constants;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	private AccountsService accountsService;

	@GetMapping("/allAccounts")
	public String allCalanders(Model model, RedirectAttributes redirectAttributes) throws Exception {

		List<Accounts> accounts = accountsService.findAllAccounts();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("accounts", accounts);

		return "accounts/allAccounts.html";
	}

	@GetMapping("/addAccount")
	public String addCalander(Model model, RedirectAttributes redirectAttributes) throws Exception {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		return "accounts/addAccount.html";
	}

	@PostMapping("/addNewAccount")
	public String addNewCalander(@ModelAttribute Accounts account, RedirectAttributes redirectAttributes)
			throws Exception {

		accountsService.save(account);
		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "New account added");

		return "redirect:/accounts/allAccounts";
	}

	@GetMapping("/getAccount/{accountId}")
	public String getPayby(@PathVariable("accountId") Integer accountId, Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		Accounts account = accountsService.findAccountsById(accountId);
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("account", account);

		return "accounts/addAccount.html";
	}

//	@PostMapping("/updateAccount")
//	public String updateCalander(@ModelAttribute Accounts account, RedirectAttributes redirectAttributes) throws Exception {
//
//		accountsService.save(account);
//		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "Account updated");
//					
//		return "redirect:/accounts/allAccounts";
//	}

	@GetMapping("/deleteAccount/{accountId}")
	public String deleteCalander(@PathVariable("accountId") Integer accountId, RedirectAttributes redirectAttributes)
			throws Exception {

		accountsService.deleteAccountById(accountId);
		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "Account deleted");

		return "redirect:/accounts/allAccounts";
	}
	
	@GetMapping("/checkAccountLogin")
    public ResponseEntity<Boolean> existsByAccountLogin(@RequestParam("accountLogin") String accountLogin) {
        boolean exists = accountsService.existsByAccountLogin(accountLogin);
        return ResponseEntity.ok(exists);
    }

}
