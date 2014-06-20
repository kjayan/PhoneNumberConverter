package com.challenge.coding.entities;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers extends BaseEntity{
	
	private List<String> numberList;
	
	public PhoneNumbers() {
		numberList = new ArrayList<String>();
	}
	
	public void addNumber(String number){
		numberList.add(number);
	}
	
	public List<String> getNumbers(){
		return this.numberList;
	}
}
