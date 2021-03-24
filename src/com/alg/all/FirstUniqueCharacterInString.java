/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
* 
* 
* Solution 1:
* As we have just 26 characters in English, we can use the count by scanning all the characters in the string
* The challenge is to get the right index of the unique character
* 1) In one pass, just store the count of the chars in the string - O(n)
* 2) In second pass, check if the characater's count is just 1, if so, return the index - O(n)
* 
* Complexity - O(2n)
* Space - O(n)
 *
 * @author rbaral
 */
public class FirstUniqueCharacterInString {
    
    /**
     * return the index of the first unique character
     * @param s
     * @return 
     */
    public static int firstUniqChar(String s) {
        int charCount[] = new int[26];
        //store the count
        for(int i=0;i<s.length(); i++){
            charCount[s.charAt(i)-'a']+=1;
        }
        //iterate and for those whose count is 1, find the min Index in s
        for(int i=0;i<s.length();i++){
            if(charCount[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
    
    //just single pass is allowed
    //scan from the last character and keep on adding to the hash
    //remove if it's duplicate is found
    //the one that is added at last will be the first unique one
    public static int firstUniqCharSinglePass(String s){
        int uniqueIndex = -1;
        Map<Character,Integer> charsCount = new HashMap<Character,Integer>();
        for(int i=s.length()-1;i>=0;i--){
            if(!charsCount.containsKey(s.charAt(i))){
                //the char not found so far
                charsCount.put(s.charAt(i), 0);
                uniqueIndex = i;
            }
            charsCount.put(s.charAt(i),charsCount.get(s.charAt(i))+1);
            //if the index at this position is not unique move it to last
            
        }
        return uniqueIndex;
    }
    
    public static void main(String args[]){
        String s = "leetcode";
        //System.out.println(firstUniqChar(s));
        s = "loveleetcode";
        //System.out.println(firstUniqChar(s));
        s= "";
        //System.out.println(firstUniqChar(s));
        s = "leetcodel";
        System.out.println(firstUniqCharSinglePass(s));
    }
}
