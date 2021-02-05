package com.miervaldis42.climbingwebsite.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

//Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miervaldis42.climbingwebsite.entity.Comment;
import com.miervaldis42.climbingwebsite.entity.Site;
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.service.CommentService;
import com.miervaldis42.climbingwebsite.service.SiteService;
import com.miervaldis42.climbingwebsite.service.UserService;


@Controller
public class CommentController {
	@Autowired
	private SiteService siteService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	
	
	/*
	 * Add comment
	 */
	@PostMapping("/addComment")
	public String addComment(HttpSession activeSession, @RequestParam("siteId") String siteId, @RequestParam("content") String userComment) {
		// Connected user
		int userId = (int) activeSession.getAttribute("id");
		User connectedUser = userService.getUser(userId);
		
		
		// Site linked to the comment
		int id = Integer.parseInt(siteId);
		Site commentSite = siteService.getSite(id);

		// New comment to save
		Comment newComment = new Comment();
		newComment.setUser(connectedUser);
		newComment.setSite(commentSite);
		newComment.setContent(userComment);
		newComment.setCreatedAt(new Date());
		
		commentService.saveComment(newComment);

		return "redirect:/details?siteId="+id;
	}
	
	
	
	/*
	 * Edit comment
	 */
	@PostMapping("/editComment")
	public String editComment(@RequestParam("commentId") int id, @RequestParam("siteId") int siteId, @RequestParam("userId") int userId, @RequestParam("modifiedComment") String newContent) {
		
		Comment alteredComment = commentService.getComment(id);
		alteredComment.setContent(newContent);
		alteredComment.setUpdatedAt(new Date());
		
		User cigaretteSmokingMan = userService.getUser(userId);
		alteredComment.setModifiedLastBy(cigaretteSmokingMan);
		
		commentService.saveComment(alteredComment);		
		
		return "redirect:/details?siteId="+siteId;
		
	}
	
	
	/*
	 * Delete comment
	 */
	@GetMapping("/deleteComment")
	public String deleteComment(@RequestParam("commentId") int id, @RequestParam("siteId") int siteId) {
		commentService.deleteComment(id);
		
		return "redirect:/details?siteId="+siteId;
	}
}
