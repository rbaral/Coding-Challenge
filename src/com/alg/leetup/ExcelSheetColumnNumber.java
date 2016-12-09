/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    
    * 
    * 
    * Solution 1:
    * 1) for a single character string just return the value of Integer.valueOf(character) - Integer.valueOf('A')+1
    * 2) for other cases do the following
    * a) scan from the right and apply the 26*(Integer.valueOf(character) - Integer.valueOf('A')+1) for every characters other than the rightmost one
    * b) the rightmost one takes the value as we used in the single character
 * @author rbaral
 */
public class ExcelSheetColumnNumber {
    static int titleToNumber(String s) {
        //handle single letter case
        int num = 0;
        for(int i=0; i<s.length();i++){
            num+= (s.charAt(i) - 'A' + 1)*Math.pow(26, s.length() - 1 -i);
        }
        return num;
    }
    
    public static void main(String args[]){
        String a = "A";
        System.out.println(titleToNumber(a));
        a ="AB";
        System.out.println(titleToNumber(a));
        a ="AAA";
        System.out.println(titleToNumber(a));
        
    }
}
