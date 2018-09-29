/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Arrays;
import java.util.Stack;

/**
 * given a string of characters, find the first recurring character. E.g.,
 * input: ABCA, the first recurring character is A, you should return A input:
 * DABAB, there are two recurring characters, A, and B. The first recurring is
 * A, so you return A. input: ABC, ther is no recurring character, so return
 * null or empty string.
 *
 *
 * Soln: Sol 1) we can use two nested loops and find the first recurring
 * character. Complexity: O(n^2).
 *
 * We can do better!
 *
 * Sol 2) Sort the given string, and iteratively check if there is a duplicate.
 * Store the duplicate char and its index in original string array in a cache.
 * If a new duplicate with smaller index is found, replace the old one. Return a
 * duplicate character left in the cache.
 *
 * Complexity; O(nlogn) + O(n^2)
 *
 * Sol 3) Use hash to store the count of each char and when the char is already in hash, we
 * already found the duplicate.
 *
 * complexity: O(n), space: O(n)
 */
public class FirstRecurringChar {

    public static String findRecurChar1(String s) {
        //two nested loops
        String dup = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return "" + s.charAt(i);
                }
            }
        }
        return dup;

    }
    
    public static String findRecurChar2(String s){
        //sort the string and check if there is a duplicate
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int dupIndex = s.length();
        String dup ="";
        for(int i=1;i<chars.length; i++){
            //check consecutive elements
            if(chars[i]==chars[i-1]){
                //check the index of this char in the original string
                int index = s.indexOf(chars[i]);
                if(dupIndex> index)
                    dupIndex = index;
            }
        }
        dup = dupIndex>s.length()-1?"":s.charAt(dupIndex)+"";
        return dup;
    }

    public static void main(String args[]) {
        String s1 = "ABCAB";
        String s2 = "EABCDA";
        String s3 = "EFBCDA";
        String dup = "";
        dup = findRecurChar1(s1);
        System.out.println("First dup in:" + s1 + " is:" + dup);
        dup = findRecurChar1(s2);
        System.out.println("First dup in:" + s2 + " is:" + dup);
        dup = findRecurChar1(s3);
        System.out.println("First dup in:" + s3 + " is:" + dup);
        
        dup = findRecurChar2(s1);
        System.out.println("First dup in:" + s1 + " is:" + dup);
        dup = findRecurChar2(s2);
        System.out.println("First dup in:" + s2 + " is:" + dup);
        dup = findRecurChar2(s3);
        System.out.println("First dup in:" + s3 + " is:" + dup);

    }

}
