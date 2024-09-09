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

import com.bannershallmark.entity.TradeComment;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.MyUserDetails;
import com.bannershallmark.service.TradeCommentService;

@Controller
@RequestMapping("/comment")
public class TradeCommentController {

	@Autowired
	private TradeCommentService tradeCommentService;

	@GetMapping("/addTradeComment")
	public String addTradeComment(Model model) {
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		return "tradeComment/addTradeComment.html";
	}

	@GetMapping("/tradeCommentList")
	public String TradeCommentList(Model model) {
		
		List<TradeComment> tradeComments = tradeCommentService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		if(role== 2) {
			tradeComments = tradeCommentService.FindByUser(users);
		}
		model.addAttribute("role", role);
		model.addAttribute("tradeComments", tradeComments);
		return "tradeComment/tradeCommentList.html";
	}

	@PostMapping("/saveTradeComment")
	public String saveTradeComment(TradeComment tradeComment) {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
//		int role = users.getRole().getId();
		tradeComment.setUserId(users);
		tradeCommentService.save(tradeComment);
		return "redirect:/comment/tradeCommentList";
	}

	@GetMapping("/editTradeComment")
	public String editTradeComment(@RequestParam("id") int id, Model model) {
		TradeComment tradeComment = tradeCommentService.FindById(id);
	////to Access user role////////////////
			MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users users = user.getUser();
			int role = users.getRole().getId();
			model.addAttribute("role", role);
	///////////////////////		end//////////
		model.addAttribute("tradeComment", tradeComment);
		return "tradeComment/addTradeComment.html";
	}

	@PostMapping("/deleteTradeComment")
	public String deleteTradeComment(@RequestParam("id") int id) {
		tradeCommentService.DeleteById(id);
		return "redirect:/comment/tradeCommentList";
	}

	@GetMapping("/displayTradeComment")
	public String displayTradeComment(Model model) {
		List<TradeComment> tradeComments = tradeCommentService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("tradeComments", tradeComments);
		return "tradeComment/displayTradeComment.html";
	}

}
