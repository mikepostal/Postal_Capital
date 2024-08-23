package com.bannershallmark.controller;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bannershallmark.config.MultipleWebSecurityConfig.WebSecurityConfig;
import com.bannershallmark.dao.UsersDao;
import com.bannershallmark.service.ForgotPasswordService;
import com.bannershallmark.service.UsersDetailsService;

@Controller
public class LoginController {
	private static Logger testNGlogger = Logger.getLogger(LoginController.class);

	@Autowired
	UsersDao usersDao;
	@Autowired
	ForgotPasswordService forgotPasswordService;
	@Autowired
	UsersDetailsService usersDetailsService;
	@Autowired
	WebSecurityConfig webSecurityConfig;

	@GetMapping("/login")
	public String stores(Model model) {

		return "login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		try {
			session.removeAttribute("username");
		} catch (Exception e) {
			e.printStackTrace();
			testNGlogger.info("/logout" + ",ERROR MESSAGES : " + e.getMessage());
			// testNGlogger.error(e.getMessage());
			return "errorpage/error";
		}
		return "redirect:../login";
	}

}
