package com.challenge.coding.logger;

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
