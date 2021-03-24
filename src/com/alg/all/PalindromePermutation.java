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
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
Understand the problem:
The problem can be easily solved by count the frequency of each character using a hash map. 
The only thing need to take special care is consider the length of the string to be even or odd. 
  -- If the length is even. Each character should appear exactly times of 2, e.g. 2, 4, 6, etc..
  -- If the length is odd. One and only one character could appear odd times. 
 * 
 * 
 */
public class PalindromePermutation {
    
    /**
     * we create a map and store the count of each character
     * 1)if each character has even occurences, then the string can be formed a palindrome
     * 2)if there is only one character with odd occurrence and rest as even, the string can be formed palindrome
     * 
     * NOTE: if only alphabet characters are present, then we can use an array. But we don't know in this problem
     * if the input string is alphanumeric or even other symbols are there, so we use a hashmap.
     * 
     * @param s
     * @return 
     */
    public static boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> counts = new HashMap<Character,Integer>(); 
        //handle base cases
        if(s==null){
            return false;
        }
        else if(s.length()<=1){
            return true; //empty string is also a palindrome
        }else{
            int p1 = 0, p2 = chars.length-1;
            while(p1<=p2){
                if(p1==p2){
                    counts.put(chars[p1], counts.getOrDefault(chars[p1], 0)+1);
                }else{
                    counts.put(chars[p1], counts.getOrDefault(chars[p1], 0)+1);
                    counts.put(chars[p2], counts.getOrDefault(chars[p2], 0)+1);
                }
                p1++;
                p2--;
            }
            //now find the number of elements with odd count and number of elements with even counts
            int evens = 0, odds = 0;
            for(Character c:counts.keySet()){
                if(counts.get(c)%2==0){
                    evens++;
                }else{
                    odds++;
                }
            }
            if(odds<=1){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        String a = "code";
        System.out.println("is perm:"+canPermutePalindrome(a));
        a="aab";
        System.out.println("is perm:"+canPermutePalindrome(a));
        a="carerac";
        System.out.println("is perm:"+canPermutePalindrome(a));
        a="accba";
        System.out.println("is perm:"+canPermutePalindrome(a));
        a="eye";
        System.out.println("is perm:"+canPermutePalindrome(a));
    }
    
}
