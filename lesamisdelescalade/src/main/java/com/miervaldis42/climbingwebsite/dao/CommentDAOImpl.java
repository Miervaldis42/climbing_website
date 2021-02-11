package com.miervaldis42.climbingwebsite.dao;

// Imports
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.miervaldis42.climbingwebsite.entity.Comment;



@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveComment(Comment newComment) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(newComment);
	}

	
	@Override
	public List<Comment> getCommentsBySite(int siteId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Comment> siteCommentsQuery = currentSession.createQuery("FROM Comment WHERE site_id=:id", Comment.class);
		siteCommentsQuery.setParameter("id", siteId);
		
		List<Comment> allSiteComments = null;
		
        if(!siteCommentsQuery.getResultList().isEmpty()) {
        	allSiteComments = siteCommentsQuery.getResultList();
        }
		
		return allSiteComments;
	}
	
	@Override
	public Comment getComment(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Comment selectedComment = currentSession.get(Comment.class, id);

		return selectedComment;
	}

	
	@Override
	public void deleteComment(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query selectedComment = currentSession.createQuery("DELETE FROM Comment WHERE id=:commentId");
		selectedComment.setParameter("commentId", id);

		selectedComment.executeUpdate();
	}

}
