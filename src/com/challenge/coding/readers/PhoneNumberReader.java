package com.challenge.coding.readers;

import java.io.BufferedReader;
import java.io.IOException;

import com.challenge.coding.config.CommonConfig;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.actions.Readable;

public class PhoneNumberReader implements Readable{

	public PhoneNumberReader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
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
				CommonConfig.INSTANCE.getLogger().logError(Messages.INVALID_NUMBER_IN_PHONE_NUMBER);
			}
		}

		return phoneNumbers;
	}


}
