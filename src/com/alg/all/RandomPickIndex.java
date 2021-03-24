/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author rbara012
 * 

Given an array of integers with possible duplicates, randomly output the index of a given target number. 
* You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
* 
* Solution 1:
* 1)Sort the array
* 2)record the starting and ending index of the target element
* 3 a) if the starting and ending index is same, return the index
* 3 b) if the element occurred many times, generate a random number in the range of the indices of the target element and return it
* 
* Complexity: O(nlogn) to sort and O(n) to find the index of the element and complexity to generate a random number in the range
 * 
 */
public class RandomPickIndex {
    int[] arr;
    public RandomPickIndex(int[] nums) {
        arr = nums;
        //sort the array
        Arrays.sort(arr);
    }
    
    public int pick(int target) {
        //lets search the element and find the starting and ending indices
        int begin = -1, end = -1;
        for(int i=0;i<arr.length;i++){
            if(begin==-1 && arr[i]==target){
                begin = i;
                end = i;
            }
            if(arr[i]==target){
                end = i;
            }else if(begin!=-1){
                break;
            }
        }
        System.out.println("begin is:"+begin+" end is:"+end);
        if(begin==end)
            return begin; //no need to generate random value
        return randInt(begin, end);
    }
    
    public static int randInt(int min, int max){
        Random rand = new Random();
        return min + rand.nextInt((max-min)+1);
    }
    
    public static void main(String args[]){
        int[] nums = new int[] {1,2,3,3,3};
        RandomPickIndex randomPick = new RandomPickIndex(nums);
        System.out.println(randomPick.pick(3));
    }
}
