package com.challenge.coding.config;

import java.io.BufferedReader;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.DictionaryReader;
import com.challenge.coding.util.CommonUtil;

public enum CommonConfig {
	
	INSTANCE;
	
	private Logger logger;
	private Dictionary dictionary;
	
	public void initialize(){
		logger = new Logger();
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	public Dictionary getDictionary(){
		return dictionary;
	}
	
	public void loadDefaultDictionary(){
		BufferedReader reader = CommonUtil.loadFile(CommonConstants.DEFAULT_DICTIONARY_FILE);
		if(reader == null){
			CommonConfig.INSTANCE.getLogger().logError(Messages.DEFAULT_DICTIONARY_NOT_FOUND);
		}
		this.dictionary = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
	}
	
	
	public void loadCustomDictionary(String customDictionaryFile){
		if(customDictionaryFile == null || customDictionaryFile.trim() == ""){
			CommonConfig.INSTANCE.getLogger().logError(Messages.EMPTY_DICTIONARY_PATH);
		}
		BufferedReader reader = CommonUtil.loadFile(customDictionaryFile);
		if(reader == null){
			CommonConfig.INSTANCE.getLogger().logError(Messages.INVALID_DICTIONARY);
		}
		this.dictionary = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
	}
	
	public void loadDefaultPhoneNumbers(){
		
	}
	
}
