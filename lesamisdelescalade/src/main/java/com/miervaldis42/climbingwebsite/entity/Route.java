package com.miervaldis42.climbingwebsite.entity;

// Imports
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.*;


@Entity
@Table(name="routes")
public class Route {
	
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="sector_id")
	private Sector sector;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quotation")
	private String quotation;
	
	@OneToMany(mappedBy="route", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Length> lengths; 

	
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
	
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<Length> getLengths() {
		return lengths;
	}
	public void setLengths(List<Length> lengths) {
		this.lengths = lengths;
	}


	/*
	 * Methods
	 */
	public void addLength(Length newLength) {
		if(lengths == null) {
			lengths = new ArrayList<>();
		}
		
		lengths.add(newLength);
		newLength.setRoute(this);
	}
	
	
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", name=" + name + ", quotation=" + quotation + "]";
	}
	
}