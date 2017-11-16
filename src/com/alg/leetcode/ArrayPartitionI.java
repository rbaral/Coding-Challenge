/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 */
package com.alg.leetcode;

import java.util.Arrays;

/**
 *
 * @author rbaral
 * 
 * 
 * Solution 1:
 * 1) sort the given array
 * 2) pair the consecutive numbers from the beginning of the sorted array, i.e. num_1,num_2 will be in a pair, num_3,num_4 will be in another pair, and so on.
 * 
 * Complexity: O(logn) for sorting, O(n/2) for pairing and summing
 */
public class ArrayPartitionI {
     
    public static int arrayPairSum(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        //now form the pairs and find the sum
        int sum = 0;
        for(int i =0;i<nums.length; i+=2){//find the sum of the elements that are min in every pair
            sum+=nums[i];
        }
        return sum;
    }
}
