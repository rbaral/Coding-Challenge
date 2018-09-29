/*
Given a string, find the longest substring which is palindrome. 
For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 */
package com.alg.dp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbaral
 */
public class LongestPalindromesubstring {
 
    /**
     * reverse the string and compare entries in the original and the reversed string
     * @param s
     * @return 
     */
    public static String longestPalSubstr(String s){
        char[] rev = new char[s.length()];
        for(int i=s.length()-1; i>=0; i--)
            rev[s.length() - i -1] = s.charAt(i);
        StringBuffer pal = new StringBuffer();
        List<String> palsList = new ArrayList<String>();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)==rev[i]){
                pal.append(s.charAt(i));
            }else{
                //that was the last palindrome we found so far, save it in cache and check for another
                palsList.add(pal.toString());
                pal.delete(0, pal.length());
            }
        }
        //now check which one is the longest palindrome found so far and return that
        String longestPal = "";
        for(String ss: palsList){
            System.out.println("potential pal is:"+ss);
            if(ss.length()> longestPal.length()){
                longestPal = ss;
            }
        }
        return longestPal;
    }
     public static void main(String[] args) {
 
        String str = "forgeeksskeegfor";
        //str = "abcd";
        System.out.println("Length is: " + 
                                 longestPalSubstr(str));
    }
}
