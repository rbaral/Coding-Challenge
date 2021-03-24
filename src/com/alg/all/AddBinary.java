/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
* 
* Solution 1:
* 1)pad 0s at front of shorter number to have them of equal length
* 2)Iterate from the end of the numbers and add them and handle the carry
* 3) sum will be (the sum of carry and the character's at this position) %2
* 4) carry will be (the sum of carry and the character's at this position) /2
* 
* Solution 2:
* Using bitwise operator
* 1) sum = char of a XOR char of b XOR carry
* 2) carry = (cahr of a & carry) XOR (char of b & carry) XOR (char of a & char of b)
* 
 *
 * 
 * @author rbaral
 */
public class AddBinary {
    
    public static String addBinary1(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        //lets pad if one is shorter than another
        if(len1<len2){
            int diff = len2 - len1;
            while(diff>0){
                a = "0"+a;
                diff--;
            }
        }
        if(len2<len1){
            int diff = len1 - len2;
            while(diff>0){
                b = "0"+b;
                diff--;
            }
        }
        //after padding, we find the sum from the last digit
        int carry =0, sum;
        String totalSum="";
        for(int i= a.length()-1;i>=0;i--){
            sum = (a.charAt(i)-'0')+(b.charAt(i)-'0')+carry; 
            carry = sum/2;
            sum = sum%2;
            totalSum = sum+totalSum;
        }
        if(carry>0)
            totalSum = carry+totalSum;
        return totalSum;
    }
    
    static String addBinary(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        //lets pad if one is shorter than another
        if(len1<len2){
            int diff = len2 - len1;
            while(diff>0){
                a = "0"+a;
                diff--;
            }
        }
        if(len2<len1){
            int diff = len1 - len2;
            while(diff>0){
                b = "0"+b;
                diff--;
            }
        }
        //after padding, we find the sum from the last digit
        int carry =0, sum;
        String totalSum="";
        for(int i= a.length()-1; i>=0;i--){
            sum = a.charAt(i)-'0' ^ b.charAt(i)-'0' ^ carry;
            System.out.println("sum of "+a.charAt(i)+" "+b.charAt(i)+" "+carry+" is "+sum);
            carry = ((a.charAt(i)-'0') & (b.charAt(i)-'0'))^((a.charAt(i)-'0') & carry) ^((b.charAt(i)-'0') & carry);
            System.out.println("carry is:"+carry);
            totalSum = sum + totalSum;
        }
        if(carry>0)
            totalSum = carry + totalSum;
        
        return totalSum;
    }
    
    public static void main(String args[]){
        System.out.println(addBinary("101", "11"));
    }
}
