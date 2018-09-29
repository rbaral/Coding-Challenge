/*
compare two adjacent elements and swap them if they are not in correct order


complexity: O(n^2)
 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class BubbleSort {

    public static void sortItems(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    //swap them
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {6, 2, 0, 7, 5, 3};
        System.out.println("Unsorted:" + Arrays.toString(arr));
        sortItems(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }
}
