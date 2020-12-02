package com.miervaldis42.climbingwebsite.entity;

public enum Difficulty {
	EASY("Facile", new String[] {"3", "3+", "4a", "4b", "4c", "5a"}),
	PERFECTIONNING("Moyenne", new String[] {"5b", "5c", "6a", "6a+"}),
	DIFFICULT("Difficile", new String[] {"6b", "6b+", "6c", "6c+"}),
	VERYDIFFICULT("Très difficile", new String[] {"7a", "7a+", "7b", "7b+", "7c", "7c+"}),
	SKYISTHELIMIT("Rien ne peut t'arrêter !", new String[] {"8a", "8a+", "8b", "8b+", "8c", "8c+", "9a", "9a+", "9b"});

	private String mode;
	private String[] stages;
	
	// Constructor
	private Difficulty(String mode, String[] stages) {
		this.mode = mode;
		this.stages = stages;
	}
	
	/*
	 * Getters & Setters
	 */
	public String getMode() {
		return mode;
	}
	public String[] getSteps() {
		return stages;
	}
	
}
