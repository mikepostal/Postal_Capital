package com.bannershallmark.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.AffectedByCalander;
import com.bannershallmark.entity.Calander;
import com.bannershallmark.entity.TradePairs;
import com.bannershallmark.service.AffectedByCalanderService;
import com.bannershallmark.service.CalanderService;
import com.bannershallmark.service.TradePairsService;

@Controller
@RequestMapping("/calander")
public class AffectedByCalanderController {
	@Autowired
	private AffectedByCalanderService affectedByCalanderService;
	@Autowired
	private CalanderService calanderService;
	@Autowired
	private TradePairsService tradePairsService;

	@GetMapping("/allAffectedByCalander")
	public String allAffectedByCalanders(Model model) {
		List<AffectedByCalander> affectedByCalanders = affectedByCalanderService.FindAll();
		model.addAttribute("affectedByCalanders", affectedByCalanders);
		return "calander/allAffectedByCalander.html";
	}

	@GetMapping("/addAffectedByCalander")
	public String addAffectedByCalander(Model model) {
		List<Calander> calanders = calanderService.findAllCalanders();
		List<TradePairs> tradePairs = tradePairsService.findAll();
		model.addAttribute("calanders", calanders);
		model.addAttribute("tradePairs", tradePairs);
		return "calander/affectedByCalander.html";
	}

	@PostMapping("/saveAffectedByCalander")
	public String saveAffectedByCalanders(AffectedByCalander affectedByCalander, @RequestParam("cal") int cal,
			@RequestParam("trPair") int trPair) {
		Calander calander = calanderService.findCalanderById(cal);
		TradePairs tradePairs = tradePairsService.FindById(trPair);
		affectedByCalander.setCalander(calander);
		affectedByCalander.setTradePairs(tradePairs);
		affectedByCalanderService.save(affectedByCalander);
		return "redirect:/calander/allAffectedByCalander";
	}

	@GetMapping("/editAffectedByCalander")
	public String editAffectedByCalander(@RequestParam("id") int id, Model model) {
		AffectedByCalander affectedByCalander = affectedByCalanderService.FindById(id);
		List<Calander> calanders = calanderService.findAllCalanders();
		List<TradePairs> tradePairs = tradePairsService.findAll();
		model.addAttribute("calanders", calanders);
		model.addAttribute("tradePairs", tradePairs);
		model.addAttribute("affectedByCalander", affectedByCalander);
		return "calander/affectedByCalander.html";
	}

	@GetMapping("/deleteAffectedByCalander")
	public String deleteAffectedByCalander(@RequestParam("id") int id) {
		affectedByCalanderService.DeleteById(id);
		return "redirect:/calander/allAffectedByCalander";
	}
}
