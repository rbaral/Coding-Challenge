/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 *
 * Product of Array Except Self   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 74332
Total Submissions: 159264
Difficulty: Medium
Contributors: Admin
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
* 
* The easiest solution is to find the product of all the elements and divide this product with the value
* in the corresponding index, but we are not allowed to divide so this solution is not valid here.
* 
* Solution 1:
* 1)declare two additional arrays left and right which are of same size as the input array
* 2)In left array, the value stored in an index is the product of all elements on left of it except the current index
* (we accumulate the product from left in O(n) time)
* 3)Similar to (2) populate the right array which holds the product of elements on the right of an element
* 4)find the product of right[index]*left[index] as the final result
* 
* Complexity: O(n); Space O(2n)
* 
* 
* Solution 2: Use a single array to keep track of the left and right product
* 
* Complexity: O(n); Space: O(1) as output array is not counted
* 
* 
* 
 * 
 * 
 * @author rbaral
 */
public class ProductOfArrayExceptSelf {
   public static int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        //initialize all 1s
        for(int i=0;i<prod.length;i++)
            prod[i]=1;
        //now accumulate the product from left
        int temp = 1; //a temporary variable to hold the product of all numbers on left
        for(int i=0;i<nums.length;i++){
            prod[i] = temp;
            temp = temp * nums[i]; //update the product of the left portion for next index
        }
        System.out.println("after left prod:"+Arrays.toString(prod));
        //now accumulate the product from right and update in the prod array itself
        temp =1; //reset the product from right so far
        for(int i=nums.length-1;i>=0;i--){
            prod[i] = prod[i]*temp;
            temp*=nums[i];
        }
        return prod;
    }
   
   public static void main(String args[]){
       int[] nums = {1,2,3,4};
       System.out.println(Arrays.toString(productExceptSelf(nums)));
   }
}
