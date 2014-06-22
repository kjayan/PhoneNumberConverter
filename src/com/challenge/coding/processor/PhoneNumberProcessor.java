package com.challenge.coding.processor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.challenge.coding.config.CommonConfig;
import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;

public class PhoneNumberProcessor {

	public PhoneNumberProcessor() {
	}
	
	public void process(PhoneNumbers phoneNumbers){
		List<String> result = null;
		for(String number:phoneNumbers.getNumbers()){
			result = convertNumberToWord(number);
			displayResult(number,result);
		}
	}
	
	private List<String> convertNumberToWord(String number){
		String cleanedUpNumber = cleanUpNumber(number);
		List<String> result = new ArrayList<String>();
		List<String> subResult = null;
        Set<String> wordSet;
       
        String tempString = "";
        String remainingString = "";
        String resultString = "";
        String appender = "";
        
        for(int start = 0;start < cleanedUpNumber.length()-1;start++){
        	
        	if(start == 1){
        		appender = String.valueOf(cleanedUpNumber.charAt(0)) + CommonConstants.HYPHEN;
        	}
        	else if(start > 1){
        		break;
        	}
        	else{
        		appender = CommonConstants.EMPTY_STRING;
        	}
        	
        	wordSet = null;
        	tempString = "";
            remainingString = "";
            resultString = "";
        	
        	for(int end = start+1; end <= cleanedUpNumber.length();end++){
        		
        		tempString = cleanedUpNumber.substring(start,end);
        		wordSet = CommonConfig.INSTANCE.getDictionary().getWordSet(tempString);
        		
        		if(wordSet.isEmpty()){
        			continue;
        		}
        		else{
        			if(end != cleanedUpNumber.length()){
        				remainingString = cleanedUpNumber.substring(end);
        				subResult = convertNumberToWord(remainingString);
        				
        				if(!subResult.isEmpty()){
        					for(String word:wordSet){
        						for(String subWord:subResult){
        							resultString = appender+word+CommonConstants.HYPHEN+subWord;
        							result.add(resultString.toString());
        						}
        					}
        				}
        				else if(remainingString.length() == 1){
        					for(String word:wordSet){
        						 resultString = appender+word+CommonConstants.HYPHEN+remainingString;
                                 result.add(resultString.toString());
        					}
        				}
        			}
        			else{
        				for(String word:wordSet){
        					result.add(appender+word);
        				}
        			}
        		}
        	}
        }
        return result;
        
	}
	
	private String cleanUpNumber(String number){
		number = number.replaceAll("\\p{Z}","");
		number = number.replaceAll("\\p{P}","");
		try{
			new BigInteger(number);
		}catch(NumberFormatException e){
			number = CommonConstants.EMPTY_STRING;
		}
		return number;
	}
	
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
