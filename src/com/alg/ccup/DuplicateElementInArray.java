/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;

/**
 * Write an algorithm that returns any duplicate in an array of integers. 
 * The algorithm must run in O(n) time and O(1) space. 
 * (hint: the integers in the array are not greater than the size of the array).
 *
 * Solution 1:
 * 1)Use linear sorting algorithms like counting sort to sort the elements of the array.
 * As there are n elements in the array and the integers are not greater than the size of the array,
 * we can get O(n+n) sorting time.
 * 2)Scan from the beginning and compare adjacent elements to keep track of duplicates
 * 
 * Complexity: O(n); O(1)
 * 
 * Solution 2:
 * 1)Use hash to store the count of the elements
 * 2)keep track of elements with count>1
 * 
 * Complexity: O(n); O(n)
 * 
 * 
 * Solution 3:
 * 1)This works for positive numbers only. As the number of elements is not greater than the size of the array,
 * create an array to keep track of the count of numbers, e.g., arr[0] will record the count of 0s and so on.
 * 2)Scan this array to find the elements with count>1
 * 
 * Complexity: O(n); O(n)
 * 
 * 
 * @author rbaral
 */
public class DuplicateElementInArray {
    
    static void repeatedArray(int [] arr,int len)
    {
        int i=0;
        for(i=0;i<len;i++)
        {
            int k = Math.abs(arr[i]);
            if(arr[k]>=0){
                arr[k] = -arr[k];
            }else{
                System.out.println("Array so far:"+Arrays.toString(arr)+" i is:"+i+" k is:"+k);
                System.out.println(Math.abs(arr[i]));
            }
        }
        
    }
    
    public static void main(String args[]){
        int nums[] = {-1, 2, 3, 2, 3,5};
        repeatedArray(nums, nums.length);
    }
}
