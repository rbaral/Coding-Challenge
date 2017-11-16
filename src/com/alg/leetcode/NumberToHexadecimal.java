/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.Arrays;

/**
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. 
 * For negative integer, two’s complement method is used. (Ref:https://en.wikipedia.org/wiki/Two%27s_complement)

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character 
* '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.

* 
* Example 1:

Input:
26

Output:
"1a"
* 
* 
Example 2:

Input:
-1

Output:
"ffffffff"
 * 
 * 
 * 
 * @author rbaral
 */
public class NumberToHexadecimal {
    
    public static String toHex(int num) {
        String hex = "";
        if(num<0){
            //large numbers cannot be converted to positive simply multiplying by 1 so we use long instead
            String veryLargeNum = ""+num;
            
            Long num1 = Long.parseLong(veryLargeNum.substring(1));
            
            return handleNegativeNumbers(num1);
        }
        else if(num>=0 && num<=9){
            return ""+num;
        }else if(num<=15){
            return getHexValue(num);
        }else{
            hex = toHex(num/16)+ toHex(num%16);
        }
        return hex;
    }
    //performs the binary addition of two binary numbers
    static String binaryAddition(String num1, String num2){
        //if two strings are of different length, make them of equal length by appending zeros
        System.out.println("adding two binaries "+num1+".."+num2);
        int length1 = num1.length();
        int length2 = num2.length();
        if(length1<length2){
            for(int i=0;i<length2-length1;i++){
                num1 = "0"+num1;
            }
        }else if(length2<length1){
            for(int i=0;i<length1-length2;i++){
                num2 = "0"+num2;
            }
        }
        //System.out.println("adding two binaries "+num1+".."+num2);
        int length = num1.length(); //both are of equal length
        int carry = 0, sum = 0;
        String result = "";
        for(int i = length-1; i>=0; i--){
            int char1 = num1.charAt(i) - '0';
            int char2 = num2.charAt(i) - '0';
            sum = (char1 ^ char2 ^ carry)+ '0';
            result = (char)sum + result;
            //handle the carry
            carry = (char1 & char2) | (char2 & carry) | (char1 & carry);
        }
        //handle overflow
        if(carry==1){
            result = '1' + result;
        }
        return result;
    }
    static String handleNegativeNumbers(long num){
        System.out.println("handling number "+num);
        String binary = toBinary(num);//convert to binary
        
        //make sure it is a 8 digit or 16 digit or 32 digit char
        int maxChar = 8;
        if(num<Math.pow(2,8))
            maxChar = 8;
        else if(num<Math.pow(2,16))
            maxChar = 16;
        else
            maxChar = 32;
        System.out.println("appending zeros "+maxChar+" for num:"+num);
        int appendZeroCounts = maxChar - binary.length() ;
        for(int i=0;i<appendZeroCounts;i++){
            binary = "0"+binary;
        }
        
        //flip the chars - all zeros get to 1 and ones get to 0
        StringBuilder bb = new StringBuilder(binary);
        for(int i=0;i<bb.length();i++){
            if(bb.charAt(i)=='1')
                bb.setCharAt(i, '0');
            else
                bb.setCharAt(i, '1');
        }
        binary = bb.toString();
        System.out.println("ones complement is: "+binary);
        //add binary 1 to it
        binary = binaryAddition(binary, "1");
        System.out.println("after addition:"+binary);
        //now convert this binary to hex
        //we use every four binary digits to get a hexadecimal value
        bb = new StringBuilder(binary);
        binary = "";
        for(int i=0;i+4<=bb.length();i+=4){
            //System.out.println("getting binary to dec for "+bb.substring(i, i+4));
            binary = binary + binaryToHex(bb.substring(i, i+4));
        }
        //binary = toHex(dec);

        appendZeroCounts = 8 - binary.length() ;
        for(int i=0;i<appendZeroCounts;i++){
            binary = "f"+binary;
        }
        
        //binary = toHex(dec);
        //System.out.println("hex is:"+binary);
        return binary;
    }
    
    //converts a binary string to a decimal
    static String binaryToHex(String num){
        //System.out.println("getting binary to decimal of "+num);
        int dec = 0;
        for(int i=num.length()-1;i>=0;i--){
           dec+=Math.pow(2, num.length()- i -1)*(num.charAt(i) - '0'); 
        }
        return toHex(dec);
    }
    
    static String getHexValue(int num){
        String hex = "fedcba"; //get the chars from index (num -15)
        return ""+hex.charAt(15-num);
    }
    
    static String toBinary(long num){
        if(num<=1){
            return ""+num;
        }
        return toBinary(num/2) + toBinary(num%2);
    }
    
    public static void main(String args[]){
        int num = 39;
        System.out.println(toHex(num));
        //System.out.println(binaryAddition("11", "1"));
        System.out.println(toHex(-200000));
        //System.out.println(toHex(-2147483648));
    }
}
