/*
given two numbers in ternary (0,1,2) representation, write a method to add the two numbers
 */
package com.alg.realtest;

/**
 *
 * @author rbaral
 */
public class TernaryAddition {
    
    public static String getTernarySum(String num1, String num2){
        //make sure that both strings are of same length, this makes addition easier
        int len1 = num1.length();
        int len2 = num2.length();
        while(len1<len2){
            num1 = "0"+num1;
            len1 = num1.length();
        }
        while(len2<len1){
            num2 = "0"+num2;
            len2 = num2.length();
        }
        StringBuffer terSum = new StringBuffer();
        //we start finding sum from the right and take the carry to the left
        int carry = 0;
        int sum = 0;
        int rem = 0;
        for(int i= num1.length()-1; i>=0; i--){
            sum = carry + Integer.parseInt(String.valueOf(num2.charAt(i))) + Integer.parseInt(String.valueOf(num1.charAt(i)));
            rem = sum%3;
            carry = sum/3;
            System.out.println(sum+","+rem+","+carry+","+terSum.toString());
            terSum.insert(0, rem);
            
        }
        return terSum.toString();
    }
    
    public static void main(String [] args){
        String num1 = "011221";
        String num2 = "1211";
        String sum = getTernarySum(num1, num2);
        System.out.println("ternary sum is:"+sum);
    }
}
