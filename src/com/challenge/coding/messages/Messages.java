package com.challenge.coding.messages;

public class Messages {

	private Messages() {

	}
	
	public static final String INVALID_DICTIONARY = "Dictionary supplied is not valid.Enter a valid dictionary.";
	
	public static final String DEFAULT_DICTIONARY_NOT_FOUND = "Default dictionary is not valid.Please make sure default dictionary is present.";
	
	public static final String EMPTY_DICTIONARY_PATH = "The path for custom dictionary is not supplied. \n "
												+"For loading default dictionary try running again by avoiding -d parameter.";
		
	public static final String LOADING_DEFAULT_DICTIONARY = "No custom dictionary entered. Loading default dictionary.";
	
	public static final String BUFFERED_READER_CLOSE_FAILED = "BufferedReader close failed";
	
	public static final String INVALID_WORD_IN_DICTIONARY = "Invalid words present in dictionary.Please rectify and retry";
}
