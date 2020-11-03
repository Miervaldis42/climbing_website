package com.miervaldis42.climbingwebsite.helper;

public class ErrorHandler {
	String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	// Email validator
	public Boolean checkEmail(String email) {
		Boolean validate = email.matches(regex);
		
		return validate;
	}
	
	
	// Error message
	public String displayErrorMessage(String errorCode) {
		String messageToDisplay = "";
		
		switch(errorCode) {
			case "201 - User created":
				messageToDisplay = "Bienvenue parmi nous ! ^^";
				break;

			case "400 - Empty input":
				messageToDisplay = "L'un des champs est vide...";
				break;
			case "400 - Invalid email":
				messageToDisplay = "Le format de l'adresse email est incorrect...";
				break;
				
			default:
				break;
		}
		
		return messageToDisplay;		
	}
	
}
