package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */
/**
 * Solution 1:
 * 1)assume the first element of the array is the longest common prefix
 * 1 a) if it is blank, return blank
 * 2)compare the longest common prefix with the next element in array
 * 2 a) if they don't have matching first character, return blank
 * 2 b) if they have matching, first character, find the longer and shorter among those two elements
 * and look for the chance of having the shorter element in longer element
 * 2 c) if the whole shorter element is not found in longer element, iteratively eliminate the rightmost character
 * of the shorter element till it's length is greater than 0
 * 3) repeat the process till we deal with all the elements of the array or blank is returned
 * 
 * Complexity: O(n^2) - O(n) to iterate n elements of array and O(n) at worst to iteratively check the characters of shorter element against the character of longer elements
 * 
 * NOTE: It's a good idea to consider the shortest string from the list as the common prefix rather than taking the first one
 * because this will reduce the number of comparisons
 * 
 * 
 *
 * @author rbaral
 *
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        boolean testEnabled = true;
        if (testEnabled) {
            performTest();
        } else {
            DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
            System.out.println(format.format(new Date()));
            String strs[] = {"abca", "aba", "aaab"};
            System.out.println("output is:" + longestCommonPrefix(strs));
            //System.out.println("output is:" + longestCommonPrefix1(strs));
            System.out.println(format.format(new Date()));
        }

    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String longPref = "";
        //lets assume that the longest prefix is the first string
        longPref = strs[0];
        if (longPref.length() == 0)//if it was empty string
        {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0 || longPref.charAt(0) != strs[i].charAt(0))//if they dont have first char matching
            {
                return "";
            }
            if (longPref.length() > strs[i].length()) {
                longPref = getCommonPrefix(longPref, strs[i]);
            } else {
                longPref = getCommonPrefix(strs[i], longPref);
            }
        }
        return longPref;
    }

    public static String getCommonPrefix(String longString, String shortString) {//we assume first be at least same length as second param
        String temp = "";
        int foundIndex = -1;
        foundIndex = longString.indexOf(shortString);
        if (foundIndex != 0) {
            //repetitively eliminate the rightmost char of the shortest string and check for the common prefix, 
            //till a match is found or one is empty
            temp = shortString;
            while (temp.length() > 0 && foundIndex != 0) {
                temp = temp.substring(0, temp.length() - 1);
                foundIndex = longString.indexOf(temp);
            }
            if (foundIndex != 0)//if still didn't find anything in common
            {
                return "";
            } else {
                return temp;
            }
        } else {
            return shortString;
        }
    }

    /**
     * finds the longest common prefix among the strings in the given string array
     * @param s
     * @return 
     */
    public static String longestCommonPrefix(String[] s){
        //first lets find the shortest string among the strings in the array
        int minLength = Integer.MAX_VALUE;
        String prefix = "";
        for(String a:s){
            if(a.length()<minLength){
                minLength = a.length();
                prefix = a;
            }
        }
        //for every successive elements in the array, we find the matching prefix
        for(int i=0;i<s.length;i++){
            //what is the match between prefix and s[i]
            if(prefix.equals(s[i])){//dont need to compare
                continue;
            }
            //now compare the prefix so far and the string s[i] and get the new prefix that holds for s[i] also
            int index = 0;
            String newPrefix = "";
            while(index<prefix.length()){//repeat till the length of previous prefix or the non-matching index of chars in s[i]
                if(prefix.charAt(index)==s[i].charAt(index)){
                    newPrefix+=prefix.charAt(index);
                    index++;
                    continue;
                }else{
                    prefix = newPrefix;
                    break;
                }
            }
            //check if we got just blank common prefixes,if so we dont need to compare with others just return blank
            if(prefix.length()==0){
                return prefix;
            }
        }
        return prefix;
    }
    
    
    
    public static void performTest() {
        Map<String[], String> testCases = new HashMap<String[], String>();
        List<String> failedCases = new ArrayList<String>();
        String result = "";
        String[] a = new String[]{};
        testCases.put(a, "");
        a = new String[]{"ab", "a"};
        testCases.put(a, "a");
        a = new String[]{"abc", "d"};
        testCases.put(a, "");
        a = new String[]{"acb", "b", "", ""};
        testCases.put(a, "");
        a = new String[]{"bbcb", "c", "aca"};
        testCases.put(a, "");
        a = new String[]{"bbcb", "ba", "bed"};
        testCases.put(a, "b");
        a = new String[]{"abca", "aba", "aaab"};
        testCases.put(a, "a");

        for (String[] testCase : testCases.keySet()) {
            result = longestCommonPrefix(testCase);
            //result = longestCommonPrefix1(testCase);
            if (!result.equals(testCases.get(testCase))) {
                failedCases.add("Failed for:{" + Arrays.toString(testCase) + "} got:" + result + " expected:" + testCases.get(testCase));
            }
        }
        System.out.println("TEST RESULT, Passed:" + (testCases.size() - failedCases.size()) + " failed:" + failedCases.size());
        for (String failure : failedCases) {
            System.err.println(failure);
        }
    }

}
