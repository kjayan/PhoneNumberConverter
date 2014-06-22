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
 * Main class for the converter. Takes in User inputs and delegates the work of processing and displays results
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
	 * and finally delegates the processing
	 * @param args
	 */
	private void start(String[] args){
		
		PhoneNumbers numbers = null;
		Dictionary dictionary = null;
		BufferedReader reader = null;
		String userChoice = "";
		PhoneNumberReader phoneNumberReader = new PhoneNumberReader();
		DictionaryReader dictionaryReader = new DictionaryReader();
		
		switch(args.length){
			case 3:
				
				if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
					dictionary = dictionaryReader.loadCustomDictionary(args[1]);
				}
				else{
					Logger.INSTANCE.logError(Messages.INPUT_NOT_PROPER);
				}
				
				numbers = phoneNumberReader.readNumbersFromFile(args[2]); 
				
				break;
				
			case 2:
				
				if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
					dictionary = dictionaryReader.loadCustomDictionary(args[1]);
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
					numbers = phoneNumberReader.loadSamplePhoneNumbers();
				}
				else if(CommonConstants.CHOICE_TWO.equals(userChoice)){
					Logger.INSTANCE.logInfo(Messages.ENTER_SPECIFIC_NUMBERS_MSG);
					numbers = phoneNumberReader.readNumbersFromConsole(reader);
				}
				CommonUtil.closeFile(reader);
				
				break;
				
			case 1:
				
				Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
				dictionary = dictionaryReader.loadDefaultDictionary(); 
					
				Logger.INSTANCE.logInfo(Messages.LOADING_CUSTOM_PHONE_NUMBERS);
				numbers = phoneNumberReader.readNumbersFromFile(args[0]);		
				
				break;
				
			case 0:
				Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
				dictionary = dictionaryReader.loadDefaultDictionary(); 
				
				Logger.INSTANCE.logInfo(Messages.NO_PHONE_NUMBERS_FILE);
				Logger.INSTANCE.logInfo(Messages.LOAD_SAMPLE_NUMBERS_OR_ENTER_SPECIFIC_NUMBERS);
				reader = new BufferedReader(new InputStreamReader(System.in));
				userChoice = CommonUtil.readLine(reader);
				userChoice = userChoice.trim();
				if(CommonConstants.CHOICE_ONE.equals(userChoice)){
					numbers = phoneNumberReader.loadSamplePhoneNumbers();
				}
				else if(CommonConstants.CHOICE_TWO.equals(userChoice)){
					Logger.INSTANCE.logInfo(Messages.ENTER_SPECIFIC_NUMBERS_MSG);
					numbers = phoneNumberReader.readNumbersFromConsole(reader);
				}
				CommonUtil.closeFile(reader);
		
				break;
		}
		
		PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
		processor.processAndDisplayResult(numbers);
	}
}
