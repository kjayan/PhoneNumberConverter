package com.aconex.challenge.coding.config;

import com.aconex.challenge.coding.logger.Logger;
import com.aconex.challenge.coding.messages.Messages;

public enum CommonConfig {
	
	INSTANCE;
	
	private Logger logger;
	
	public void initialize(){
		logger = new Logger();
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	public void loadDefaultDictionary(){
		
	}
	
	
	public void loadDefaultPhoneNumbers(){
		
	}
	
	public void loadCustomDictionary(String customDictionaryFile){
		if(customDictionaryFile == null || customDictionaryFile.trim() == ""){
			CommonConfig.INSTANCE.getLogger().logError(Messages.EMPTY_DICTIONARY_PATH);
		}
	}
	
}
