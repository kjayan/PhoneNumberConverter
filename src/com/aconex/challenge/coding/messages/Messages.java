package com.aconex.challenge.coding.messages;

public class Messages {

	private Messages() {

	}
	
	public static final String ENTER_A_DICTIONARY = "Dictionary supplied is not valid.Enter a valid dictionary.";
	
	public static final String EMPTY_DICTIONARY_PATH = "The path for custom dictionary is not supplied. \n "
												+"For loading default dictionary try running again by avoiding -d parameter.";
		
	public static final String LOADING_DEFAULT_DICTIONARY = "No custom dictionary entered. Loading default dictionary.";
}
