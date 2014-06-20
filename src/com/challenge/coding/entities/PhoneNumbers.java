package com.challenge.coding.entities;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers extends BaseEntity{
	
	private List<String> numberList;
	
	public PhoneNumbers() {
		numberList = new ArrayList<String>();
	}
	
	public void addNumber(String number){
		number = cleanUpNumber(number);
		numberList.add(number);
	}
	
	public List<String> getNumbers(){
		return this.numberList;
	}
	
	private String cleanUpNumber(String number){
		number = number.replaceAll("\\p{Z}","");
		number = number.replaceAll("\\p{P}","");
		return number;
	}

}
