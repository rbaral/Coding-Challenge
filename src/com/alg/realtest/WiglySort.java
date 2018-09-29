/*
Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. 
A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, 
leaving the remaining elements in their original order.
 */
package com.alg.realtest;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class WiglySort {
    /**
     * the wiggle is an increase and then decrease or it can be a decrease and then increase
     * for instance, 10,2,5,3,15,9 is decreasing first and increasing and so on
     * 2, 10, 7, 8, 3, 12 is increasing first and decreasing and so on.
     * For every item in the array, we check the longest wiggle we can achieve and return 
     * the longest among them
     * @param arr
     * @return 
     */
    public static int getLongestWiggleLength(int[] arr){
        int maxlength = 1;
        int j=0;
        for(int i=1;i<arr.length; i++){
            //first increasing and then decreasing
            if(arr[j]<arr[i]){
                maxlength++;
                while(i<arr.length-1 && arr[i]<=arr[i+1]){
                    i++;
                }
            }else if(arr[j]>arr[i]){//first decreasing and then increasing
                maxlength++;
                while(i<arr.length-1 && arr[i]>=arr[i+1]){
                    i++;
                }
            }
            
            j = i-1;
        }
        return maxlength;
    }
    
    /**
     * given an array, we return the wiggly sorted form of the array
     * -first sort the entire array
     * - use two pointers p1 set to 0 and p2 set to 1
     * -iterate over the elements of sorted array, at each iteration, advance p1 and p2 by 2
     * -store the items pointed by p1 and p2 to the array
     * 
     * @param arr 
     */
    public static int[] sortWiggle(int[] arr){
        int p1 = 0, p2 = arr.length-1;
        Arrays.sort(arr);
        System.out.println("sorted is:"+Arrays.toString(arr));
        int[] sorted = new int[arr.length];
        for(int i=1;i<arr.length && p1<arr.length &&p2>=0; i+=2){
            sorted[i-1] = arr[p1];
            sorted[i] = arr[p2];
            p1++;
            p2--;
        }
        return sorted;
    }
    public static void main(String args[]){
        int[] arr = {1, 3, 9, 12, 6, 0, 15, 11};
        System.out.println("original array:"+Arrays.toString(arr));
        System.out.println("longest wiggle length:"+getLongestWiggleLength(arr));
        System.out.println("wiggle sorted:"+Arrays.toString(sortWiggle(arr)));
    }
}
