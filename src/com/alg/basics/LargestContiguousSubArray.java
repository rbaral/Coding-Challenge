/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 *You are given an array of integers (both positive and negative). Find the contiguous
sequence with the largest sum. Return the sum.
* 
 * @author rbaral
 */
public class LargestContiguousSubArray {
    
    static int maxSum1(int [] a){
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for(int i=0;i<a.length;i++){
            maxEndingHere = maxEndingHere + a[i];
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }
    
    /**
     * we keep track of the sum ending on each item and return
     * the one with the maximum sum value
     * 
     * Complexity: O(n), space: O(n)
     * @param arr
     * @return 
     */
    public static int[] maxSum2(int[] arr){
        int[] maxEndings = new int[arr.length];
        //lets initialize the maxending to be a very small value
        //for(int i=0;i<maxEndings.length; i++){
        //    maxEndings[i] = Integer.MIN_VALUE;
        //}
        //now scan the given array's elements and update the max ending sum
        for(int i=0;i<arr.length;i++){
            if(i==0){
                maxEndings[i] = arr[i];
            }else{
                if(maxEndings[i-1]<0){
                    maxEndings[i] = arr[i];
                }else{
                    maxEndings[i] = maxEndings[i-1] +arr[i];
                }
            }
        }
        return maxEndings;
    }
    
    
    public static void main(String args[]){
        int[] a = {12, -3, -1, 8, - 1, 2, 4, - 2, 3};
        System.out.println("max subarray sum:"+maxSum1(a));
        int[] a2 = {1, 2, -5, 4, 3, 7};
        int [] maxEndings = maxSum2(a2);
        for(int i=0;i<maxEndings.length;i++){
            System.out.println("item:"+i+" has maxending of:"+maxEndings[i]);
        }
        //now iterate the maxEnding to find the maximum sum and then trace back to its 
        //previous indices to check which all of the previous members were used for this sum
        int maxIndex = 0;
        int maxSumValue = maxEndings[0];
        for(int i=0;i<maxEndings.length; i++){
            if(maxEndings[i]>maxSumValue){
                maxIndex = i;
            }
        }
        System.out.println("maxIndex was:"+maxIndex);
        //now trace back from this index to see which all have positive contributions
        int startIndex = maxIndex;
        int endIndex = maxIndex;
        while(endIndex>=0 && maxEndings[endIndex]>0){
            startIndex = endIndex;
            endIndex--;
        }
        System.out.println("the maxsum array ranges from:"+startIndex+" to:"+maxIndex);
    }
}
