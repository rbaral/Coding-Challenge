/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * implement quick sort:
 *
 * Quick sort operates on the following idea: -select a pivot element, lets say
 * the last element of the array -assume a wall index, which will be the
 * leftmost index of the array -the current element is the first element of the
 * array -compare every element from current element to the end of array, except
 * the pivot: --continue if the other elements are larger --if an element is
 * smaller than pivot, then swap the smaller element with the one in the current
 * index, put the pivot on the wall and, and point the wall on the right of the
 * current index --now every element on the left of pivot is smaller than pivot,
 * and the ones on right of pivot are larger than pivot --repeat the process
 * till the wall is at the end of the array
 */
import java.util.Arrays;

public class QuickSortDemo {

    public static void doQuickSort(int[] arr, int start, int end) {
        //TODOs: handle base cases
        if (end < start) {
            return;
        }
        int wallIndex = 0;
        int curIndex = 0;
        int pivotIndex = end;//select last elment as pivot

        //compare the pivot to every element from wallIndex to the end of the array
        for (int i = wallIndex; i < pivotIndex; i++) {
            if (arr[i] > arr[pivotIndex]) {
                continue;
            } else {
                //swap the current element with the one in the curIndex
                int temp = arr[curIndex];
                arr[curIndex] = arr[i];
                arr[i] = temp;
                //advance the wall
                wallIndex++;
                curIndex++;
            }
        }
        //if every element is compared, then we need to put the pivot element on the wall
        //so that every element before wall is less than pivot and on the right is larger //than pivot
        //swap the element at wallIndex and pivotIndex to bring pivot to its right position
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[wallIndex];
        arr[wallIndex] = temp;
        System.out.println("wall:" + wallIndex + " pivot:" + pivotIndex + ".." + Arrays.toString(arr));
        //recursively operate on the subarrays left and right of the pivot
        doQuickSort(arr, start, wallIndex-1);
        doQuickSort(arr, wallIndex + 1, end);
    }

    public static void main(String args[]) {
        int[] arr = {-1, 10, 5, 3, 0, -2, 22};
        System.out.println("Before sorting:" + Arrays.toString(arr));
        doQuickSort(arr, 0, arr.length - 1);
        System.out.println("after sorting:" + Arrays.toString(arr));
    }
}
