package com.challenge.coding.readers.actions;

import java.io.BufferedReader;

import com.challenge.coding.entities.BaseEntity;

public interface Readable {

	
	public abstract void read();
	
	public abstract BaseEntity read(BufferedReader reader);
	
	
}
