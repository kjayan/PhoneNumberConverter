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

	private Dictionary dictionary;
	
	public void initialize(){
	}
	
	public Dictionary getDictionary(){
		return dictionary;
	}
	
	public void loadDefaultDictionary(){
		this.dictionary = new DictionaryReader().loadDefaultDictionary(CommonConstants.DEFAULT_DICTIONARY_FILE);
	}
	
	
	public void loadCustomDictionary(String customDictionaryFile){
		if(customDictionaryFile == null || CommonConstants.EMPTY_STRING.equals(customDictionaryFile.trim())){
			Logger.INSTANCE.logError(Messages.EMPTY_DICTIONARY_PATH);
		}
		BufferedReader reader = CommonUtil.loadFile(customDictionaryFile);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.INVALID_DICTIONARY);
		}
		this.dictionary = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
	}

}
