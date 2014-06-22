package com.challenge.coding.readers.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.challenge.coding.entities.BaseEntity;

/**
 * 
 * @author Jayan
 * Interface defining the basic and common actions for the different readers
 *
 */
public interface Readable {

	/**
	 * Function which accepts a {@link BufferedReader} and reads the input
	 * @param reader An instance of {@link BufferedReader} which has opened the required {@link InputStreamReader}
	 * @return An instance of {@link BaseEntity} which has the loaded contents
	 */
	public abstract BaseEntity read(BufferedReader reader);
	
	
	/**
	 * Function which loads the default file and loads the content corresponding to the reader
	 * @return An instance of {@link BaseEntity} which has the loaded contents
	 */
	public abstract BaseEntity loadDefault();
	
	/**
	 * Function which takes in a custom file and loads the content corresponding to the reader
	 * @param customFilePath String which indicates the complete path of the file to be loaded
	 * @return An object of {@link BaseEntity} which has the loaded contents
	 */
	public abstract BaseEntity loadCustom(String customFilePath);

}
