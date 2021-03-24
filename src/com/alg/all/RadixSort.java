/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

import java.util.Arrays;

/**
 *Ref:https://en.wikipedia.org/wiki/Radix_sort
 * 
 * NOTE:
 * 
 * This is a non-comparative sort
 * 
 * 
 * Best Case: O(wn)
 * Worst case: O(wn)
 * 
 * Space: O(w+N)
 * 
 * REF: http://www.geeksforgeeks.org/radix-sort/
 */
public class RadixSort {
 
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[])
    {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int digit)
    {
        int output[] = new int[arr.length]; // output array
        int count[] = new int[10];
        
        // Store count of occurrences of the number at this exp in arr[]
        for (int i = 0; i < arr.length; i++)
            count[(arr[i]/digit)%10 ]++;
 
        /**
         * update count[i] so that it contains the count
         * of numbers less than count[i]. For e.g., count[5] contains the count of
         * numbers till 5.
         */
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/digit)%10 ] - 1] = arr[i];
            count[ (arr[i]/digit)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[])
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10){
            countSort(arr, exp);
            System.out.println("sorted is:"+Arrays.toString(arr));
        }
            
    }
 
    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66, 1};
        radixsort(arr);
    }
}

