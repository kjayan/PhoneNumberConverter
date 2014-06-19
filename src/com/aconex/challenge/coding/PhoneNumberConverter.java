package com.aconex.challenge.coding;

import com.aconex.challenge.coding.config.CommonConfig;
import com.aconex.challenge.coding.constants.CommonConstants;
import com.aconex.challenge.coding.messages.Messages;

public class PhoneNumberConverter {

	private PhoneNumberConverter() {
	
	}

	public static void main(String[] args) {
		if(args.length > 0){
			if(CommonConstants.MINUS_D_PARAMETER.equals(args[0])){
				//load custom dictionary
				CommonConfig.INSTANCE.loadCustomDictionary(args[1]);
			}
			else{
				CommonConfig.INSTANCE.getLogger().logInfo(Messages.LOADING_DEFAULT_DICTIONARY);
				CommonConfig.INSTANCE.loadDefaultDictionary();
			}
			
		}

	}
	
	

}
