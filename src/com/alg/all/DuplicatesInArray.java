/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * 
 * 
 * Solution 1:
 * 1)User hashmap to track the element and its count
 * 2)return the element with count one
 * 
 * Complexity: O(n), Space: O(n)
 * 
 * Solution 2:
 * 1)Scan the array and for every element
 * 1 a) if the array at  this position is negative, add it to the result
 * 1 b) if not, make the array element at this position negative
 * 2)return the numbers in result
 * 
 * NOTE:
 * This works because we are given that the numbers range from 1 to n and there is no negative number
 * 
 * Complexity: O(n), Space: O(1)
 * 
 */
public class DuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(Integer n:nums){
            if(nums[Math.abs(n)-1]<0){ //if it was already changed, then the index was already encountered so its a duplicate
                res.add(Math.abs(n));
            }else{
                nums[Math.abs(n)-1]*=-1;
            }
        }
        return res;  
        
    }
    
    public static void main(String args[]){
        int a[] = {1,2,2,4,3,3};
        List<Integer> res = findDuplicates(a);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
