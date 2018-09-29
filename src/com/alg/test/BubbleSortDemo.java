/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * implement bubble sort
 */
/**
 * Solution: It compares every pair of items to maintain the order, if not, it
 * swaps the position of the pairs. In a single pass, one large element bubbles
 * to an end. The process repeats until no swapping is required.
 *
 * Complexity: O(n^2)
 */
import java.util.Arrays;

public class BubbleSortDemo {

    public static void doBubbleSort(int[] arr) {
        //base cases
        if (arr == null || arr.length < 2) {
            return; //no sorting required
        }
        int last = arr.length;
        while (last>1) {
            //keep on bubbling
            for (int i = 1; i < last; i++) {
                if (arr[i - 1] > arr[i]) {//violates ascending order, so swap
                    swapItems(arr, i - 1, i);
                }
            }//after scanning all the items, one pass is completed, and one large elements bubbles up. So, we dont need to compare it with other items again.
            last--;
        }
    }
    //swaps the items in index p1 and p2

    public static void swapItems(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String args[]) {
        int[] arr = {1, 7, 2, 9, 3, -1};
        System.out.println("before sorting:" + Arrays.toString(arr));
        //now sort
        doBubbleSort(arr);
        System.out.println("after sorting:" + Arrays.toString(arr));

    }
}
