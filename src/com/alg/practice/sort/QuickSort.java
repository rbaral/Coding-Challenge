/*
We use an element called partition (can be any randomly chosen element from the given array, but we chose the last
one to make things easier). We use a wallindex which simply points to the left of the first element. We repeat the following steps:
-compare the pivot with the element next to wall:
-- if it is smaller than pivot, we advance the position of wall
--if it is larger than pivot, we just advance the comparision with next element in the array
-after we find the right position of the pivot, we recursively repeat this process for the sub arrays

It is not stable and is not in-place sorting technique.

Complexity; O(n^2) in worst case
 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class QuickSort {

    /**
     * find the pivot point where the partition separates the smaller elements
     * than pivot and the larger elements than the pivot
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        //lets assume the middle element is the perfect pivot point
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            //at this point, if we still have left<right, then there is at least an element that breaks the order
            //we swap them to retain the order
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;

            }
        }
        return left;
    }

    public static void sortItems(int[] arr, int left, int right) {
        int partition = partition(arr, left, right);
        if (left < partition-1) {
            sortItems(arr, left, partition-1);
        }
        if (right > partition) {
            sortItems(arr, partition, right);
        }

    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 0, 7, 5, 3};
        System.out.println("Unsorted:" + Arrays.toString(arr));
        sortItems(arr, 0, arr.length - 1);
        System.out.println("sorted:" + Arrays.toString(arr));
    }
}
