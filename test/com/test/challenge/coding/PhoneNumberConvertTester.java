package com.test.challenge.coding;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.entities.PhoneNumbers;
import com.challenge.coding.processor.PhoneNumberProcessor;
import com.challenge.coding.readers.DictionaryReader;


public class PhoneNumberConvertTester {
	
	@Test
    public void testConvertNumbers(){
       
		Dictionary dictionary = new DictionaryReader().loadDefaultDictionary(CommonConstants.DEFAULT_DICTIONARY_FILE);
      
        List<String> resultObtained = null; 
        Map<String, Set<String>> expectedResult = new HashMap<String, Set<String>>();
        
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.addNumber("2255.63");
        phoneNumbers.addNumber("263-464-242-5.53-643");
        phoneNumbers.addNumber("a5483728873");
        phoneNumbers.addNumber("54837a28873");
        phoneNumbers.addNumber("548$3728873");
        
        Set<String> testList = new HashSet<String>();

        testList.add("CALL-ME");
        expectedResult.put("2255.63",testList);

        testList = new HashSet<String>( );
        testList.add("CODING-CHALLENGE");
        expectedResult.put("263-464-242-5.53-643",testList);

        testList = new HashSet<String>();
        expectedResult.put("a5483728873",testList);
        expectedResult.put("54837a28873",testList);
        expectedResult.put("548$3728873",testList);
        
        PhoneNumberProcessor processor = new PhoneNumberProcessor(dictionary);
        
        for(String number:phoneNumbers.getNumbers()){
        	resultObtained = processor.process(number);
        	assertNotNull(resultObtained);
        	resultObtained.contains(expectedResult.get(number));
        }
     }
}
