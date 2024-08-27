package com.bannershallmark.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bannershallmark.entity.MarketInsight;
import com.bannershallmark.entity.MarketInsightFile;
import com.bannershallmark.service.MarketInsightFileService;
import com.bannershallmark.service.MarketInsightService;

@Controller
@RequestMapping("/marketInsight")
public class MarketInsightController {
	@Autowired
	private MarketInsightService marketInsightService;
	@Autowired
	private MarketInsightFileService marketInsightFileService;

	public MarketInsightFile fileId;

	@GetMapping("/allMarketInsight")
	public String allMarketInsight(Model model) {
		List<MarketInsight> marketInsights = marketInsightService.FindAll();
		model.addAttribute("marketInsights", marketInsights);
		return "marketInsight/allMarketInsight.html";
	}

	@GetMapping("/addMarketInsight")
	public String addCategory() {
		return "marketInsight/marketInsight.html";
	}

	@PostMapping("/saveMarketInsight")
	public String saveMarketInsight(MarketInsight marketInsight, @RequestParam("file") MultipartFile file)
			throws IOException {
		if (file.isEmpty()) {
			if (fileId != null) {
				marketInsight.setMarketInsightFileID(fileId);
			}
		} else

		{
			byte[] bytes = file.getBytes();
			MarketInsightFile file2 = new MarketInsightFile();
			file2.setFileName(file.getOriginalFilename());
			file2.setData(bytes);
			file2.setFileType(file.getContentType());
			marketInsight.setMarketInsightFileID(file2);
			marketInsightFileService.Save(file2);

		}

		marketInsightService.save(marketInsight);
		return "redirect:/marketInsight/allMarketInsight";
	}

	@GetMapping("/editMarketInsight")
	public String editMarketInsight(@RequestParam("id") int id, Model model) {
		MarketInsight marketInsight = marketInsightService.FindById(id);
		fileId = marketInsight.getMarketInsightFileID();
		model.addAttribute("marketInsight", marketInsight);
		return "marketInsight/marketInsight.html";
	}

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
}
