package com.challenge.coding.config;

import java.io.BufferedReader;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.DictionaryReader;
import com.challenge.coding.readers.PhoneNumberReader;
import com.challenge.coding.util.CommonUtil;

public enum CommonConfig {
	
	INSTANCE;

	private Dictionary dictionary;
	private PhoneNumbers phoneNumbers;
	
	public void initialize(){
	}
	
	public Dictionary getDictionary(){
		return dictionary;
	}
	
	public PhoneNumbers getDefultPhoneNumbers(){
		return phoneNumbers;
	}
	
	public void loadDefaultDictionary(){
		BufferedReader reader = CommonUtil.loadFile(CommonConstants.DEFAULT_DICTIONARY_FILE);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.DEFAULT_DICTIONARY_NOT_FOUND);
		}
		this.dictionary = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
	}
	
	
	public void loadCustomDictionary(String customDictionaryFile){
		if(customDictionaryFile == null || customDictionaryFile.trim() == ""){
			Logger.INSTANCE.logError(Messages.EMPTY_DICTIONARY_PATH);
		}
		BufferedReader reader = CommonUtil.loadFile(customDictionaryFile);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.INVALID_DICTIONARY);
		}
		this.dictionary = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
	}
	
	public void loadDefaultPhoneNumbers(){
		BufferedReader reader = CommonUtil.loadFile(CommonConstants.DEFAULT_PHONE_NUMBER_FILE);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.DEFAULT_PHONE_NUMBERS_NOT_FOUND);
		}
		this.phoneNumbers = new PhoneNumberReader().read(reader);
		CommonUtil.closeFile(reader);
	}
	
}
