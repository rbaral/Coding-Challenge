/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of 
* the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a 
* cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* 
* 
* Solution 1:
* 1)recursively perform the squaring of its digits and save the sum in a hash
* 2)if the entry in hash is already generated then it is a cycle so break
* 
* Complexity is: O(logn)
* 
 * @author rbaral
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        if(n<1){
            return false;
        }
        else if(n==1){
            return true;
        }else{
            Map<Integer,Integer> nums = new HashMap<Integer,Integer>();
            int sum = n;
            while(true){
                sum = isHappyNumber(String.valueOf(sum));
                if(nums.containsKey(sum)){
                    return false;
                }else if(sum==1){
                    return true;
                }else{
                    nums.put(sum, sum);
                }
            }
        }
            
    }
    
    static int isHappyNumber(String num){
        //System.out.println("finding sum for:"+num);
        int sum = 0;
        int index = 0;
        while(index<num.length()){
            sum+= (num.charAt(index)-'0')*(num.charAt(index)-'0');
            index++;
        }
        //System.out.println("sum returned was:"+sum);
        return sum;
    }
    
    public static void main(String args[]){
        System.out.println(isHappy(19));
        System.out.println(isHappy(1));
    }
}
