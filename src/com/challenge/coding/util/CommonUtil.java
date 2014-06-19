package com.challenge.coding.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.challenge.coding.config.CommonConfig;
import com.challenge.coding.messages.Messages;

public class CommonUtil {

	private CommonUtil() {
	}
	
	public static BufferedReader loadFile(String filePath){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			return reader;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
	public static void closeFile(BufferedReader reader){
		try {
			if(reader != null){
				reader.close();
			}
		} catch (IOException e) {
			CommonConfig.INSTANCE.getLogger().logError(Messages.BUFFERED_READER_CLOSE_FAILED);
		}
	}
	
	 public static boolean isAlphanumeric(String str) {

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 'A' || c > 'z' || (c > 'Z' && c < 'a')) {
				return false;
			}
		}
		return true;
	}

}
