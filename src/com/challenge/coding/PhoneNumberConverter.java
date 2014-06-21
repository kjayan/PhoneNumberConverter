package com.challenge.coding;

import java.io.BufferedReader;
import java.util.Scanner;

import com.challenge.coding.config.CommonConfig;
import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.processor.PhoneNumberProcessor;
import com.challenge.coding.readers.PhoneNumberReader;
import com.challenge.coding.util.CommonUtil;

public class PhoneNumberConverter {

	private PhoneNumberConverter() {
	
	}

	public static void main(String[] args) {
		CommonConfig.INSTANCE.initialize();
		PhoneNumbers numbers = null;
		if(args.length == 3){
			if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
				CommonConfig.INSTANCE.loadCustomDictionary(args[1]);
			}
			numbers = loadCustomPhoneNumbers(args[2]);
		}
		else if(args.length == 1){
			Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
			CommonConfig.INSTANCE.loadDefaultDictionary();
			numbers = loadCustomPhoneNumbers(args[0]); 
			
		}
		else{
			Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
			CommonConfig.INSTANCE.loadDefaultDictionary();
			Logger.INSTANCE.logInfo(Messages.NO_PHONE_NUMBERS_FILE);
			Logger.INSTANCE.logInfo(Messages.ENTER_SPECIFIC_NUMBERS);
			int choice = new Scanner(System.in).nextInt();
			if(choice == 1){
				CommonConfig.INSTANCE.loadDefaultPhoneNumbers();
				numbers = CommonConfig.INSTANCE.getDefultPhoneNumbers();
			}
			else if(choice == 2){
				//wait for custom numbers
				//store all and process
				numbers = null;
			}
		}
				
		
		PhoneNumberProcessor processor = new PhoneNumberProcessor();
		processor.process(numbers);
		
	}
	
	private static PhoneNumbers loadCustomPhoneNumbers(String numberFilePath){
		BufferedReader reader = CommonUtil.loadFile(numberFilePath);
		PhoneNumbers numbers = new PhoneNumberReader().read(reader);
		CommonUtil.closeFile(reader);
		return numbers;
	}
}
