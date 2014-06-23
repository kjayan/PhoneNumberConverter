package com.challenge.coding.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Entity to hold the dictionary loaded
 * @author Jayan
 *
 */
public class Dictionary extends BaseEntity{
	
	//A map with a number as key and a Set of strings as values to store the dictionary
	private Map<String, Set<String>> words;

	public Dictionary() {
		words = new HashMap<String, Set<String>>();
	}
	
	/**
	 * Function to add a word to the dictionary
	 * @param key String indicating the number to be used as key
	 * @param word String indicating the word to be inserted for the given key
	 */
	public void addWord(String key, String word){
		Set<String> wordSet = null;
		if(words.containsKey(key)){
			wordSet = words.get(key);
			wordSet.add(word);
		}
		else{
			wordSet = new HashSet<String>();
			wordSet.add(word);
			words.put(key, wordSet);
		}
	}
	
	/**
	 * Function to return the Set of words which are mapped for the given number
	 * @param number
	 * @return
	 */
	public Set<String> getWordSetForNumber(String number){
		if(words.containsKey(number)){
			return words.get(number);
		}
		return new HashSet<String>();
	}
	
	/**
	 * Function that calculates the number of words stored in the dictionary.
	 * Used for testing purpose 
	 * @return int value indicating the number of words
	 */
	public int getTotalWords(){
		int count = 0;
		for(String key:words.keySet()){
			count += words.get(key).size();
		}
		return count;
	}

}
