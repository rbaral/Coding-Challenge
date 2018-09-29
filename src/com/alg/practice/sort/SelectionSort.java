/*

repeatedly find the smallest (or largest) element from the unsorted portion of the array and
put it to the index on the left part (sorted part) of the array.

-inplace, comparision based sorting

Complexity: O(n^2)

 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class SelectionSort {

    public static void sortItems(int[] arr) {
        for (int j = 0; j < arr.length; j++) {//unsorted boundary
            int min = arr[j];
            int minIndex = j;
            for (int i = j; i < arr.length; i++) {//every element beyon unsorted boundary
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            //we have found the smallest from the right porition, so put into the sorted portion
            int temp = arr[j];
            arr[j] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

    public static void main(String args[]) {
        int[] arr = {6, 2, 0, 7, 5, 3};
        System.out.println("Unsorted:" + Arrays.toString(arr));
        sortItems(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }

}
