/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Implement merge sort.
 *
 * How merge sort works? -sorts small arrays recursively and merges them. The
 * merge operation is the backbone of this algorithm as it needs careful design
 * to merge two sorted arrays
 *
 * Complexity: O(nlogn)
 */
import java.util.Arrays;

public class MergeSortDemo {

    public static void doMergeSort(int[] arrA, int[] helperArr, int start, int end) {
        //TODOs: handle base cases
        if(start<end){
           //recursively sort the subarrays
            int mid = (start + end) / 2;
            //recursively sort on the left and right sub arrays
            doMergeSort(arrA, helperArr, start, mid);
            doMergeSort(arrA, helperArr, mid+1, end);
            //merge the two sorted subarrays from being to end index
            doMerge(arrA, helperArr, start, mid, end); 
        }
        
    }

    //merge the two sorted runs arrA[start:mid-1] and arrA[mid:end-1] of array arrA and have the result in arrB[start:end-1]
    public static void doMerge(int[] arrA, int[] helperArr, int start, int mid, int end) {
        getCopy(arrA, helperArr, start, end);
        int aleftStart = start;//start to mid
        int aRightStart = mid+1;//mid+1 to end-1
        int curIndex = start;
        while(aleftStart<=mid && aRightStart<=end){
            if(helperArr[aleftStart]<=helperArr[aRightStart]){
                arrA[curIndex] = helperArr[aleftStart];
                aleftStart++;
            }else{
                arrA[curIndex] = helperArr[aRightStart];
                aRightStart++;
            }
            curIndex++;
        }
        //check if any array is not exhausted
        int remaining = mid - aleftStart;
        for(int i=0;i<=remaining; i++){
            arrA[curIndex+i] = helperArr[aleftStart+i];
        }
    }

    public static void getCopy(int[] arrA, int[] helperArr, int start, int end) {
        for(int i=start; i<=end; i++){
            helperArr[i] = arrA[i];
        }
    }

    public static void main(String args[]) {
        int[] arrA = {1, 10, 5, 3, 0, 2, 22};
        System.out.println("Before sorting:" + Arrays.toString(arrA));
        int[] arrB = new int[arrA.length]; 
        //getCopy(arrA, arrB, 0, arrA.length-1);
        doMergeSort(arrA, arrB, 0, arrA.length-1);
        System.out.println("after sorting:" + Arrays.toString(arrA));

    }
}
