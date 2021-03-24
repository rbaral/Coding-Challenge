/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 *
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
* 
 * 
 * Solution 1:
 * 1)Create another array of same size
 * 2)if k>0, copy k elements from last to the new array
 * 3) copy the elements from beginning till we reach the index that was already copied to the new array
 * 4) return the new array
 * 
 * Complexity: O(n); Space O(n)
 * 
 * 
 * Solution 2:
 * 
 * 1)Start from the last element of the array and switch every adjacent element till we reach the front
 * 2)this will bring the last element to the front of the array
 * If we need to rotate k times, this will take O(nk) time; O(1)
 * 
 * 
 * Solution 3:
 * 1)Reverse all the elements of the array (can use two pointers p1 at index 0 and p2 at index array.length-1 and swap the elements at those indices;
 * advance the pointers and repeat the process till the two pointers dont meet)
 * 2)Now reverse only the first k elements of the array
 * 3)Now reverse only the last n-k elements of the array
 * 4)the final result will be in the original array
 * 
 * Complexity: O(n); space O(1)
 * 
 * @author rbaral
 */
public class RotateAnArray {
    
    public static void rotate(int[] nums, int k) {
        //base case
        if(k>nums.length){//when we rotate nums.length times, we get the same array, so we just need to rotate k-nums.length times
            k = k%nums.length;
        }
        if(nums.length<=1 || k <1){
            return;
        }
        if(nums.length==k){//rotating k elements means again getting back the same array
            return;
        }
        
        //reverse all the elements of the array
        //we use two pointers to get the reverse
        int p1 = 0;
        int p2 = nums.length-1;
        int temp;
        while(p1<p2){
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
        System.out.println("after reversing all:"+Arrays.toString(nums));
        //reverse the first k elements fo the array or until the array gets exhausted
        p1 = 0;
        p2 = k<nums.length?(k-1):nums.length-1;
        while(p1<p2){
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
        System.out.println("after reversing first k="+k+" elements:"+Arrays.toString(nums));
        //reverse the last n-k elements of the array or until the array gets exhausted
        p2 = nums.length-1;
        p1 = k<nums.length?k:0;
        while(p1<p2){
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
    }
    
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        nums = new int[] {1, 2};
        k = 8;
        System.out.println("original: "+Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("final: "+Arrays.toString(nums));
    }
}
