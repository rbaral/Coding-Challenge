/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;

/**
 *
 * @author rbaral
 *
 * Inversion Count for an array indicates – how far (or close) the array is from
 * being sorted.
 *
 * If array is already sorted then inversion count is 0. If array is sorted in
 * reverse order that inversion count is the maximum.
 *
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] >
 * a[j] and i < j.
 *
 * For example, The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1),
 * (4, 3).
 *
 * Ref: CLRS
 *
 */
public class InversionCount {

    static int[] surpassCount;

    public static int countInversions(int[] arr, int start, int end) {
        int[] helperArr = new int[arr.length];
        surpassCount = new int[arr.length];
        return countInversions(arr, helperArr, start, end);
    }

    public static int countInversions(int[] arr, int[] helpArr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (int) Math.floor((start + end) / 2);
            count = count + countInversions(arr, helpArr, start, mid);
            count = count + countInversions(arr, helpArr, mid + 1, end);
            count = count + mergeInversions(arr, helpArr, start, mid, end);
        }
        return count;
    }

    public static int mergeInversions(int[] arr, int[] helpArr, int low, int mid, int high) {
        int count = 0;
        //copy the given array to the helper array
        for (int i = 0; i < arr.length; i++) {
            helpArr[i] = arr[i];
        }

        /**
         * create two pointers helpLeft and helpRight that point to the
         * beginning of the two halves we compare the values at those index and
         * the smaller of the two goes to the original array
         */
        int helpLeft = low;
        int helpRight = mid + 1;
        int currentIndex = low;
        /**
         * now we iterate through the helper array and compare it's left and
         * right portion (which are the two arrays to be merged) the smaller
         * will go the the target array first
         */
        while (helpLeft <= mid && helpRight <= high) {
            if (helpArr[helpLeft] <= helpArr[helpRight]) {
                arr[currentIndex] = helpArr[helpLeft];
                helpLeft++;
                surpassCount[helpLeft] += 1;
            } else {
                arr[currentIndex] = helpArr[helpRight];
                helpRight++;
                count++;
            }
            //advance the index for the target array
            currentIndex++;
        }
        /**
         * if there are any remaining elements in the left array, we copy them
         * to the target array
         */
        //the remaining elements in the left array were greater than the one in the right array,
        //so they are probable inversions, increase the inversion count by the elements remaining in left
        int remainingElements = mid - helpLeft;
        if (remainingElements > 0) {
            count += remainingElements;
        }
        for (int i = 0; i <= remainingElements; i++) {
            arr[currentIndex + i] = helpArr[helpLeft + i];
        }

        /**
         * we don't need to copy the right portion because the right portion is
         * already in the target array
         */
        //the remaining elements in right part of helper array are surpasser for every elements in the left part
        int remRight = high - helpRight - 1;
        if (remRight > 0) {
            for (int i = low; i <= mid; i++) {
                surpassCount[i] += remRight;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int a[] = {2, 4, 1, 3, 5};
        System.out.println("Inversion count is:" + countInversions(a, 0, a.length - 1));
        System.out.println("\nafter sorting");
        for (int b : a) {
            System.out.print(" " + b);
        }
        System.out.println("");
        System.out.println("surpass count for: {2, 4, 1, 3, 5}:" + Arrays.toString(surpassCount));
    }
}
