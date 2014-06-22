package com.challenge.coding.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity to hold the list of phone numbers which has to be converted to words
 * @author Jayan
 *
 */
public class PhoneNumbers extends BaseEntity{
	
	//A list is used to store the numbers.
	private List<String> numberList;
	
	public PhoneNumbers() {
		numberList = new ArrayList<String>();
	}
	
	/**
	 * Function to add a number to the list. Further validation checks can be added later
	 * @param number
	 */
	public void addNumber(String number){
		numberList.add(number);
	}
	
	/**
	 * Function to get the list of numbers loaded
	 * @return
	 */
	public List<String> getNumbers(){
		return this.numberList;
	}
}
