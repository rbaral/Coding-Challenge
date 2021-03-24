/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
* 
* Solution:
* 
* 1) To be anagram, the strings should be of same length
* 2) Let s and t be the two strings
* 3) for every character in s count the occurrence
* 4) for every character in t, decrease the occurence counted in (3)
* 5) if every count index is zero return true else return false
* 
* Runtime: O(3n)
* 
 * @author rbaral
 */
public class ValidAnagrams {
    
    public static boolean isAnagram(String s, String t) {
        //base case
        if(s.length()!=t.length())
            return false;
        int [] charsCount = new int[26];
        for(int i=0;i<s.length();i++){
            charsCount[s.charAt(i) -'a']+=1;
        }
        for(int i=0;i<t.length();i++)
            charsCount[t.charAt(i) -'a']-=1;
        for(int i=0;i<charsCount.length; i++){
            if(charsCount[i]!=0)
                return false;
        }
        return true;
    }
    
    public static void main(String args[]){
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
        s = "rat";
        t = "car";
        System.out.println(isAnagram(s, t));
        s = "a";
        t = "a";
        System.out.println(isAnagram(s, t));
        s="ab";
        t = "a";
        System.out.println(isAnagram(s, t));
    }
}
