package com.challenge.coding.processor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;

public class PhoneNumberProcessor {
	
	Dictionary dictionary;

	public PhoneNumberProcessor(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	/**
	 * Function which takes in the list of phone numbers and prints results for each number
	 * @param phoneNumbers An instance  of {@link PhoneNumbers} containing all phone numbers to be converted
	 */
	public void processAndDisplayResult(PhoneNumbers phoneNumbers){
		List<String> result = null;
		for(String number:phoneNumbers.getNumbers()){
			result = convertNumberToWord(number);
			displayResult(number,result);
		}
	}
	
	/**
	 * Function to process a phone number and return the result
	 * Used in places where only results are needed for a single number and no need to display the results
	 * @param number {@link List} of {@link String} containing the results
	 * @return
	 */
	public List<String> process(String number){
		return convertNumberToWord(number);
	}
	
	/**
	 * Function that generates the possible word conversions for the given number
	 * @param number String containing the number to be converted
	 * @return {@link List} of {@link String} containing the results
	 */
	private List<String> convertNumberToWord(String number){
		
		String cleanedNumber = cleanUpNumber(number);
		List<String> result = new ArrayList<String>();
		List<String> subResult = null;
        Set<String> wordSet;
       
        String tempString = "";
        String remainingString = "";
        String resultString = "";
        String appender = "";
        
        for(int start = 0;start < cleanedNumber.length()-1;start++){
        	
        	wordSet = null;
        	tempString = "";
            remainingString = "";
            resultString = "";
        	
        	if(start == 1){
        		appender = String.valueOf(cleanedNumber.charAt(0)) + CommonConstants.HYPHEN;
        	}
        	//To prevent 2 consecutive digits from non-conversion
        	else if(start > 1){
        		break;
        	}
        	else{
        		appender = CommonConstants.EMPTY_STRING;
        	}
        	
        	for(int innerStart = start+1; innerStart <= cleanedNumber.length();innerStart++){
        		
        		tempString = cleanedNumber.substring(start,innerStart);
        		wordSet = this.dictionary.getWordSetForNumber(tempString);
        		
        		if(wordSet.isEmpty()){
        			continue;
        		}
        		else{
        			//Didn't reach last digit of number.Processing the remaining part of number
        			if(innerStart != cleanedNumber.length()){
        				remainingString = cleanedNumber.substring(innerStart);
        				subResult = convertNumberToWord(remainingString);
        				
        				if(!subResult.isEmpty()){
        					//For each word in result of parent result
        					for(String word:wordSet){
        						//For each word in sub result, add to parent word
        						for(String subWord:subResult){
        							resultString = appender+word+CommonConstants.HYPHEN+subWord;
        							result.add(resultString.toString());
        						}
        					}
        				}
        				//When a single number remains
        				else if(remainingString.length() == 1){
        					//For each word in word set, append the number
        					for(String word:wordSet){
        						 resultString = appender+word+CommonConstants.HYPHEN+remainingString;
                                 result.add(resultString.toString());
        					}
        				}
        			}
        			else{
        				//Reached the last digit in number
        				for(String word:wordSet){
        					result.add(appender+word);
        				}
        			}
        		}
        	}
        }
        return result;
        
	}
	
	/**
	 * Function to remove all punctuation, white space and alphabets from the number
	 * Also makes sure it is a proper number by loading into a {@link BigInteger}
	 * @param number String containing the cleaned up number
	 * @return
	 */
	private String cleanUpNumber(String number){
		number = number.replaceAll("[^0-9]","");
		try{
			new BigInteger(number);
		}catch(NumberFormatException e){
			number = CommonConstants.EMPTY_STRING;
		}
		return number;
	}
	
	/**
	 * Function to display the results of conversion
	 * @param number String containing the phone number
	 * @param resultList {@link List} of {@link String} containing the results of conversion for the number
	 */
	private void displayResult(String number,List<String> resultList){
		if(resultList.isEmpty()){
			Logger.INSTANCE.logInfo(Messages.FOR_PHONE_NUMBER+number+Messages.NO_POSSIBLE_WORD_CONVERSIONS);
		}
		else{
			Logger.INSTANCE.logInfo(Messages.FOR_PHONE_NUMBER+number+Messages.POSSIBLE_WORD_CONVERSIONS);
			for(String result:resultList){
				Logger.INSTANCE.logInfo(result);
			}
		}
		Logger.INSTANCE.logInfo(Messages.EMPTY_MESSAGE);
	}
}
