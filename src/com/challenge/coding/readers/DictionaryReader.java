package com.challenge.coding.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;
import com.challenge.coding.readers.actions.Readable;
import com.challenge.coding.util.CommonUtil;

public class DictionaryReader implements Readable {

	public DictionaryReader() {
	
	}

	@Override
	public Dictionary loadDefault(){
		InputStream stream = this.getClass().getResourceAsStream(CommonConstants.DEFAULT_DICTIONARY_FILE);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		Dictionary dictionary  = new DictionaryReader().read(reader);
		CommonUtil.closeFile(reader);
		return dictionary;
	}
	
	@Override
	public Dictionary loadCustom(String customDictionaryFile){
		if(customDictionaryFile == null || CommonConstants.EMPTY_STRING.equals(customDictionaryFile.trim())){
			Logger.INSTANCE.logError(Messages.EMPTY_DICTIONARY_PATH);
		}
		BufferedReader reader = CommonUtil.loadFile(customDictionaryFile);
		if(reader == null){
			Logger.INSTANCE.logError(Messages.INVALID_DICTIONARY);
		}
		Dictionary dictionary = new DictionaryReader().read(reader);
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
	
	/**
	 * Function to add a word to the dictionary.
	 * Word is converted to uppercase and the corresponding key for the word is found			
	 * @param dictionary An instance of {@link Dictionary } containing the list of words
	 * @param word String containing the word to be added to the dictionary
	 */
	private void addWordToDictionary(Dictionary dictionary,String word){
		word = word.toUpperCase();
		String key = findKey(word);
		dictionary.addWord(key,word);
	}
	
	/**
	 * Function to find the key for a given word
	 * @param word String containing the word for which the key is to be found
	 * @return String containing the key
	 */
	private String findKey(String word){
		
		StringBuilder key = new StringBuilder();
		String currentChar = "";
		
		for(int i=0;i<word.length();i++){
			
			currentChar = String.valueOf(word.charAt(i));
			
			if(CommonConstants.NUMBER_2.contains(currentChar)){
                key.append(2);
            }
            else if(CommonConstants.NUMBER_3.contains(currentChar)){
                key.append(3);
            }
            else if(CommonConstants.NUMBER_4.contains(currentChar)){
                key.append(4);
            }
            else if(CommonConstants.NUMBER_5.contains(currentChar)){
                key.append(5);
            }
            else if(CommonConstants.NUMBER_6.contains(currentChar)){
                key.append(6);
            }
            else if(CommonConstants.NUMBER_7.contains(currentChar)){
                key.append(7);
            }
            else if(CommonConstants.NUMBER_8.contains(currentChar)){
                key.append(8);
            }
            else if(CommonConstants.NUMBER_9.contains(currentChar)){
                key.append(9);
            }
		}
		return key.toString();
	}
}
