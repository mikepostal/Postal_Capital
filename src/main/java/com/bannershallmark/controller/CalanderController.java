package com.bannershallmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bannershallmark.entity.Calander;
import com.bannershallmark.service.CalanderService;
import com.bannershallmark.util.Constants;

@Controller
@RequestMapping("/calander")
public class CalanderController {

	@Autowired
	private CalanderService calanderService;
	


	@GetMapping("/allCalanders")
	public String allCalanders(Model model, RedirectAttributes redirectAttributes) throws Exception {
		
		List<Calander> calanders = calanderService.findAllCalanders();
		model.addAttribute("calanders", calanders);
				
		return "calander/allCalanders.html";
	}
	
	@GetMapping("/addCalander")
	public String addCalander(Model model, RedirectAttributes redirectAttributes) throws Exception {
		
		Calander calander = new Calander();
		model.addAttribute("calander11", calander);
		
		return "calander/addCalander.html";			
	}
	
	@PostMapping("/addNewCalander")
	public String addNewCalander(@ModelAttribute Calander calander, RedirectAttributes redirectAttributes) throws Exception {

		calanderService.save(calander);
		redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE, "New calander added");
					
		return "redirect:/calander/allCalanders";
	}
	
	@GetMapping("/getCalander/{calanderId}")
	public String getPayby(@PathVariable("calanderId") Integer calanderId, Model model, RedirectAttributes redirectAttributes)
			throws Exception {
		
		Calander calander = calanderService.findCalanderById(calanderId);
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
	
}
