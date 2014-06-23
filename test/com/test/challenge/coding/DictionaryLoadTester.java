package com.test.challenge.coding;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import org.junit.Test;

import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.readers.DictionaryReader;

/**
 * Test class for checking dictionary loading and other related working of dictionary
 * @author kjayan
 *
 */
public class DictionaryLoadTester {
	
	/**
	 * Test function to check the loading of dictionary is proper
	 */
	@Test
    public void checkDictionaryLoading(){
	
		Dictionary dictionary = new DictionaryReader().loadDefault();
 		assertNotNull(dictionary);
    }
	
	/**
	 * Test function to make sure the dictionary loads only alphabets
	 * @throws IOException
	 */
	
	@Test
	public void checkIfDictionaryLoadsOnlyAlphabets(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Test\ndictionary\nload".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		assertEquals(3, dictionary.getTotalWords());
	}

	/**
	 * Test function to make sure the dictionary doesn't load same word twice
	 * @throws IOException
	 */
	@Test
	public void checkIfDictionaryDoesNotLoadDuplicateWords(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Test\ndictionary\nload\nTest".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		assertEquals(3, dictionary.getTotalWords());
	}
	
	/**
	 * Test function to make sure the dictionary stores all words in upper case
	 * @throws IOException
	 */
	@Test
	public void checkIfDictionaryStoresInUpperCase(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Can\nBan\nTest".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		assertEquals(3, dictionary.getTotalWords());

		Set<String> wordSet = dictionary.getWordSetForNumber("8378");
		assertEquals(1, wordSet.size());
		assertTrue(wordSet.contains("TEST"));

		wordSet = dictionary.getWordSetForNumber("226");
		assertEquals(2, wordSet.size());
		assertTrue(wordSet.contains("CAN"));
		assertTrue(wordSet.contains("BAN"));
	}
	
	/**
	 * Test function to check if dictionary returns correct match for a number
	 * @throws IOException
	 */
	@Test
	public void checkIfDictionaryReturnsCorrectMatch(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Can\nBan\nFan\nRan\nPan".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		
		assertEquals(5, dictionary.getTotalWords());

		Set<String> set = dictionary.getWordSetForNumber("226");
		assertEquals(2, set.size());
		assertTrue(set.contains("CAN"));
		assertTrue(set.contains("BAN"));

		set = dictionary.getWordSetForNumber("726");
		assertEquals(2, set.size());
		assertTrue(set.contains("RAN"));
		assertTrue(set.contains("PAN"));
	}

	/**
	 * Test function to make sure the dictionary doesn't return null, but an empty set when there is not match
	 * @throws IOException
	 */
	@Test
	public void checkIfDictionaryDoesNotReturnNull(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Can\nBan\nFan\nRan\nPan".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		assertNotNull(dictionary.getWordSetForNumber("1234567890987654321"));
	}
}
