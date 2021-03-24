/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * implement selection sort
 */
/**
 * selection sort works by find the smallest(or largest) element one at a time.
 * Intuitively, the input array is assumed as two parts - sorted and unsorted,
 * first the sorted part is empty and the unsorted part is the whole given input
 * array. Finds the smallest element in the unsorted part, swap its position
 * with the leftmost element in the array, advance the index for the leftmost
 * element.
 *
 * Complexity: O(n^2)
 */

import java.util.Arrays;

public class SelectionSortDemo {

    public static void doSelectionSort(int[] arr) {
        //TODOs:handle base cases
        //the index of left item
        int leftEnd = 0; //the ending point of the left half/sorted half
        int rightStart = 0; //the starting point of right half/unsorted half
        while (leftEnd>=0 && leftEnd < arr.length) {
            //find the smallest element in the right half
            int smallIndex = rightStart;
            for (int i = rightStart; i < arr.length; i++) {
                if (arr[smallIndex] > arr[i]) {
                    smallIndex = i;
                }
            }
            //we found the small item, so bring it to the rightmost part of the left half
            int temp = arr[rightStart];
            arr[rightStart] = arr[smallIndex];
            arr[smallIndex] = temp;
            rightStart++;
            leftEnd++;
        }
    }

    public static void main(String args[]) {
        int[] arr = {-1, 10, 9, 22, 3, 8, 5};
        System.out.println("Before sorting:" + Arrays.toString(arr));
        doSelectionSort(arr);
        System.out.println("after sorting:" + Arrays.toString(arr));
    }
}
