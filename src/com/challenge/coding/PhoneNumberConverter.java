package com.challenge.coding;

import com.challenge.coding.config.CommonConfig;
import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.processor.PhoneNumberProcessor;

public class PhoneNumberConverter {

	private PhoneNumberConverter() {
	
	}

	public static void main(String[] args) {
		CommonConfig.INSTANCE.initialize();
		if(args.length > 0){
			if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
				//load custom dictionary
				CommonConfig.INSTANCE.loadCustomDictionary(args[1]);
			}
		}
		else{
			Logger.INSTANCE.logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
			CommonConfig.INSTANCE.loadDefaultDictionary();
		}
		
		CommonConfig.INSTANCE.loadDefaultPhoneNumbers();
		
		PhoneNumberProcessor processor = new PhoneNumberProcessor();
		processor.process(CommonConfig.INSTANCE.getDefultPhoneNumbers());
		
	}
}
