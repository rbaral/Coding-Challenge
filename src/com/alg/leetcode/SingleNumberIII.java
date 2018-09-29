/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 *
 * @author rbara012
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
* 
* 
* Solution 1:
* As there are only two out of n element which are not repeated, if we record the count, we will use almost n space
* 1)We can store the element and its count in hash
* 3) return the element with count 1
* 
* Complexity: O(n), Space: O(n)
* 
* Solution 2:
* Ref: https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations/2
* 
* Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:
If we call the two numbers that we need to find is A and B. We all know that if we XOR all the elements in the provided array, we will get A ^ B. This is a lot of information!
In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. 
* Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementioned bit unset. 
* Two different numbers we need to find must fall into the two distinct groups. XOR numbers in each group, we can find a number in either group.
 * 
 */
public class SingleNumberIII {
   public static int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    } 
   
   public static void main(String args[]){
       int[] arr = {1, 2, 1, 3, 5, 4, 5, 3, 4, 6};
        //System.out.println(singleNumber(arr));
        System.out.println(Arrays.toString(singleNumber(arr)));
   }
}
