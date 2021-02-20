package com.miervaldis42.climbingwebsite.enums;

public enum Status {
	AVAILABLE("Disponible"),
	PENDING("En cours d'étude"),
	LENT("Prêté");
	
	
	// Display role name
	private String statusName;
	
	// Constructor
	Status (String statusName) {
		this.statusName = statusName;
	}

	// Method
	public String getStatusName() {
		return statusName;
	}
}