/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

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
    
    public static void main(String args[]){
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        s = "loveleetcode";
        System.out.println(firstUniqChar(s));
        s= "";
        System.out.println(firstUniqChar(s));
    }
}
