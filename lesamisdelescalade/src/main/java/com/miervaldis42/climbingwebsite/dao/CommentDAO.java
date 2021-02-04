package com.miervaldis42.climbingwebsite.dao;


// Imports
import java.util.List;

import com.miervaldis42.climbingwebsite.entity.Comment;



// DAO
public interface CommentDAO {
	
	public void saveComment(Comment newComment);

	public List<Comment> getCommentsBySite(int siteId);
	
	public void deleteComment(int id);

}
