package com.miervaldis42.climbingwebsite.entity;

// Imports
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;


@Entity
@Table(name="sites")
public class Site {
	
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="location")
	private String location;
	
	@Column(name="tag")
	private Boolean tag;
	
	
	@OneToMany(mappedBy="site", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Sector> sectors;	
	
	
	/*
	 * Constructor
	 */
	public Site() {	}
	
	
	/*
	 * Getters & Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Boolean getTag() {
		return tag;
	}
	public void setTag(Boolean tag) {
		this.tag = tag;
	}
	
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	
	
	/*
	 * Methods
	 */
	public void addSector(Sector newSector) {
		if(sectors == null) {
			sectors = new ArrayList<>();
		}
		
		sectors.add(newSector);
		newSector.setSite(this);
	}


	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", tag=" + tag + "]";
	}
	
}
