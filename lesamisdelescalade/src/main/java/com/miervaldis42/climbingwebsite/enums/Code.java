package com.miervaldis42.climbingwebsite.enums;

// Imports
import java.util.Arrays;
import java.util.List;



public enum Code {
	
	/* Auth - Email */
	EMAIL_EXISTING(false, "Cet adresse email est déjà relié à un compte !"),
	EMAIL_INVALID(false, "Le format de l'adresse email est incorrect..."),
	
	/* Auth - Users */
	USER_CREATED(true, "Bienvenue parmi nous ! ^^"),
	USER_NOTFOUND(false, "L'adresse email ou/et le mot de passe sont incorrects..."),
	
	
	/* Topos */
	TOPO_BOOKED(true, "Une demande de réservation a été envoyée au propriétaire du topo."),
	
	
	/* Forms */
	FORM_EMPTYINPUT(false, "L'un des champs est vide...");
	
	
	
	// Constructor
	private Boolean status;
	private String msg;

	private Code(Boolean status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	

	/*
	 * Getters
	 */
	public Boolean getStatus() {
		return status;
	}
	
	public String getMsg() {
		return msg;
	}
	

	/*
	 * Utils
	 */
	// Get all codes for toasts
	public List<Code> getAllCodes() {
		List<Code> allCodes = Arrays.asList(Code.values());
		return allCodes;
	}

}
