package com.miervaldis42.climbingwebsite.enums;

// Imports
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum Difficulty {
	EASY("Facile", Arrays.asList(new String[] {"3", "3+", "4a", "4b", "4c", "5a"})),
	PERFECTIONNING("Moyenne", Arrays.asList(new String[] {"5b", "5c", "6a", "6a+"})),
	DIFFICULT("Difficile", Arrays.asList(new String[] {"6b", "6b+", "6c", "6c+"})),
	VERYDIFFICULT("Très difficile", Arrays.asList(new String[] {"7a", "7a+", "7b", "7b+", "7c", "7c+"})),
	SKYISTHELIMIT("Rien ne peut t'arrêter !", Arrays.asList(new String[] {"8a", "8a+", "8b", "8b+", "8c", "8c+", "9a", "9a+", "9b"}));

	
	// Constructor
	private String mode;
	private List<String> steps;
	
	private Difficulty(String mode, List<String> steps) {
		this.mode = mode;
		this.steps = steps;
	}
	
	
	/*
	 * Getters
	 */
	public String getMode() {
		return mode;
	}
	public List<String> getSteps() {
		return steps;
	}
	
	
	/*
	 * Utils
	 */
	
	// Get all difficulties
	public List<Difficulty> getAllDifficulties() {
		List<Difficulty> allDifficulties = Arrays.asList(Difficulty.values());
		return allDifficulties;
	}
	
	// Get all modes
	public List<String> getAllModes() {
		List<String> allModes = new ArrayList<String>();
		
		for(Difficulty difficulty : Difficulty.values()) {
			allModes.add(difficulty.mode);
		}
		
		return allModes;
	}
	
	// Get all steps
	public List<String> getEntireStepList() {		
		List<String> allStepList = Stream.of(EASY.getSteps(), PERFECTIONNING.getSteps(), DIFFICULT.getSteps(), VERYDIFFICULT.getSteps(), SKYISTHELIMIT.getSteps())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
		
		return allStepList;
	}
	
	
	
	// Get index corresponding to average quotation from the entire quotation list
	public int getAvgQuotationIndex(List<String> list) {
		List<String> stepList = getEntireStepList();
		List<Integer> indexList = new ArrayList<>();
		int sum = 0;
		int avgListIndex = 0;
		
		// Get index of elements present in all step list & the site quotations
		for(int i = 0; i < stepList.size(); i++) {			
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).equalsIgnoreCase(stepList.get(i))) {
					indexList.add(i);
				}
			}
		}
	
		// Get index of average quotation based average of indexes of site quotations 
		for(int i = 0; i < indexList.size(); i++) {
			sum += indexList.get(i);
		}
		if(indexList.size() != 0) {
			avgListIndex = (int) Math.ceil(sum / indexList.size());
		} else {
			avgListIndex = -1;	// -1 means site either has no routes & lengths, so no quotations
		}
		
		return avgListIndex;
	}
	
	// Set avg quotation attached to site index in a HashMap
	public Map<Integer, String> getQuotation(Map<Integer, List<Integer>> list) {
		List<String> stepList = getEntireStepList();
		Map<Integer, String> correspondingQuotation = new HashMap<>();
		String quotation = null;
		
		// For each element in provided list
		for(int nb : list.keySet()) {
			int quotationIndex = list.get(nb).get(0);
			
			if(quotationIndex == -1) {
				quotation = null;
			} else {
				quotation = stepList.get(quotationIndex);
			}
			
			// Set site index & avg quotation
			correspondingQuotation.put(nb, quotation);
		}

		return correspondingQuotation;
	}
	
	
	
	// Filter a list per difficulty mode
	public List<Integer> filterSitesByQuotationMode(Map<Integer, String> quotationList, String modeFilter) {
		List<String> modeSteps = Difficulty.valueOf(modeFilter).getSteps();
		List<Integer> filteredList = new ArrayList<Integer>();
		
		for(int i : quotationList.keySet()) {
			if(quotationList.get(i) != null && modeSteps.contains(quotationList.get(i))) {
				filteredList.add(i);
			}
		}
		
		return filteredList;
	}

}
