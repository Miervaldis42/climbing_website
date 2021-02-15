package com.miervaldis42.climbingwebsite.service;

// Imports
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.miervaldis42.climbingwebsite.dao.CommentDAO;
import com.miervaldis42.climbingwebsite.entity.Comment;


@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;

	@Override
	@Transactional
	public void saveComment(Comment newComment) {
		commentDAO.saveComment(newComment);
	}

	@Override
	@Transactional
	public List<Comment> getCommentsBySite(int siteId) {
		return commentDAO.getCommentsBySite(siteId);
	}
	
	@Override
	@Transactional
	public List<Comment> getCommentsByUser(int userId) {
		return commentDAO.getCommentsBySite(userId);
	}
	
	@Override
	@Transactional
	public Comment getComment(int id) {
		return commentDAO.getComment(id);
	}
	

	@Override
	@Transactional
	public void deleteComment(int id) {
		commentDAO.deleteComment(id);
	}

}