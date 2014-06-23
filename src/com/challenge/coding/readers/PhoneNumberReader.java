package com.challenge.coding.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.actions.Readable;
import com.challenge.coding.util.CommonUtil;

public class PhoneNumberReader implements Readable{

	public PhoneNumberReader() {
	}

	@Override
	public PhoneNumbers loadCustom(String numberFilePath){
		BufferedReader reader = CommonUtil.loadFile(numberFilePath);
		PhoneNumbers numbers = this.read(reader);
		CommonUtil.closeFile(reader);
		return numbers;
	}
	
	@Override
	public PhoneNumbers loadDefault(){
		InputStream stream = this.getClass().getResourceAsStream(CommonConstants.DEFAULT_PHONE_NUMBER_FILE);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		PhoneNumbers numbers = this.read(reader);
		CommonUtil.closeFile(reader);
		return numbers;
	}
	
	@Override
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
	
	/**
	 * Function to read the numbers from STDIN one by one.
	 * The reading is stopped once the string '$end' is entered by the user
	 * @param reader An instance of {@link PhoneNumbers} containing the list of numbers entered
	 * @return
	 */
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
}
