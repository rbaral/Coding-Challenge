/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * implement Insertion Sort:
 *
 * Sol: -it takes an element from the unsorted portion, compares it with each
 * and every preceeding item, and shifts right the items that are greater than
 * it. If an element smaller than it is found, it is placed in that position.
 * The step repeats.
 *
 *
 * complexity: O(n^2)
 */
import java.util.Arrays;

public class InsertionSortDemo {

    public static void doInsertionSort(int[] arr) {
        //TODOs: handle base cases
        int leftStart = 0;
        //compare the element at leftStart with all the previous elements and shift the greater ones
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            leftStart = i;
            for (int j = i - 1; j >= 0; j--) {
                //check if the previous item is greater, if so, shift one step back
                if (item < arr[j]) {
                    //shift the item one step to right
                    arr[leftStart] = arr[j];
                    leftStart--;
                } else {
                    //we found its right position, put item to index j
                    arr[leftStart] = item;
                    //i = leftStart+1;
                    break;
                }
                System.out.println(i+","+leftStart+","+Arrays.toString(arr));
            }
            
            //leftStart++;
        }

    }

    public static void main(String args[]) {
        int[] arr = {-1, 10, 9, 22, 3, 8, 5};
        System.out.println("Before sorting:" + Arrays.toString(arr));
        doInsertionSort(arr);
        System.out.println("after sorting:" + Arrays.toString(arr));
    }
}
