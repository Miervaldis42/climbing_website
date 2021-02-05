package com.miervaldis42.climbingwebsite.service;

// Imports
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Comment;

// Service
public interface CommentService {
	public void saveComment(Comment newComment);

	public List<Comment> getCommentsBySite(int siteId);
	public Comment getComment(int id);
	
	public void deleteComment(int id);
}
