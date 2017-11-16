/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * 
 * @author rbaral
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        String totalSum = "";
        int sum = 0, carry = 0;
        int num2Index = num2.length()-1;
        int num1Index = num1.length()-1;
        for(num1Index=num1.length()-1; num1Index>=0;num1Index--){
            sum = 0;
            if(num2Index>=0){//till there are chars in both strings
                sum = num1.charAt(num1Index) -'0' + num2.charAt(num2Index)-'0' + carry;
                num2Index--;
                if(sum>9){
                    carry = 1;
                    sum = sum - 10;
                }else{
                    carry = 0;
                }
                totalSum= sum + totalSum;
            }else
                break;
            
        }
        //if the num1 is exhausted and num2 has some chars
        if(num2Index>=0){
            //simply add the remaining portion of num2 with the carry and append to the totalSum so far
            num2 = num2.substring(0, num2Index+1);
            for(int i = num2.length()-1; i>=0;i--){
                sum = num2.charAt(i) - '0' + carry;
                if(sum>9){
                    carry = 1;
                    sum = sum - 10;
                    totalSum = sum + totalSum;
                }else{
                    //simply append the sum to the remaining chars of num2 and break
                    totalSum= sum +totalSum;
                    carry = 0;
                    
                }
            }
        }else if(num1Index>=0){
           num1 = num1.substring(0, num1Index+1);
            System.out.println("remaining num1:"+num1+" sum "+totalSum+" cary "+carry);
           for(int i= num1.length()-1;i>=0;i--){
               sum = num1.charAt(i) - '0' + carry;
               
               if(sum>9){
                   carry = 1;
                   sum = sum -10;
                   totalSum= sum + totalSum;
               }else{
                   totalSum= sum +totalSum;
                   carry = 0;
                   
               }
           }
        }
        if(carry>0){
            totalSum = carry+totalSum;
        }
        return totalSum;
    }
    
    public static void main(String args[]){
        String num1 = "19";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
        System.out.println(addStrings("0", "0"));
        System.out.println(addStrings("99", "99"));
        System.out.println(addStrings("6994", "36"));
        
    }
     
}
