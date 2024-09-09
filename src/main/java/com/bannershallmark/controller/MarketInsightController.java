package com.bannershallmark.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.bannershallmark.entity.MarketInsight;
import com.bannershallmark.entity.MarketInsightDescription;
import com.bannershallmark.entity.MarketInsightFile;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.MarketInsightDescriptionService;
import com.bannershallmark.service.MarketInsightFileService;
import com.bannershallmark.service.MarketInsightService;
import com.bannershallmark.service.MyUserDetails;

@Controller
@RequestMapping("/marketInsight")
public class MarketInsightController {
	@Autowired
	private MarketInsightService marketInsightService;
	@Autowired
	private MarketInsightFileService marketInsightFileService;
	@Autowired
	private MarketInsightDescriptionService marketInsightDescriptionService;

	@GetMapping("/allMarketInsight")
	public String allMarketInsight(Model model) {
		List<MarketInsight> marketInsights = marketInsightService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("marketInsights", marketInsights);
		return "marketInsight/allMarketInsight.html";
	}
	

	@GetMapping("/marketInsightList")
	public String marketInsightList(@RequestParam(value = "id",required = false) Integer id, Model model) {
		
		if(id != null) {
			MarketInsight marketInsight = marketInsightService.FindById(id);
			model.addAttribute("marketInsightList", marketInsight);
		}else {
			List<MarketInsight> marketInsightList = marketInsightService.FindAll();
			model.addAttribute("marketInsightList", marketInsightList);
		}
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		
		return "marketInsight/marketInsightList.html";
	}

	@GetMapping("/addMarketInsight")
	public String addCategory(Model model) {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		return "marketInsight/marketInsight.html";
	}

	@PostMapping("/saveMarketInsight")
	public String saveMarketInsight(@ModelAttribute MarketInsight marketInsight,
			@RequestParam("files") MultipartFile[] files,
			@RequestParam("marketInsightDetail") List<String> descriptions) throws IOException {

		System.out.println("descriptions.size()======================= " + descriptions.size());

		List<MarketInsightDescription> descriptionList = new ArrayList<>();

		// Check if there is only one file
		boolean isSingleFile = files.length == 1;

		// If only one file is present, concatenate all descriptions into one
		if (isSingleFile) {
			if (descriptions.size() > 0) {
				// Concatenate all descriptions into one
				String concatenatedDescriptions = String.join(" ", descriptions);

				MarketInsightDescription marketInsightDescription = new MarketInsightDescription();
				marketInsightDescription.setMarketInsightDetail(concatenatedDescriptions);
				marketInsightDescription.setMarketInsightID(marketInsight);

				MultipartFile file = files[0];
				if (file != null && !file.isEmpty()) {
					byte[] bytes = file.getBytes();
					MarketInsightFile marketInsightFile = new MarketInsightFile();
					marketInsightFile.setFileName(file.getOriginalFilename());
					marketInsightFile.setData(bytes);
					marketInsightFile.setFileType(file.getContentType());
					marketInsightFile.setMiDescID(marketInsightDescription);

					marketInsightDescription.getMarketInsightFileList().add(marketInsightFile);
				}

				descriptionList.add(marketInsightDescription);
			}
		} else {
			// Process each description separately if there are multiple files
			for (int i = 0; i < descriptions.size(); i++) {
				String descriptionText = descriptions.get(i);

				MarketInsightDescription marketInsightDescription = new MarketInsightDescription();
				marketInsightDescription.setMarketInsightDetail(descriptionText);
				marketInsightDescription.setMarketInsightID(marketInsight);

				if (i < files.length) {
					MultipartFile file = files[i];
					if (file != null && !file.isEmpty()) {
						byte[] bytes = file.getBytes();
						MarketInsightFile marketInsightFile = new MarketInsightFile();
						marketInsightFile.setFileName(file.getOriginalFilename());
						marketInsightFile.setData(bytes);
						marketInsightFile.setFileType(file.getContentType());
						marketInsightFile.setMiDescID(marketInsightDescription);

						marketInsightDescription.getMarketInsightFileList().add(marketInsightFile);
					}
				}

				descriptionList.add(marketInsightDescription);
			}
		}

		marketInsight.setMarketInsightDescriptionList(descriptionList);
		marketInsightService.save(marketInsight);

		return "redirect:/marketInsight/allMarketInsight";
	}

//	@GetMapping("/editMarketInsight")
//	public String editMarketInsight(@RequestParam("id") int id, Model model) {
//		MarketInsight marketInsight = marketInsightService.FindById(id);
//		model.addAttribute("marketInsight", marketInsight);
//		return "marketInsight/marketInsight.html";
//	}

	@GetMapping("/deleteMarketInsight")
	public String deleteMarketInsight(@RequestParam("id") int id) {
		marketInsightService.DeleteById(id);
		return "redirect:/marketInsight/allMarketInsight";
	}

	@GetMapping("/download/{documentId}")
	public ResponseEntity<byte[]> downloadDocument(@PathVariable int documentId) {
		// Retrieve the document from the database
		MarketInsightFile document = marketInsightFileService.FindById(documentId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", document.getFileName());
		headers.setContentLength(document.getData().length);
		return new ResponseEntity<>(document.getData(), headers, HttpStatus.OK);

	}

	@GetMapping("/pictures/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable int id) {
		MarketInsightFile file = marketInsightFileService.FindById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(file.getData().length);
		return new ResponseEntity<>(file.getData(), headers, HttpStatus.OK);
	}

}
