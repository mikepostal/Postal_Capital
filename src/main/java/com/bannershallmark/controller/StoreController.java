package com.bannershallmark.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.bannershallmark.entity.Store;
import com.bannershallmark.service.StoreService;
import com.bannershallmark.util.AccessPermissionUtil;
import com.bannershallmark.util.Constants;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	@Autowired
	AccessPermissionUtil accessPermissionUtil;

	

	
	private static Logger testNGlogger = Logger.getLogger(StoreController.class);


	@GetMapping("/stores")
	public String stores(Model model, RedirectAttributes redirectAttributes) throws Exception {

		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("store/stores");
			if (accessStatus) {
				try {
					List<Store> stores = storeService.findAll();
					model.addAttribute("stores", stores);
				} catch (Exception e) {
					testNGlogger.info("store/stores" + ",ERROR MESSAGES : " + e.getMessage());
					return "errorpage/error";
				}
				return "store/stores";
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("store/stores" + ",ERROR MESSAGES : " + e.getMessage());
			return "/";
		}
	}
	
	
	@GetMapping("/storesIsActive/{isActive}")
	public String storesByIsActive(Model model,@PathVariable("isActive") Boolean isActive, RedirectAttributes redirectAttributes) throws Exception {

		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("store/storesIsActive");
			if (accessStatus) {
				try {
					List<Store> stores = storeService.findAllByIsActive(isActive);
					model.addAttribute("stores", stores);
				} catch (Exception e) {
					testNGlogger.info("store/stores" + ",ERROR MESSAGES : " + e.getMessage());
					return "errorpage/error";
				}
				return "store/stores";
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("store/storesIsActive" + ",ERROR MESSAGES : " + e.getMessage());
			return "/";
		}
	}

	@GetMapping("/addStore")
	public String addStore(Model model, RedirectAttributes redirectAttributes) throws Exception {
		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("store/addStore");

			if (accessStatus) {
				Store store = new Store();
				model.addAttribute("store", store);
				return "store/addStore";
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("store/addStore" + ",ERROR MESSAGES : " + e.getMessage());
			return "/";
		}
	}

	

	@RequestMapping("/getStore/{id}")
	public String getStore(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes)
			throws Exception {

		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("store/getStore");
			if (accessStatus) {
				try {
					Store store = storeService.findById(id);
					model.addAttribute("store", store);
				} catch (Exception e) {
					testNGlogger.info("store/getStore" + ",ERROR MESSAGES : " + e.getMessage());
					return "errorpage/error";
				}
				return "store/editStore";
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("store/getStore" + ",ERROR MESSAGES : " + e.getMessage());
			return "/";
		}

	}
}
