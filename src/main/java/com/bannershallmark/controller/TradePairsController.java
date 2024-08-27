package com.bannershallmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.Categories;
import com.bannershallmark.entity.TradePairs;
import com.bannershallmark.service.CategoriesService;
import com.bannershallmark.service.TradePairsService;

@Controller
@RequestMapping("/tradepairs")
public class TradePairsController {
	@Autowired
	private TradePairsService tradePairsService;
	@Autowired
	private CategoriesService categoriesService;

	@GetMapping("/allTradePairs")
	public String allTradePairs(Model model) {
		List<TradePairs> tradePairsList = tradePairsService.findAll();
		model.addAttribute("tradePairsList", tradePairsList);
		return "tradepairs/allTradePairs.html";
	}

	@GetMapping("/addTradePairs")
	public String addTradePairs(Model model) {
		List<Categories> categoriesList = categoriesService.FindAll();
		model.addAttribute("categoriesList", categoriesList);
		return "tradepairs/addTradePairs.html";
	}

	@GetMapping("/editTradePairs")
	public String editTradePairs(@RequestParam("id") int id, Model model) {
		TradePairs tradePairs = tradePairsService.FindById(id);
		List<Categories> categoriesList = categoriesService.FindAll();
		model.addAttribute("categoriesList", categoriesList);
		model.addAttribute("tradePairs", tradePairs);
		return "tradepairs/addTradePairs.html";
	}

	@GetMapping("/deleteTradePairs")
	public String deleteTradePairs(@RequestParam("id") int id) {
		tradePairsService.DeleteById(id);
		return "redirect:/tradepairs/allTradePairs";
	}

	@PostMapping("/saveTradepairs")
	public String saveTradePairs(TradePairs tradePairs, @RequestParam("catg") int catg) {
		Categories categories = categoriesService.FindById(catg);
		tradePairs.setCategory(categories);
		tradePairsService.save(tradePairs);
		return "redirect:/tradepairs/allTradePairs";
	}
}
