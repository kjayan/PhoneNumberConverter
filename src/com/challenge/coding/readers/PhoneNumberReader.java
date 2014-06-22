package com.challenge.coding.readers;

import java.io.BufferedReader;
import java.io.IOException;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.actions.Readable;
import com.challenge.coding.util.CommonUtil;

public class PhoneNumberReader implements Readable{

	public PhoneNumberReader() {
	}

	public PhoneNumbers read(BufferedReader reader){
		
		PhoneNumbers phoneNumbers = new PhoneNumbers();
		String lineRead = "";
		if(reader != null){
			try {
				while((lineRead = reader.readLine()) != null){
					lineRead = lineRead.trim(); 
					if(lineRead != ""){
						phoneNumbers.addNumber(lineRead);
					}
				}
			} catch (IOException e) {
				Logger.INSTANCE.logError(Messages.INVALID_NUMBER_IN_PHONE_NUMBER);
			}
		}

		return phoneNumbers;
	}
	
	public PhoneNumbers readNumbersFromConsole(BufferedReader reader){
		
		PhoneNumbers phoneNumbers = new PhoneNumbers();
		String lineRead = "";
		if(reader != null){
			try {
				while((lineRead = reader.readLine()) != null && !lineRead.equals(CommonConstants.END_OF_INPUT)){
					lineRead = lineRead.trim(); 
					if(lineRead != ""){
						phoneNumbers.addNumber(lineRead);
					}
				}
			} catch (IOException e) {
				Logger.INSTANCE.logError(Messages.INVALID_NUMBER_IN_PHONE_NUMBER);
			}
		}

		return phoneNumbers;
	}
	
	public PhoneNumbers readNumbersFromFile(String numberFilePath){
		BufferedReader reader = CommonUtil.loadFile(numberFilePath);
		PhoneNumbers numbers = this.read(reader);
		CommonUtil.closeFile(reader);
		return numbers;
	}
	
	public PhoneNumbers loadSamplePhoneNumbers(){
		BufferedReader reader = CommonUtil.loadFile(CommonConstants.DEFAULT_PHONE_NUMBER_FILE);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.DEFAULT_PHONE_NUMBERS_NOT_FOUND);
		}
		PhoneNumbers numbers = this.read(reader);
		CommonUtil.closeFile(reader);
		return numbers;
	}
}
