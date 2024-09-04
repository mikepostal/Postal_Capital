package com.bannershallmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.AffectedByCalander;
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
	public String addTradePairs(@RequestParam("id") int id,Model model) {
		Categories categories = categoriesService.FindById(id);
		model.addAttribute("categories", categories);
		return "tradepairs/addTradePairs.html";
	}

	@GetMapping("/editTradePairs")
	public String editTradePairs(@RequestParam("id") int id,@RequestParam("catId") int catId, Model model) {
		TradePairs tradePairs = tradePairsService.FindById(id);
		Categories categories = categoriesService.FindById(catId);
		model.addAttribute("categories", categories);
		model.addAttribute("categories", categories);
		model.addAttribute("tradePairs", tradePairs);
		return "tradepairs/addTradePairs.html";
	}

	@GetMapping("/deleteTradePairs")
	public String deleteTradePairs(@RequestParam("id") int id) {
		tradePairsService.DeleteById(id);
		return "redirect:/categories/allCategories";
	}

	@PostMapping("/saveTradepairs")
	public String saveTradePairs(TradePairs tradePairs, @RequestParam("catg") int catg,
			@RequestParam("pairName") List<String> pairName) {
		Categories categories = categoriesService.FindById(catg);
		for (String pair : pairName) {
			if (tradePairs.getTrdpairsID() != null) {
				tradePairs.setCategory(categories);
				tradePairs.setPairName(pair);
				tradePairsService.save(tradePairs);
				continue;
			}
			TradePairs newtradePairs = new TradePairs();
			newtradePairs.setCategory(categories);
			newtradePairs.setPairName(pair);
			tradePairsService.save(newtradePairs);
		}

		return "redirect:/categories/allCategories";
	}
}
