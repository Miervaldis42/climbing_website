package com.miervaldis42.climbingwebsite.enums;

public enum Role {
	ADMIN("Admin"),
	MEMBER("Membre"),
	SUBSCRIBER("Abonné(e)");
	
	
	// Display role name
	private String roleName;
	
	// Constructor
	Role (String roleName) {
		this.roleName = roleName;
	}

	// Method
	public String getRoleName() {
		return roleName;
	}
}