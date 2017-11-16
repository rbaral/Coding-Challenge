/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * 
 * NOTES:
 * 1) the approach is to get maximum sum from the array without having adjacent indices considered in the sum
 * 2) as each number is non-negative and we don't have any constraint on the number of houses, we can include as many non-adjacent
 * houses as possible.
 * 
 * 
 * Solution 1:
 * 1)Scan the array by ignoring the next element and accumulate the sum for every possible start index
 * a) start at 0, ignore 1, take 2 and so on
 * b) start at 1, ignore 2, and so on
 * c) we don't need to check from the 3rd index as this will exclude the 0th index
 * 2) keep track of the maximum sum so far
 * 
 * Complexity: O(n^2)
 * 
 * Solution 2:
 * 1)Use two pointers, start and end
 * 2)if the size of array is odd, start will be at 0 and end will be at length-1, else the end will be length-2
 * 2 a) adavnce start and decrease end by two
 * 2 b) take the sum of the elements at start and end index
 * 2 c) stop when both start and end are same
 * 3)return the maximum sum
 * 
 * Complexity: O(logn)
 * 

 * 
 * @author rbaral
 */
public class HouseRobber {
    
}
