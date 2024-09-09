package com.bannershallmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.Categories;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.CategoriesService;
import com.bannershallmark.service.MyUserDetails;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping("/allCategories")
	public String allCategories(Model model) {
		List<Categories> categoriesList = categoriesService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("categoriesList", categoriesList);
		return "category/allCategories.html";
	}
	
	@GetMapping("/addCategory")
	public String addCategory(Model model) {
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		return "category/category.html";
	}
	@PostMapping("/saveCategory")
	public String saveCategory(Categories categories) {
		categoriesService.save(categories);
		return "redirect:/categories/allCategories";
	}
	@GetMapping("/editCategory")
	public String editCategory(@RequestParam("id") int id, Model model) {
		Categories categories = categoriesService.FindById(id);
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("categories", categories);
		return "category/category.html";
	}
	@GetMapping("/deleteCategory")
	public String deleteCategory(@RequestParam("id") int id) {
		categoriesService.DeleteById(id);
		return "redirect:/categories/allCategories";
	}
}
