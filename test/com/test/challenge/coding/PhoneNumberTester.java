package com.test.challenge.coding;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.processor.PhoneNumberProcessor;
import com.challenge.coding.readers.DictionaryReader;


/**
 * Test class to check if the phone numbers are loaded correctly and conversion to words is proper
 * @author kjayan
 *
 */
public class PhoneNumberTester {
	
	/**
	 * Test function to check if for a sample number, proper converted word is returned
	 */
	@Test
	public void checkForProperConversion(){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Call\nme".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
			
		assertEquals(2, dictionary.getTotalWords());
		
		PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
		List<String> result = processor.process("2255.63");
		
		assertEquals(1, result.size());
		assertEquals("CALL-ME", result.get(0));
	}
	
	/**
	 * Test function to make sure all punctuation, spaces and non-numbers are removed from the phone numbers entered
	 * @throws IOException
	 */
	@Test
	public void checkIfNumbersAreLoadedProperly() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Call\nme".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		
		assertEquals(2, dictionary.getTotalWords());

		PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
		List<String> result = processor.process("(2)2*5 5.6#3aa");

		assertEquals(1, result.size());
		assertEquals("CALL-ME", result.get(0));
	}
	
	/**
	 * Test function to check if a non-conversion of a single digit is allowed
	 * @throws IOException
	 */
	@Test
	public void checkAllowingSingleDigitInResult() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Can\nBan\nRan\nFan\nPan".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		
		assertEquals(5,dictionary.getTotalWords());
		
		PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
		
		List<String> result = processor.process("1-226");
		assertEquals(2,result.size());
		
		assertTrue(result.contains("1-CAN"));
		assertTrue(result.contains("1-BAN"));

		result.clear();

		result = processor.process("326-1-726");
		assertEquals(2,result.size());
		
		assertTrue(result.contains("FAN-1-PAN"));
		assertTrue(result.contains("FAN-1-RAN"));
		
		result.clear();
		
		result = processor.process("226-326-1");
		assertEquals(2,result.size());
		
		assertTrue(result.contains("BAN-FAN-1"));
		assertTrue(result.contains("CAN-FAN-1"));

		result.clear();
	}

	/**
	 * Test function to make sure not more than 1 digit is allowed in result
	 * @throws IOException
	 */
	@Test
	public void checkDisallowingMoreThanOneDigitInResult() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Can\nBan\nRan\nFan\nPan".getBytes()))); 
		Dictionary dictionary = new DictionaryReader().read(reader);
		
		assertEquals(5,dictionary.getTotalWords());
		
		PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
		List<String> result = processor.process("226-11-326");
		
		assertEquals(0,result.size());
		
		result.clear();

		result = processor.process("11-226-326");
		assertEquals(0,result.size());
		
		result.clear();

		result = processor.process("226-726-11");
		assertEquals(0,result.size());
		result.clear();

	}
}
