package com.test.challenge.coding;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.readers.DictionaryReader;

public class DictionaryLoadTester {
	@Test
    public void testDictionaryLoading(){
		
		Dictionary dictionary = new DictionaryReader().loadDefault();
 
        assertNotNull(dictionary);
    }
}
