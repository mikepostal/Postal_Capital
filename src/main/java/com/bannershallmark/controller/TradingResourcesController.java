package com.bannershallmark.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bannershallmark.entity.TradingResources;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.MyUserDetails;
import com.bannershallmark.service.TradingResourcesService;

@Controller
@RequestMapping("/tradingResources")
public class TradingResourcesController {

	@Autowired
	private TradingResourcesService tradingResourcesService;

	@GetMapping("/allTradingResources")
	public String allTradingResources(Model model) {
		List<TradingResources> tradingResourcesList = tradingResourcesService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("tradingResourcesList", tradingResourcesList);
		return "tradingResources/allTradingResources.html";
	}

	@GetMapping("/addTradingResources")
	public String addTradingResources(Model model) {
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		return "tradingResources/tradingResources.html";
	}

	@PostMapping("/saveTradingResources")
	public String saveTradingResources(TradingResources tradingResources, @RequestParam("video") MultipartFile video,
			@RequestParam("doc") MultipartFile doc, @RequestParam("description") String description,
			RedirectAttributes redirectAttributes) {
		if (!video.isEmpty()) {
			try {
				tradingResources.setVideoName(video.getOriginalFilename());
				tradingResources.setVideoFileType(video.getContentType());
				tradingResources.setVideoData(video.getBytes());
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("errorMessage", "Error saving video file");
				return "redirect:/tradingResources/allTradingResources";
			}
		}

		if (!doc.isEmpty()) {
			try {
				tradingResources.setDocumentName(doc.getOriginalFilename());
				tradingResources.setDocumentFileType(doc.getContentType());
				tradingResources.setDocumentData(doc.getBytes());
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("errorMessage", "Error saving document file");
				return "redirect:/tradingResources/allTradingResources";
			}
		}

		tradingResources.setDescription(description);
		tradingResourcesService.save(tradingResources);

		redirectAttributes.addFlashAttribute("message", "Resource saved successfully");
		return "redirect:/tradingResources/allTradingResources";
	}

	@GetMapping("/editTradingResources")
	public String editTradingResources(@RequestParam("id") int id, Model model) {
		TradingResources tradingResources = tradingResourcesService.FindById(id);
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("tradingResources", tradingResources);
		return "tradingResources/tradingResources.html";
	}

	@GetMapping("/deleteTradingResources")
	public String deleteTradingResources(@RequestParam("id") int id) {
		tradingResourcesService.DeleteById(id);
		return "redirect:/tradingResources/allTradingResources";
	}

	@GetMapping("/downloadVideo/{id}")
	@ResponseBody
	public void downloadVideo(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		TradingResources resource = tradingResourcesService.FindById(id);

		response.setContentType(resource.getVideoFileType());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + resource.getVideoName() + "\"");
		response.getOutputStream().write(resource.getVideoData());
		response.getOutputStream().flush();
	}

	@GetMapping("/downloadDocument/{id}")
	@ResponseBody
	public void downloadDocument(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		TradingResources resource = tradingResourcesService.FindById(id);

		response.setContentType(resource.getDocumentFileType());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + resource.getDocumentName() + "\"");
		response.getOutputStream().write(resource.getDocumentData());
		response.getOutputStream().flush();
	}

	@GetMapping("/displayTradingResources")
	public String displayTradingResources(Model model) {
		List<TradingResources> displayTradingResources = tradingResourcesService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("displayTradingResources", displayTradingResources);
		return "tradingResources/displayTradingResources.html";
	}

	@GetMapping("/getVideo/{id}")
	@ResponseBody
	public void getVideo(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		TradingResources resource = tradingResourcesService.FindById(id);

		response.setContentType(resource.getVideoFileType());
		response.setHeader("Content-Disposition", "inline; filename=\"" + resource.getVideoName() + "\"");
		response.getOutputStream().write(resource.getVideoData());
		response.getOutputStream().flush();
	}

	@GetMapping("/getDocument/{id}")
	@ResponseBody
	public void getDocument(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		TradingResources resource = tradingResourcesService.FindById(id);

		if (resource == null || resource.getDocumentData() == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Document not found");
			return;
		}

		response.setContentType(resource.getDocumentFileType());
		response.setHeader("Content-Disposition", "inline; filename=\"" + resource.getDocumentName() + "\"");
		response.getOutputStream().write(resource.getDocumentData());
		response.getOutputStream().flush();
	}
}
