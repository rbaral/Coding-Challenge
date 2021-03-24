/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class CheckStringPermutation {
    
    /***
     * sorts the string by the characters
     * @param a
     * @return 
     */
    static String sortString(String a){
        char[] charInString = a.toCharArray();
        Arrays.sort(charInString);
        return String.valueOf(charInString);
    }
    
    /**
     * just check if the two strings have same set of characters or not
     * @param a
     * @param b
     * @return 
     */
    static boolean isPermutation_1(String a, String b){
        //get the sorted format of a string
        String sorted_A = sortString(a);
        String sorted_B = sortString(b);
        return sorted_A.equals(sorted_B);
    }
    
    /**
     * just check if both of them have same count for a char
     * @param a
     * @param b
     * @return 
     */
    static boolean isPermutation_2(String a, String b){
        boolean isPermutation = true;
        //lets store every char in an array of boolean
        int[] charCount = new int[256];
        for(char c:a.toCharArray()){
            charCount[c]++;
        }
        //now verify the count in another string and subtract the count
        for(char c:b.toCharArray()){
            charCount[c]--;
        }
        //now check if any count is non-zero then the two string have unequal count of that char
        for(int i=0;i<charCount.length;i++)
            if(charCount[i]!=0)
                return false;
        
        return isPermutation;
    }
    
    public static void main(String args[]){
        String a ="god";
        String b = "odg";
        System.out.println("method 1:"+isPermutation_1(a,b));
        System.out.println("method 2:"+isPermutation_2(a,b));
    }
}
