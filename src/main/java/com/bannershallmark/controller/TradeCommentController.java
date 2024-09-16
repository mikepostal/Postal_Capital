package com.bannershallmark.controller;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bannershallmark.entity.CommentReplay;
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
		//// to Access user role////////////////
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		/////////////////////// end//////////
		return "tradeComment/addTradeComment.html";
	}

	@GetMapping("/tradeCommentList")
	public String TradeCommentList(Model model) {

		List<TradeComment> tradeComments = tradeCommentService.FindAll();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		if (role == 2) {
			tradeComments = tradeCommentService.FindByUser(users);
		}
		tradeComments.sort(Comparator.comparing(TradeComment::getDate));
		model.addAttribute("role", role);
		model.addAttribute("tradeComments", tradeComments);
		return "tradeComment/tradeCommentList.html";
	}

	@PostMapping("/saveTradeComment")
	public String saveTradeComment(TradeComment tradeComment) {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
//		int role = users.getRole().getId();
		tradeComment.setDate(new Date(System.currentTimeMillis()));
		tradeComment.setUser(users);
		tradeCommentService.save(tradeComment);
		return "redirect:/comment/tradeCommentList";
	}

	@GetMapping("/editTradeComment")
	public String editTradeComment(@RequestParam("id") int id, Model model) {
		TradeComment tradeComment = tradeCommentService.FindById(id);
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		model.addAttribute("role", role);
		model.addAttribute("tradeComment", tradeComment);
		return "tradeComment/addTradeComment.html";
	}

	@GetMapping("/deleteTradeComment")
	public String deleteTradeComment(@RequestParam("id") int id) {
		TradeComment comment = tradeCommentService.FindById(id); 

		if (comment != null) {
			Users user = comment.getUser();

			if (user != null) {
				user.getTradeComments().remove(comment);
			}

			tradeCommentService.DeleteById(id);
		}

		return "redirect:/comment/tradeCommentList";
	}

	@GetMapping("/displayTradeComment")
	public String displayTradeComment( @RequestParam(value = "id",required = false ) Integer commentId,Model model) {
//		List<TradeComment> tradeComments2 = tradeCommentService.FindAll();
		List<TradeComment> tradeComments = tradeCommentService.findAllWithReplays();
		List<CommentReplay> commentReplays = tradeCommentService.FindAllCommentReplaies();
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		int role = users.getRole().getId();
		if(role == 2) {
			tradeComments = tradeCommentService.findBydUserWithReplays(users);
		}
		if(commentId != null) {
			tradeComments = tradeCommentService.findBydIdWithReplays(commentId);
		}
		tradeComments.sort(Comparator.comparing(TradeComment::getDate).reversed());
		model.addAttribute("users", users);
		model.addAttribute("role", role);
		model.addAttribute("tradeComments", tradeComments);
		model.addAttribute("commentReplays", commentReplays);
		return "tradeComment/displayTradeComment.html";
	}

	@PostMapping("/saveReplayMessage")
	public String saveReplayMessage(CommentReplay commentReplay, @RequestParam("commentId") int commentId) {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users users = user.getUser();
		commentReplay.setDate(new Date(System.currentTimeMillis()));
		commentReplay.setUser(users);
		commentReplay.setTradeComment(tradeCommentService.FindById(commentId));
		tradeCommentService.saveReplayMessage(commentReplay);
		return "redirect:/comment/displayTradeComment";
	}

}
