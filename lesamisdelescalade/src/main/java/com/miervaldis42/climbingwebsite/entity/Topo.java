package com.miervaldis42.climbingwebsite.entity;

// Imports
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;



@Entity
@Table(name="topos")
public class Topo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="owner_id")
	private User owner;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="site_id")
	private Site site;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private Status status;
	
	@Column(name="publishedDate")
	private Date publishedDate;
	
	@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="borrower_id")
	private User borrower;
	
	
	
	/* Constructor */
	public Topo() {
		
	}

	
	
	/* 
	 * Getters / Setters
	 */

	// id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	// owner
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	// site
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}


	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	// description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	// status
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}


	// publishedDate
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	
	// borrower
	public User getBorrower() {
		return borrower;
	}
	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}


	// To String
	@Override
	public String toString() {
		return "Topo [id=" + id + ", owner=" + owner + ", site=" + site + ", name=" + name + ", description="
				+ description + ", status=" + status + ", publishedDate=" + publishedDate + ", borrower=" + borrower
				+ "]";
	}
	
}
