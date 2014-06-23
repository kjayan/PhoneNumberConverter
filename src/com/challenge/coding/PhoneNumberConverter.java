package com.challenge.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.processor.PhoneNumberProcessor;
import com.challenge.coding.readers.DictionaryReader;
import com.challenge.coding.readers.PhoneNumberReader;
import com.challenge.coding.util.CommonUtil;

/**
 * 
 * @author Jayan
 * Main class for the converter. 
 * Takes in User inputs and delegates the work of processing and displays results
 *
 */
public class PhoneNumberConverter{

	public PhoneNumberConverter(){
		
	}

	public static void main(String[] args) {
		new PhoneNumberConverter().start(args);
	}
	
	/**
	 * Function which takes in the user input and based on that loads the dictionary and phone numbers
	 * and finally delegates the processing and displays the result
	 * @param args
	 */
	private void start(String[] args){
		Logger.INSTANCE.logInfo(Messages.EMPTY_MESSAGE);
		PhoneNumbers numbers = null;
		Dictionary dictionary = null;
		BufferedReader reader = null;
		String userChoice = "";
		PhoneNumberReader phoneNumberReader = new PhoneNumberReader();
		DictionaryReader dictionaryReader = new DictionaryReader();
		
		//Swith case depends upon number of arguments passed
		switch(args.length){
		 	
			//When all 3 parameters are given by user
			case 3: 
				
				if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
					Logger.INSTANCE.logInfo(Messages.LOADING_CUSTOM_DICTIONARY);
					dictionary = dictionaryReader.loadCustom(args[1]);
				}
				else{
					Logger.INSTANCE.logError(Messages.INPUT_NOT_PROPER);
				}
				Logger.INSTANCE.logInfo(Messages.LOADING_CUSTOM_PHONE_NUMBERS);
				numbers = phoneNumberReader.loadCustom(args[2]); 
				
				break;
			
			//When custom dictionary file is entered by user 
			case 2:
				
				if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
					Logger.INSTANCE.logInfo(Messages.LOADING_CUSTOM_DICTIONARY);
					dictionary = dictionaryReader.loadCustom(args[1]);
				}
				else{
					Logger.INSTANCE.logError(Messages.INPUT_NOT_PROPER);
				}
				
				Logger.INSTANCE.logInfo(Messages.NO_PHONE_NUMBERS_FILE);
				Logger.INSTANCE.logInfo(Messages.LOAD_SAMPLE_NUMBERS_OR_ENTER_SPECIFIC_NUMBERS);
				
				reader = new BufferedReader(new InputStreamReader(System.in));
				userChoice = CommonUtil.readLine(reader);
				userChoice = userChoice.trim();
				
				if(CommonConstants.CHOICE_ONE.equals(userChoice)){
					numbers = phoneNumberReader.loadDefault();
				}
				else if(CommonConstants.CHOICE_TWO.equals(userChoice)){
					Logger.INSTANCE.logInfo(Messages.ENTER_SPECIFIC_NUMBERS_MSG);
					numbers = phoneNumberReader.readNumbersFromConsole(reader);
				}
				CommonUtil.closeFile(reader);
				
				break;
			
			//When custom file with phone numbers is entered by user	
			case 1:
				
				Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
				dictionary = dictionaryReader.loadDefault(); 
					
				Logger.INSTANCE.logInfo(Messages.LOADING_CUSTOM_PHONE_NUMBERS);
				numbers = phoneNumberReader.loadCustom(args[0]);		
				
				break;
			
			//When no arguments are entered by user	
			case 0:
				Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
				dictionary = dictionaryReader.loadDefault(); 
				
				Logger.INSTANCE.logInfo(Messages.NO_PHONE_NUMBERS_FILE);
				Logger.INSTANCE.logInfo(Messages.LOAD_SAMPLE_NUMBERS_OR_ENTER_SPECIFIC_NUMBERS);
				reader = new BufferedReader(new InputStreamReader(System.in));
				userChoice = CommonUtil.readLine(reader);
				userChoice = userChoice.trim();
				if(CommonConstants.CHOICE_ONE.equals(userChoice)){
					numbers = phoneNumberReader.loadDefault();
				}
				else if(CommonConstants.CHOICE_TWO.equals(userChoice)){
					Logger.INSTANCE.logInfo(Messages.ENTER_SPECIFIC_NUMBERS_MSG);
					numbers = phoneNumberReader.readNumbersFromConsole(reader);
				}
				CommonUtil.closeFile(reader);
		
				break;
		}
		Logger.INSTANCE.logInfo(Messages.EMPTY_MESSAGE);
		//Call PhoneNumberProcessor.process function to convert and display the result
		PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
		processor.processAndDisplayResult(numbers);
	}
}
