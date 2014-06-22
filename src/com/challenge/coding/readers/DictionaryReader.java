package com.challenge.coding.readers;

import java.io.BufferedReader;
import java.io.IOException;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.actions.Readable;
import com.challenge.coding.util.CommonUtil;

public class DictionaryReader implements Readable {

	public DictionaryReader() {
	
	}

	public Dictionary loadDefaultDictionary(String filePath){
		BufferedReader reader = CommonUtil.loadFile(filePath);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.DEFAULT_DICTIONARY_NOT_FOUND);
		}
		Dictionary dictionary  = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
		return dictionary;
	}
	
	@Override
	public Dictionary read(BufferedReader reader) {
		Dictionary dictionary = new Dictionary();
		String lineRead = "";
		if(reader != null){
			try {
				while((lineRead = reader.readLine()) != null){
					lineRead = lineRead.trim(); 
					if(lineRead != "" && CommonUtil.isAlphanumeric(lineRead)){
						addWordToDictionary(dictionary,lineRead);
					}
				}
			} catch (IOException e) {
				Logger.INSTANCE.logError(Messages.INVALID_WORD_IN_DICTIONARY);
			}
		}
		return dictionary;
	}
	
	private void addWordToDictionary(Dictionary dictionary,String word){
		word = word.toUpperCase();
		String key = findKey(word);
		dictionary.addWord(key,word);
	}
	
	private String findKey(String word){
		StringBuilder key = new StringBuilder();
		String currentChar = "";
		for(int i=0;i<word.length();i++){
			currentChar = String.valueOf(word.charAt(i));
			
			if(CommonConstants.STR_2.contains(currentChar)){
                key.append(2);
            }
            else if(CommonConstants.STR_3.contains(currentChar)){
                key.append(3);
            }
            else if(CommonConstants.STR_4.contains(currentChar)){
                key.append(4);
            }
            else if(CommonConstants.STR_5.contains(currentChar)){
                key.append(5);
            }
            else if(CommonConstants.STR_6.contains(currentChar)){
                key.append(6);
            }
            else if(CommonConstants.STR_7.contains(currentChar)){
                key.append(7);
            }
            else if(CommonConstants.STR_8.contains(currentChar)){
                key.append(8);
            }
            else if(CommonConstants.STR_9.contains(currentChar)){
                key.append(9);
            }
		}
		return key.toString();
	}
}
