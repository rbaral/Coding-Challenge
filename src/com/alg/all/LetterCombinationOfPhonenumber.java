package com.alg.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */
/**
 * 
 * @author rbaral
 *
 */
public class LetterCombinationOfPhonenumber {

	public static void main(String[] args) {
		boolean testEnabled = true;
		if(testEnabled){
			performTest();
		}else{
			DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
			System.out.println(format.format(new Date()));
			String digits="23";
			Object[] arrOutput = letterCombinations(digits).toArray();
			Arrays.sort(arrOutput);
			System.out.println("output is:"+Arrays.toString(arrOutput));
			System.out.println(format.format(new Date()));
		}

	}
	
	public static List<String> letterCombinations(String digits) {
        List<String> listOfStrings = new ArrayList<String>();
        List<String> tempList = new ArrayList<String>();
        String[] stringNum;
        for(int i=digits.length()-1;i>=0;i--){
        	stringNum= getStringsForNumber(Integer.parseInt(String.valueOf(digits.charAt(i))));
        	if(listOfStrings.isEmpty()){
        		//just add the elements we got for the current number
        		for(String s:stringNum){
        			listOfStrings.add(s);
        		}
        	}else{
        		//find the combination with every element of the lastPairs
        		tempList.clear();
        		for(int k=0; k<stringNum.length; k++){
        			for(int l=0;l<listOfStrings.size();l++){
        				tempList.add(stringNum[k]+listOfStrings.get(l));
        			}
        		}
        		listOfStrings.clear();
        		listOfStrings.addAll(tempList);
        	}
        	
        }
        return listOfStrings;
    }
    
	public static String[] getStringsForNumber(int num) {
		String[] value = new String[]{};
		switch (num) {
		case 2:
			value = new String[]{"a","b","c"};
			break;
		case 3:
			value = new String[]{"d","e","f"};
			break;
		case 4:
			value = new String[]{"g","h","i"};
			break;
		case 5:
			value = new String[]{"j","k","l"};
			break;
		case 6:
			value = new String[]{"m","n","o"};
			break;
		case 7:
			value = new String[]{"p","q","r","s"};
			break;
		case 8:
			value = new String[]{"t","u","v"};
			break;
		case 9:
			value = new String[]{"w","x","y","z"};
			break;
		default:
			value = new String[]{};
		}
		return value;
	}
	
	public static void performTest(){
		Map<String, List<String>> testCases= new HashMap<String, List<String>>();
		List<String> failedCases = new ArrayList<String>();
		List<String> result=new ArrayList<String>();
		List<String> a = new ArrayList<String>(Arrays.asList("adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"));
		testCases.put("234", a);
		a= new ArrayList<String>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
		testCases.put("23", a);
		List<String> expected = new ArrayList<String>();
		for(String testCase: testCases.keySet()){
			result = letterCombinations(testCase);
			expected = testCases.get(testCase);
			for(String resItem:result){
				if(!expected.contains(resItem)){
					failedCases.add("Failed for:{"+testCase+"} got:"+Arrays.toString(result.toArray())+" expected:"+Arrays.toString(testCases.get(testCase).toArray()));
					break;
				}
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}

}
