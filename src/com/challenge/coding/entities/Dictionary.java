package com.challenge.coding.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary extends BaseEntity{
	
	private Map<String, Set<String>> words;

	public Dictionary() {
		words = new HashMap<String, Set<String>>();
	}
	
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

}
