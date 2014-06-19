package com.aconex.challenge.coding.logger;

public class Logger {

	public Logger() {
	}

	
	public void logError(String errorMessage) {
		System.err.println(errorMessage);
		System.exit(1);
	}
	
	public void logInfo(String infoMessage) {
		System.out.println(infoMessage);
	}
}
