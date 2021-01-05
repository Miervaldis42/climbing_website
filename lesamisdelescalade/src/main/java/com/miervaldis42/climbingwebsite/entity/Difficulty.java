package com.miervaldis42.climbingwebsite.entity;

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

	private String mode;
	private List<String> stages;
	
	// Constructor
	private Difficulty(String mode, List<String> stages) {
		this.mode = mode;
		this.stages = stages;
	}
	
	
	/*
	 * Getters & Setters
	 */
	public String getMode() {
		return mode;
	}
	public List<String> getSteps() {
		return stages;
	}
	
	
	/*
	 * Utils
	 */
	
	// Get all modes
	public List<Difficulty> getAllModes() {
		List<Difficulty> allModes = Arrays.asList(Difficulty.values());
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
		for (int i = 0; i < list.size(); i++) {
			if(list.contains(stepList.get(i))) {
				indexList.add(i);
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
	
	public Map<Integer, String> getQuotation(Map<Integer, List<Integer>> list) {
		Map<Integer, String> correspondingQuotation = new HashMap<>();
		List<String> stepList = getEntireStepList();
		String quotation = null;
		
		for(int i = 0; i < list.size(); i++) {
			int quotationIndex = list.get(i+1).get(0);
			
			if(quotationIndex == -1) {
				quotation = null;
			} else {
				quotation = stepList.get(quotationIndex);
			}
			correspondingQuotation.put(i+1, quotation);
		}

		return correspondingQuotation;
	}
	
}
