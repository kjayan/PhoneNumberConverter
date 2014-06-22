package com.challenge.coding.logger;

/**
 * Logger to log messages. Singleton using enum is used.
 * This implementation can be replaced with any other implementation without affecting the usage
 * @author Jayan
 *
 */
public enum Logger {
	
	INSTANCE;
	
	public void logError(String errorMessage) {
		System.err.println(errorMessage);
		System.exit(1);
	}
	
	public void logInfo(String infoMessage) {
		System.out.println(infoMessage);
	}
}
