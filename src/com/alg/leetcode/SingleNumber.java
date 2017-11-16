/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* 
* 
 * @author rbaral
 */
import java.util.Map;
import java.util.HashMap;
 
public class SingleNumber {
    
	static int singleNumber(int[] a){
		//simple solution is using HashMap to store the count
		Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();
		for(int b: a){
			if(countMap.containsKey(b)){
				countMap.put(Integer.valueOf(b),2);
			}else{
				countMap.put(Integer.valueOf(b),1);
			}
		}
		int num = 0;
		for(Integer b:countMap.keySet()){
			if(countMap.get(b)==1){
				num = b;
				break;
			}
		}
		return num;
	}
        
        /**
         * For instance, if your array contains the elements [3, 4, 5, 3, 4], the algorithm will return

            3 ^ 4 ^ 5 ^ 3 ^ 4

            But the XOR operator ^ is associative and commutative, so the result will be also equal to:

            (3 ^ 3) ^ (4 ^ 4) ^ 5

            Since i ^ i = 0 for any integer i, and i ^ 0 = i, you have

            (3 ^ 3) ^ (4 ^ 4) ^ 5 = 0 ^ 0 ^ 5 = 5
            * 
         * @param a
         * @return 
         */
        static int singleNumberLinear(int[] a){
            int result = 0;
            for (int i: a){
                result ^= i;
            }
            return result;
        }
	
	public static void main(String args[]){
		int[] arr = {1,2,1,3,5,4,5,3,4};
		//System.out.println(singleNumber(arr));
                System.out.println(singleNumberLinear(arr));
	}
}
