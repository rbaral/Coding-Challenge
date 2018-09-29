/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;

/**
 *
 * @author rbaral
 *
 * Given a target sum, populate all subsets, whose sum is equal to the target
 * sum, from an int array. For example:
 *
 * Target sum is 15.
 *
 * An int array is { 1, 3, 4, 5, 6, 15 }.
 *
 * Then all satisfied subsets whose sum is 15 are as follows:
 *
 * 15 = 1+3+5+6; 15 = 4+5+6 ; 15 = 15
 * 
 * Solution:
 * 1)sort the array
 * 2)recursively check if there is a sum for target-current_element
 * 
 * Complexity: O(n^2)
 *
 */
public class SubsetSum {

    public static void populateSubset(int[] data, int fromIndex,
            int[] stack, int stacklen, int target) {
        if (target == 0) {
            // exact match of our target. Success!
            printResult(Arrays.copyOf(stack, stacklen));
            return;
        }

        
        while (fromIndex < data.length && data[fromIndex] > target) {
            // take advantage of sorted data.
            // we can skip all values that are too large.
            fromIndex++;
        }
        

        while (fromIndex < data.length && data[fromIndex] <= target) {
            // stop looping when we run out of data, or when we overflow our target.
            stack[stacklen] = data[fromIndex];
            populateSubset(data, fromIndex + 1, stack, stacklen + 1, target - data[fromIndex]);
            fromIndex++;
        }
    }
    
    public static void printResult(int[] arr){
        //System.out.println("");
        for(int i:arr){
            System.out.print(" "+i);
        }
        System.out.println("");
    }
    
    public static void main(String args[]){
        int[] data = { 1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13,
        14, 15 };
        //Arrays.sort(data); 
        //populateSubset(data, 0, new int[data.length], 0, 15);
        data = new int[]{1,2,3,4,8,12,15};
        Arrays.sort(data);
        populateSubset(data, 0, new int[data.length], 0, 15);
    }
}
