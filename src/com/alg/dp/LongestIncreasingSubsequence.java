/*
Given a sequence of N numbers – A[1] , A[2] , …, A[N] . 
Find the length of the longest non-decreasing sequence


Solution:
-creat an array of length N that stores the length of longest increasing subsequence when that item is included,
for e.g., A[i] stores the length of increasing subsequence when A[i] is the last element of the sequence
-for each j>i, we need to check if A[j]>=A[i], if so, the sequence is maintained and we update the value of
A[j] = A[i] +1

Complexity: O(N^2)
 */
package com.alg.dp;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class LongestIncreasingSubsequence {
    
    public static int findMaxLengthSequence(int[] arr){
        //store the value 1 as default length for each item
        int[] max = new int[arr.length];
        for(int i=0;i<max.length;i++){
            max[i] = 1;//when only the element at index i itself is added, the subsequence is of length 1
        }
        for(int i=0; i<max.length; i++){
            for(int j = 0; j<i; j++){
                if(arr[j]<=arr[i]){// && max[i]< max[j]+1){
                    max[i] = max[j]+1;
                }
            }
        }
        //now we iterate through max and return the maximum value
        int maxValue = max[0];
        for(int i=0;i<max.length;i++){
            if(max[i]>maxValue)
                maxValue = max[i];
        }
        return maxValue;
    }
    
    public static void main(String args[]){
        int[] arr = {1, 5, 3, 4, 8, 6, 7};
        int maxLength = findMaxLengthSequence(arr);
        System.out.println("max length for "+Arrays.toString(arr)+" is:"+maxLength);
    }
}
