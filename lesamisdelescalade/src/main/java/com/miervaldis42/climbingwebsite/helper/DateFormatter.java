package com.miervaldis42.climbingwebsite.helper;

// Imports
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// Entities
import com.miervaldis42.climbingwebsite.entity.User;
import com.miervaldis42.climbingwebsite.entity.Comment;
import com.miervaldis42.climbingwebsite.entity.Topo;



public class DateFormatter {
	private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy à HH:mm");


	// User dates _(creation & update)_
	public Map<Integer, String> formatUserDate(List<User> users, Boolean creationDate) {
		Map<Integer, String> userDates = new HashMap<Integer, String>();
		
		if(creationDate == true) {
			for(User u : users) {
				userDates.put(u.getId(), formatter.format(u.getCreatedAt()));
			}
		} else {
			for(User u : users) {
				if(u.getUpdatedAt() != null) {
					userDates.put(u.getId(), formatter.format(u.getUpdatedAt()));
				}
			}
		}
		
		return userDates;	
	}
	
	
	// Comment dates _(creation & update)_
	public Map<Integer, String> formatDate(List<Comment> comments, Boolean creationDate) {		
		Map<Integer, String> commentDates = new HashMap<Integer, String>();
		
		if(creationDate == true) {
			for(Comment c : comments) {
				commentDates.put(c.getId(), formatter.format(c.getCreatedAt()));
			}
		} else {
			for(Comment c : comments) {
				if(c.getUpdatedAt() != null) {
					commentDates.put(c.getId(), formatter.format(c.getUpdatedAt()));
				}
			}
		}
		
		return commentDates;
	}
	
	
	// Topo date _(published)_
	public Map<Integer, String> formatDate(List<Topo> topos) {
		Map<Integer, String> topoDates = new HashMap<Integer, String>();

		for(Topo t : topos) {
			topoDates.put(t.getId(), formatter.format(t.getPublishedDate()));
		}
		
		return topoDates;	
	}

}
