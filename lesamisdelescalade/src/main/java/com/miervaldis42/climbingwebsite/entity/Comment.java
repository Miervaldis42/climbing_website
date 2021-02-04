package com.miervaldis42.climbingwebsite.entity;

// Imports
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.Date;


@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="site_id")
	private Site site;
	
	@Column(name="content")
	private String content;
	
	@Column(name="createdAt")
	private Date createdAt;
	
	@Column(name="updatedAt")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="modifiedLastBy")
	private User modifiedLastBy;
	
	
	/* Constructor */
	public Comment() {
		
	}


	/* Getter / setter */
	
	// id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	// user_id
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	// site_id
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}


	// Content
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	// CreatedAt
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	// updatedAt
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	// modifiedLastBy
	public User getModifiedLastBy() {
		return modifiedLastBy;
	}

	public void setModifiedLastBy(User modifiedLastBy) {
		this.modifiedLastBy = modifiedLastBy;
	}


	// ToString
	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", site=" + site + ", content=" + content + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", modifiedLastBy=" + modifiedLastBy + "]";
	}
}
