/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rbara012
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.

For example, Given S = “eceba”, T is "ece" which its length is 3.
* 
* Solution 1:
* 1)Use hash to store the characters encountered and update their count as the value
* 2)When the entries in hash is greater than 2, remove the character from map
* 2 a) if the character has count 1, remove it from hash
* 2 b) if the character has count>1, update the count in the hash
* 2 c) update the starting pointer
 * 
 * Complexity: O(nk)
 * 
 * 
 * NOTE:
 * the solution has been extended for at most k distinct characters
 */
public class LongestSubstringWithAtMostTwoDistinctChars {
    
    public static int lengthOfLongestSub(String s, int distinct){
        int maxLen = 0;
        int startIndex = 0;
        String longest = "";
        Map<Character,Integer> chars = new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            chars.put(s.charAt(i), chars.getOrDefault(s.charAt(i), 0)+1);
            
            //check if the recently added char makes more than 2 unique char
            if(chars.size()>distinct){
                if(maxLen<(i-startIndex)){
                    maxLen = i-startIndex;
                    longest = s.substring(startIndex, i);
                }
                //maxLen = Math.max(maxLen, i - startIndex);
                
                //remove one character or reduce the count of duplicate entries
                //the characters are removed in sequential order of their appearance in the input string
                while(chars.size()>distinct){
                    char c = s.charAt(startIndex);
                    if(chars.get(c)>1){
                        chars.put(c, chars.get(c)-1);
                    }else{
                        chars.remove(c);
                    }
                    startIndex++;
                }
            }
        }
        if(maxLen<(s.length()-startIndex)){
            maxLen = s.length()-startIndex;
            longest = s.substring(startIndex, s.length());
        }
        System.out.println("start is:"+startIndex+" the substring is:"+longest);
        //maxLen = Math.max(maxLen, s.length()-startIndex);
        return maxLen;
    }
    
    public static void main(String args[]){
        int k = 2;
        String s = "eceba";
        System.out.println("length:"+lengthOfLongestSub(s, k));
        s = "abac";
        System.out.println("length:"+lengthOfLongestSub(s, k));
        s = "abcadcacacaca";
        System.out.println("length:"+lengthOfLongestSub(s, 3));
        
    }
}
