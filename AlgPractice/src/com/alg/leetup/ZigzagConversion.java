package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
/**
 * @author rbaral
 *
 */
public class ZigzagConversion {

	public static void main(String[] args) {
		boolean testEnabled = true;
		if(testEnabled){
			performTest();
		}else{
			DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
			System.out.println(format.format(new Date()));
			String s="PAYPALISHIRING";
			int rows=3;
			System.out.println("output is:"+convert(s, rows));
			System.out.println(format.format(new Date()));
		}
	}
	
	public static String convert(String s, int numRows) {
        if(numRows<2)
            return s;
        
        //lets make a list of char from the string array
        List<String> charList = new ArrayList<String>();
        for(int i=0;i<s.length();i++)
        	charList.add(String.valueOf(s.charAt(i)));
        List<String> outputList = new ArrayList<String>();
        int rowIndex=0,nextElementIndex=0;
        for(int i=0;i<s.length();i++){
        	//first add one element to each row
        	if(rowIndex<numRows){
        		//if this is the first time we are adding to this index
        		if(outputList.size()<numRows)
        			outputList.add(String.valueOf(s.charAt(i)));
        		else
        			outputList.set(rowIndex,outputList.get(rowIndex)+String.valueOf(s.charAt(i)));
        		rowIndex++;
        		nextElementIndex=0;
        	}
        	else{/*now if there are still elements, then append the the list from backwards, skipping the last and the first entries
            	if the index has value 0, then the next element will be added to position 1
            	find the position to add the remaining elements*/  
        		if(nextElementIndex==0)//this is the first time we are skipping characters
        			nextElementIndex = numRows-1;//next element will be added to this row
        		outputList.set(nextElementIndex-1,outputList.get(nextElementIndex-1)+String.valueOf(s.charAt(i)));
        		if(nextElementIndex==1){//we reached the first row, so the next character should be inserted in second position
        			rowIndex=1;
        		}else
        			nextElementIndex--;
        	}
        }
        String output="";
        for(String item:outputList){
        	output+=item;
        }
        return output;
    }
	
	public static void performTest(){
		/**
		 *  * Test cases:
		 * abc,3->abc
		 * abc,2->"acb"
		 * PAYPALISHIRING,3->PAHNAPLSIIGYIR
		 */
		Map<String,String> testCases= new HashMap<String,String>();
		List<String> failedCases = new ArrayList<String>();
		String result="";
		testCases.put("abc,3", "abc");
		testCases.put("abc,2", "acb");
		testCases.put("PAYPALISHIRING,3", "PAHNAPLSIIGYIR");
		testCases.put("ABCD,2", "ACBD");
		testCases.put("PAYPA,2","PYAAP");
		testCases.put("ABCDE,4", "ABCED");
		testCases.put("ABCDEE,4", "ABECED");
		
		for(String testCase: testCases.keySet()){
			result = convert(testCase.split(",")[0], Integer.parseInt(testCase.split(",")[1]));
			if(!result.equals(testCases.get(testCase))){
				failedCases.add("Failed for:{"+testCase+"} got:"+result+" expected:"+testCases.get(testCase));
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}

}
