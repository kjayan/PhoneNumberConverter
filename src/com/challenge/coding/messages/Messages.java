package com.challenge.coding.messages;

/**
 * Class which stores all the messages which are logged. 
 * Can be extended later to support multiple languages by adding a factory class on top
 * @author Jayan
 *
 */
public class Messages {

	private Messages() {

	}
	
	/** When Input is not in proper format **/
	public static final String INPUT_NOT_PROPER = "Input is not in proper format";
	
	/** When the supplied dictionary file is not found **/
	public static final String INVALID_DICTIONARY = "Dictionary supplied is not valid.Enter a valid dictionary.";
	
	/** When the default dictionary is not found under /data/dictionary folder**/
	public static final String DEFAULT_DICTIONARY_NOT_FOUND = "Default dictionary is not valid.Please make sure default dictionary is present.";
	
	/** When the default phone numbers are not found under /data/phonenumber**/
	public static final String DEFAULT_PHONE_NUMBERS_NOT_FOUND = "Default phone numbers file is not valid.Please make sure default phone numbers file is present.";
	
	/** When -d option is given and dictionary path is empty**/
	public static final String EMPTY_DICTIONARY_PATH = "The path for custom dictionary is not supplied. \n "
												+"For loading default dictionary try running again by avoiding -d parameter.";
	
	/** When loading default dictionary**/	
	public static final String LOADING_DEFAULT_DICTIONARY = "No custom dictionary entered. Loading default dictionary.";
	
	/** When loading phone numbers from custom file**/
	public static final String LOADING_CUSTOM_PHONE_NUMBERS = "Loading custom phone numbers file.";
	
	/** When no custom file with phone numbers are entered**/
	public static final String NO_PHONE_NUMBERS_FILE = "No custom file with phone numbers entered.";
	
	/** Asking the user an option to choose between loading default numbers or enter specific numbers**/
	public static final String LOAD_SAMPLE_NUMBERS_OR_ENTER_SPECIFIC_NUMBERS = "Press 1 to load some sample phone numbers\nPress 2 to enter specific numbers";
	
	/** Instructions to the user about entering numbers**/
	public static final String ENTER_SPECIFIC_NUMBERS_MSG = "Enter the numbers one by one, each separated by new line.\nType '$exit' as the last word to indicate the end of input & start processing.";
	
	/** Error message when closing of reader fails**/
	public static final String BUFFERED_READER_CLOSE_FAILED = "BufferedReader close failed";
	
	/** Error message when some invalid entries are present in the dictionary**/
	public static final String INVALID_WORD_IN_DICTIONARY = "Invalid words present in dictionary.Please rectify and retry";
	
	/** Error message when some invalid numbers are present in phone number file**/
	public static final String INVALID_NUMBER_IN_PHONE_NUMBER = "Invalid numbers present in phone number file.Please rectify and retry";
	
	/** Empty message**/
	public static final String EMPTY_MESSAGE = "";
	
	/** Prefix string used to display results **/
	public static final String FOR_PHONE_NUMBER = "For Phone Number ";
	
	/** Suffix string used to display negative results**/
	public static final String NO_POSSIBLE_WORD_CONVERSIONS = ", there are no possible word conversions.";
	
	/** Suffix string used to display positive results**/
	public static final String POSSIBLE_WORD_CONVERSIONS = ", possible word conversions are:";
}
