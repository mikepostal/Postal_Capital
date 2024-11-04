package com.bannershallmark.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.bannershallmark.entity.Calander;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.CalanderService;
import com.bannershallmark.service.MyUserDetails;
import com.bannershallmark.util.Constants;

@Controller
@RequestMapping("/calander")
public class CalanderController {

	@Autowired
	private CalanderService calanderService;

	@GetMapping("/allCalanders")
	public String allCalanders(Model model, RedirectAttributes redirectAttributes) throws Exception {
//		calanderService.deleteOldCalanders();
		List<Calander> calanders = calanderService.findAllCalanders();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("calanders", calanders);

		return "calander/allCalanders.html";
	}

	@GetMapping("/addCalander")
	public String addCalander(Model model, RedirectAttributes redirectAttributes) throws Exception {

		Calander calander = new Calander();
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("calander11", calander);

		return "calander/addCalander.html";
	}

	@PostMapping("/addNewCalander")
	public String addNewCalander(Calander calander, @RequestParam("stfrom") String stfrom,
			@RequestParam("endDate") String endDate, RedirectAttributes redirectAttributes) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

		LocalDateTime localFrom = LocalDateTime.parse(stfrom, formatter);
		LocalDateTime localTo = LocalDateTime.parse(endDate, formatter);
		calander.setStartfrom(localFrom);
		calander.setEndto(localTo);
		calanderService.save(calander);
		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "New calander added");

		return "redirect:/calander/allCalanders";
	}

	@GetMapping("/getCalander/{calanderId}")
	public String getPayby(@PathVariable("calanderId") Integer calanderId, Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		Calander calander = calanderService.findCalanderById(calanderId);
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("calander", calander);

		return "calander/addCalander.html";
	}

//	@PostMapping("/updateCalander")
//	public String updateCalander(@ModelAttribute Calander calander, RedirectAttributes redirectAttributes) throws Exception {
//
//		calanderService.save(calander);
//		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "Calander updated");
//					
//		return "redirect:/calander/allCalanders";
//	}

	@GetMapping("/deleteCalander/{calanderId}")
	public String deleteCalander(@PathVariable("calanderId") Integer calanderId, RedirectAttributes redirectAttributes)
			throws Exception {

		calanderService.deleteCalanderById(calanderId);
		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "Calander deleted");

		return "redirect:/calander/allCalanders";
	}

	@GetMapping("/checkTime")
	public ResponseEntity<String> checkTime(@RequestParam String currentTime) {
		// Parse the incoming string to LocalDateTime
		LocalDateTime parsedCurrentTime = LocalDateTime.parse(currentTime.replace(" ", "T"));
//		System.out.println("currentTime========================== " + parsedCurrentTime);

		List<Calander> calanders = calanderService.findAllCalanders();
		boolean shouldPlaySound = false;

		for (Calander calander : calanders) {
			// Use isEqual method for comparing two LocalDateTime objects
			if (calander.getStartfrom().isEqual(parsedCurrentTime)) {
				shouldPlaySound = true;
				break; // Exit loop once a match is found
			}
		}

		return ResponseEntity.ok(String.valueOf(shouldPlaySound));
	}

}
