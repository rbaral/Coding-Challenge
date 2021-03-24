/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * @author rbaral
 */
public class StringReverse {
    public static String reverseString(String s) {
        StringBuffer rev = new StringBuffer();
        for(int i=s.length()-1; i>=0;i--){
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
    
    public static void main(String args[]){
        String a ="hello";
		System.out.println(a);
		System.out.println(reverseString(a));
    }
}
