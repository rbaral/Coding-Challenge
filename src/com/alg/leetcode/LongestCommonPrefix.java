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
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
/**
 * 
 * @author rbaral
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		boolean testEnabled = true;
		if(testEnabled){
			performTest();
		}else{
			DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
			System.out.println(format.format(new Date()));
			String strs[]={"abca","aba","aaab"};
			System.out.println("output is:"+longestCommonPrefix(strs));
			System.out.println(format.format(new Date()));
		}

	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        String longPref="";
        //lets assume that the longest prefix is the first string
        longPref=strs[0];
        if(longPref.length()==0)//if it was empty string
        	return "";
        for(int i=1;i<strs.length;i++){
        	if(strs[i].length()==0 || longPref.charAt(0)!=strs[i].charAt(0))//if they dont have first char matching
        		return "";
        	if(longPref.length()>strs[i].length())
        		longPref = getCommonPrefix(longPref, strs[i]);
        	else
        		longPref = getCommonPrefix(strs[i], longPref);
        }
        return longPref;
    }
	
	public static String getCommonPrefix(String longString, String shortString){//we assume first be at least same length as second param
		String temp="";
		int foundIndex = -1;
		foundIndex = longString.indexOf(shortString);
        if(foundIndex!=0){
            //repetitively eliminate the rightmost char of the shortest string and check for the common prefix, 
        	//till a match is found or one is empty
        	temp = shortString;
        	while(temp.length()>0 && foundIndex!=0){
        		temp = temp.substring(0, temp.length()-1);
        		foundIndex = longString.indexOf(temp);
        	}
        	if(foundIndex!=0)//if still didn't find anything in common
        		return "";
        	else
        		return temp;
        }
        else{
        	return shortString;
        }
    }
	
	public static void performTest(){
		Map<String[],String> testCases= new HashMap<String[],String>();
		List<String> failedCases = new ArrayList<String>();
		String result="";
		String[]a=new String[]{};
		testCases.put(a, "");
		a=new String[]{"ab","a"};
		testCases.put(a, "a");
		a=new String[]{"abc","d"};
		testCases.put(a, "");
		a= new String[]{"acb","b","",""};
		testCases.put(a, "");
		a= new String[]{"bbcb","c","aca"};
		testCases.put(a, "");
		a= new String[]{"bbcb","ba","bed"};
		testCases.put(a, "b");
		a= new String[]{"abca","aba","aaab"};
		testCases.put(a, "a");
		
		for(String[] testCase: testCases.keySet()){
			result = longestCommonPrefix(testCase);
			if(!result.equals(testCases.get(testCase))){
				failedCases.add("Failed for:{"+Arrays.toString(testCase)+"} got:"+result+" expected:"+testCases.get(testCase));
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}

}
