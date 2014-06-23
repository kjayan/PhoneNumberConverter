package com.challenge.coding.logger;

/**
 * Logger to log messages. Singleton using enum is used.
 * This implementation can be replaced with any other implementation without affecting the usage
 * @author Jayan
 *
 */
public enum Logger {
	
	INSTANCE;
	
	/**
	 * Function to log an error and exit the program
	 * @param errorMessage String containing the error message
	 */
	public void logError(String errorMessage) {
		System.err.println(errorMessage);
		System.exit(1);
	}
	
	/**
	 * Function to log information message to the console
	 * @param infoMessage String containing the message to be logged
	 */
	public void logInfo(String infoMessage) {
		System.out.println(infoMessage);
	}
}
