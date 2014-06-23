package com.challenge.coding.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.challenge.coding.logger.Logger;
import com.challenge.coding.messages.Messages;

/**
 * Class containing a collection of utility functions
 * @author Jayan
 *
 */
public class CommonUtil {

	private CommonUtil() {
	}
	
	/**
	 * Function to load a file from the given path
	 * @param filePath String containing the path where file is present
	 * @return An instance of {@link BufferedReader} containing {@link InputStreamReader} to the file
	 */
	public static BufferedReader loadFile(String filePath){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			return reader;
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFound:"+filePath+"\n"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * Function to read a line using the {@link BufferedReader} 
	 * Returns empty string in case of some invalid input
	 * @param reader An instance of {@link BufferedReader} containing {@link InputStreamReader} to the file
	 * @return String which has the line read or empty string in case of invalid input
	 */
	public static String readLine(BufferedReader reader){
		String readLine = "";
		try{
			readLine = reader.readLine();
		}catch(IOException e){
			Logger.INSTANCE.logInfo(Messages.INPUT_NOT_PROPER);
			readLine = "";
		}
		return readLine;
	}
	
	/**
	 * Function to close the {@link BufferedReader} which was opened to read a file
	 * As of now, any error while closing the reader is ignored
	 * @param reader An instance of {@link BufferedReader} containing {@link InputStreamReader} to the file
	 */
	public static void closeFile(BufferedReader reader){
		try {
			if(reader != null){
				reader.close();
			}
		} catch (IOException e) {
			Logger.INSTANCE.logError(Messages.BUFFERED_READER_CLOSE_FAILED);
		}
	}
	
	/**
	 * Function to check if the word contains only letters between A-Z or a-z
	 * @param word String containing the word which has to be checked 
	 * @return true if the string contains only alphabets. Else false
	 */
	public static boolean isAlphanumeric(String word) {

		for(int i=0;i<word.length();i++){
			char letter = word.charAt(i);
			if(letter<'A' || letter>'z' || (letter>'Z' && letter<'a')){
				return false;
			}
		}
		return true;
	}

}
