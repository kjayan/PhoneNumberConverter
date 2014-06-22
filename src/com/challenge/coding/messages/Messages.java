package com.challenge.coding.messages;

public class Messages {

	private Messages() {

	}
		
	public static final String INPUT_NOT_PROPER = "Input is not in proper format";
	
	public static final String INVALID_DICTIONARY = "Dictionary supplied is not valid.Enter a valid dictionary.";
	
	public static final String DEFAULT_DICTIONARY_NOT_FOUND = "Default dictionary is not valid.Please make sure default dictionary is present.";
	
	public static final String DEFAULT_PHONE_NUMBERS_NOT_FOUND = "Default phone numbers file is not valid.Please make sure default phone numbers file is present.";
	
	public static final String EMPTY_DICTIONARY_PATH = "The path for custom dictionary is not supplied. \n "
												+"For loading default dictionary try running again by avoiding -d parameter.";
		
	public static final String LOADING_DEFAULT_DICTIONARY = "No custom dictionary entered. Loading default dictionary.";
	
	public static final String LOADING_CUSTOM_PHONE_NUMBERS = "Loading custom phone numbers file.";
	
	public static final String NO_PHONE_NUMBERS_FILE = "No custom file with phone numbers entered.";
	
	public static final String LOAD_SAMPLE_NUMBERS_OR_ENTER_SPECIFIC_NUMBERS = "Press 1 to load some sample phone numbers\nPress 2 to enter specific numbers";
	
	public static final String ENTER_SPECIFIC_NUMBERS_MSG = "Enter the numbers one by one, each separated by new line.\nType $ to indicate the end of input & start processing.";
	
	public static final String BUFFERED_READER_CLOSE_FAILED = "BufferedReader close failed";
	
	public static final String INVALID_WORD_IN_DICTIONARY = "Invalid words present in dictionary.Please rectify and retry";
	
	public static final String INVALID_NUMBER_IN_PHONE_NUMBER = "Invalid numbers present in phone number file.Please rectify and retry";
	
	public static final String EMPTY_MESSAGE = "";
	
	public static final String FOR_PHONE_NUMBER = "For Phone Number ";
	
	public static final String NO_POSSIBLE_WORD_CONVERSIONS = ", there are no possible word conversions.";
	
	public static final String POSSIBLE_WORD_CONVERSIONS = ", possible word conversions are:";
}
