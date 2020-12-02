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


@Entity
@Table(name="routes")
public class Route {
	
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="sector_id")
	private Sector sector;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="site_id")
	private Site site;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quotation")
	private String quotation;

	
	/*
	 * Constructor
	 */
	public Route() { }
	
	
	/*
	 * Getters & Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getQuotation() {
		return quotation;
	}
	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}

	
	@Override
	public String toString() {
		return "Route [id=" + id + ", site=" + site + ", name=" + name + ", quotation=" + quotation + "]";
	}
	
}