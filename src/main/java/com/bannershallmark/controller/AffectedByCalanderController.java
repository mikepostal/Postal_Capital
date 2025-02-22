package com.bannershallmark.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.AffectedByCalander;
import com.bannershallmark.entity.Calander;
import com.bannershallmark.entity.TradePairs;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.AffectedByCalanderService;
import com.bannershallmark.service.CalanderService;
import com.bannershallmark.service.MyUserDetails;
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
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("affectedByCalanders", affectedByCalanders);
		return "calander/allAffectedByCalander.html";
	}

	@GetMapping("/addAffectedByCalander")
	public String addAffectedByCalander(Model model) {
		List<Calander> calanders = calanderService.findAllCalanders();
		List<TradePairs> tradePairs = tradePairsService.findAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("calanders", calanders);
		model.addAttribute("tradePairs", tradePairs);
		return "calander/affectedByCalander.html";
	}

	@PostMapping("/saveAffectedByCalander")
	public String saveAffectedByCalander(AffectedByCalander affectedByCalander, @RequestParam("cal") int cal,
			@RequestParam("trPair") List<Integer> trPair) {
		Calander calander = calanderService.findCalanderById(cal);
		TradePairs selectedTradePairs;
		if (calander == null) {
			System.err.println("Error: Calendar not found with ID " + cal);
			return "redirect:/calander/allAffectedByCalander?error=calendarNotFound";
		}

		for (Integer pairId : trPair) {
			System.out.println("Processing TradePair ID: " + pairId);
			selectedTradePairs = tradePairsService.FindById(pairId);
			if (selectedTradePairs == null) {
				System.err.println("Error: TradePairs not found with ID " + pairId);
				continue;
			}
			if (affectedByCalander.getAffectedByCalanderID() != null) {
				affectedByCalander.setCalander(calander);
				affectedByCalander.setTradePairs(selectedTradePairs);
				affectedByCalanderService.save(affectedByCalander);
				return "redirect:/calander/allAffectedByCalander";
			}
			AffectedByCalander newAffectedByCalander = new AffectedByCalander();
			newAffectedByCalander.setCalander(calander);
			newAffectedByCalander.setTradePairs(selectedTradePairs);

			affectedByCalanderService.save(newAffectedByCalander);
		}

		return "redirect:/calander/allAffectedByCalander";
	}

	@GetMapping("/editAffectedByCalander")
	public String editAffectedByCalander(@RequestParam("id") int id, Model model) {
		AffectedByCalander affectedByCalander = affectedByCalanderService.FindById(id);
		List<Calander> calanders = calanderService.findAllCalanders();
		List<TradePairs> tradePairs = tradePairsService.findAll();
		////to Access user role////////////////
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
///////////////////////		end//////////
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
