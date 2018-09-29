/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
* Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
* 
* 
* Solution 1:
* 1)use two nested loops and check if the sum is equal to target
* 
* Complexity: O(n^2)
* 
* 
* Solution 2:
* 1)Use two pointers p1 pointing to the start and p2 pointing to the end of the array
* 2)find the sum of the elements at index p1 and p2
* 2 a)If the sum is equal to the target, return p1 and p2
* 2 b)If the sum is less than target, then advance p1 (because larger elements will be on the right of the array)
* 2 c) If the sum is greater than target, then decrease p2 (because smaller elements will be on left of the array)
* 3)Repeat (2) till we have p1<p2
* 4)Return false, as we didn't found the sum
 * 
 * Complexity: O(n)
 * 
 * @author rbaral
 */
public class TwoSumII {
    
    public static int[] twoSum(int[] numbers, int target) {
        //handle base cases
        int indices[] = new int[2];
        indices[0] = -1; indices[1] = -1;
        int p1 = 0, p2 = numbers.length-1;
        if(numbers.length<2){
            return indices;
        }else{
            int sum;
            while(p1<p2){
                sum = numbers[p1]+ numbers[p2];
                if(sum == target){
                    indices[0] = p1+1; //indices are non zero based
                    indices[1] = p2+1;
                    return indices;
                }else if(sum<target){
                    p1++;
                }else{
                    p2--;
                }
            }
        }
        return indices;
    }
    
    public static void main(String args[]){
        int[] nums = {2,3,4};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
