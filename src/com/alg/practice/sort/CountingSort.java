/*
we count the occurences of numbers in the given array and do the sorting by counting
the numbers less than the elements
 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class CountingSort {

    public static int[] sortItems(int[] arr, int maxRange) {
        //counting phase-count the occurences of each element and store in the count array
        int[] count = new int[maxRange + 1];
        //store the count of each element
        for(int i=0;i<arr.length; i++){
            count[arr[i]]++;
        }
        //update the count to store the count of elements till any item
        for(int i=1;i<count.length; i++){
            count[i]+=count[i-1];
        }
        //create the output array where the result will be stored
        int[] output = new int[arr.length];
        //store the items in the index defined by their count value
        for(int i=arr.length-1; i>=0; i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        return output;
    }

    public static void main(String args[]) {
        int[] a = {1, 3, 9, 1, 5, 2, 12, 15, 4, 6};
        System.out.println("Unsorted: " + Arrays.toString(a));
        int maxRange = 15; // assume that the elements are in the range 0 to k
        int[] sorted = sortItems(a, maxRange);
        System.out.println("Sorted: " + Arrays.toString(sorted));

    }
}
