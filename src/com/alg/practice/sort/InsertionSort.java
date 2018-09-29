/*
Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there. It repeats until no input elements remain.

Performance is O(n^2) in worst case
-it is stable, i.e. the original order of items is retained
-it is in-place, i.e. does not require additional memory space
 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class InsertionSort {

    public static int[] sortItems(int[] arr) {
        //at every iteration, we find position of one element, and repeat the process
        int curIndex = 1;
        for(int i = 0;i<arr.length && curIndex<arr.length; i++){
            int temp = arr[curIndex];
            while(curIndex>0 && arr[curIndex-1]>temp){
                //shift every element from index i to curIndex to onestep right
                arr[curIndex] = arr[curIndex-1];
                curIndex--;
            }
            arr[curIndex] = temp;
            System.out.println("curIndex:"+curIndex+" new curIndex:"+(i+2)+" temp was:"+temp+" sorted "+Arrays.toString(arr));
            curIndex=i+2;
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 0, 7, 5, 3};
        System.out.println("Unsorted:"+Arrays.toString(arr));
        int[] sortedArr = sortItems(arr);
        for (Integer i : sortedArr) {
            System.out.print(" " + i);
        }
        System.out.println("\n");
    }
}
