package com.bannershallmark.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bannershallmark.util.AccessPermissionUtil;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
		
	
	@Autowired
	AccessPermissionUtil accessPermissionUtil;
	
	private static Logger testNGlogger = Logger.getLogger(DashboardController.class);

	
	
}
