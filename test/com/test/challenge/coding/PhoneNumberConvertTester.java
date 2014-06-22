package com.test.challenge.coding;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.challenge.coding.constants.CommonConstants;
import com.challenge.coding.entities.Dictionary;
import com.challenge.coding.readers.DictionaryReader;


public class PhoneNumberConvertTester {
	
	@Test
    public void testConvertNumbers(){
        Dictionary dictionary = new DictionaryReader().loadDefaultDictionary(CommonConstants.DEFAULT_DICTIONARY_FILE);
      
        Map<String, Set<String>> resultObtained = null; 
        Map<String, Set<String>> expectedResult = new HashMap<String, Set<String>>();

        Set<String> testList = new HashSet<String>();

        testList.add( "CHAIR-NO-3" );
        testList.add( "CHAIR-ON-3" );
        testList.add( "CHAIR-6-ME" );
        testList.add( "2-GAG-7-NO-3" );
        testList.add( "2-GAG-7-ON-3" );
        testList.add( "2-HAIR-NO-3" );
        testList.add( "2-HAIR-ON-3" );
        testList.add( "2-HAIR-6-ME" );
        expectedResult.put( "24247.663", testList );

        testList = new HashSet<String>( );
        testList.add( "GAG-7-AN-6" );
        testList.add( "HAIR-AN-6" );
        testList.add( "HAIR-2-NO" );
        testList.add( "HAIR-2-ON" );
        testList.add( "4-AIR-AN-6" );
        testList.add( "4-AIR-2-NO" );
        testList.add( "4-AIR-2-ON" );
        expectedResult.put( "42472.66", testList );

        testList = new HashSet<String>( );
        testList.add( "CHAIR-NO" );
        testList.add( "CHAIR-ON" );
        testList.add( "2-GAG-7-NO" );
        testList.add( "2-GAG-7-ON" );
        testList.add( "2-HAIR-NO" );
        testList.add( "2-HAIR-ON" );
        expectedResult.put( "24247.66", testList );

        testList = new HashSet<String>( );
        testList.add( "CODING-CHALLENGE" );
        expectedResult.put( "263-464-242-5.53-643", testList );

        testList = new HashSet<String>( );
        testList.add( "TWO-ME" );
        testList.add( "8-ZONE" );
        expectedResult.put( "89-663", testList );

        testList = new HashSet<String>();
        testList.add( "PRESENTATION-NO-3" );
        testList.add( "PRESENTATION-ON-3" );
        testList.add( "PRESENTATION-6-ME" );
        expectedResult.put( "77/3!7#36%82%84&6*6(6)6_3", testList );

        testList = new HashSet<String>();
        expectedResult.put( "a5483728873", testList );
        expectedResult.put( "54837a28873", testList );
        expectedResult.put( "548$3728873", testList );

       // resultObtained = oFileParser.analyzeFile( "Numbers.txt" );
        

        assertNotNull(resultObtained);

        Set<String> keySet = resultObtained.keySet( );

        for (String key:keySet){
            assertTrue ( expectedResult.containsKey(key));
            assertEquals(expectedResult.get(key),resultObtained.get(key));
        }
    }

}
