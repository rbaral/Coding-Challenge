/*
We work using the concept of divide and conquer. We divide the array into small subarrays until there is only one
element in the subarray. The single element subarray is automatically sorted, so the next step is to merge the subarrays, this is
the place where the main work is done. While merging two sorted arrays, we check from the left index of the two arrays and get the merged
array.


- this is a stable sort (original order of equal items is retained)

Complexity: O(nlogn)

 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class MergeSortDemo {

    public static void merge(int[] arr, int[] buff, int start, int mid, int end) {
        //get the two halves copied into the buffer array
        getArrayCopy(arr, buff, start, end);
        //now create indices to identify the two halves that we need to merge
        int helpLeft = start;//the left half beginning
        int helpRight = mid + 1;//the right half beginning
        int curIndex = start;//the place where we copy the smallest from the above two halves

        while (helpLeft <= mid && helpRight <= end) {//exit when one at least subarray is exhausted
            if (buff[helpLeft] <= buff[helpRight]) {
                arr[curIndex] = buff[helpLeft];
                helpLeft++;
                curIndex++;
            } else {
                arr[curIndex] = buff[helpRight];
                helpRight++;
                curIndex++;
            }
        }
        //there might be at least one subarray that has some elements left
        //we just copy the remaining from the left half because the remaining of right half already exist in arr
        while (helpLeft <= mid) {
            arr[curIndex] = buff[helpLeft];
            helpLeft++;
            curIndex++;
        }
        System.out.println("sorted is:" + Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int[] buff, int start, int end) {
        //handle base cases
        if (start < end) {//till we do not get single item sub array
            int mid = (start + end) / 2;
            mergeSort(arr, buff, start, mid);
            mergeSort(arr, buff, mid + 1, end);
            //merge the sorted arrays
            merge(arr, buff, start, mid, end);
        }
    }

    public static int[] sortItems(int[] arr) {
        //we use the copy array as the buffer/working array
        //int[] copy = getArrayCopy(arr, new int[arr.length], 0, arr.length-1);
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        return arr;
    }

    /**
     * copy the elements of src array from start index to end index into dest
     * arry
     */
    public static void getArrayCopy(int[] src, int[] dest, int start, int end) {
        for (int i = start; i <= end; i++) {
            dest[i] = src[i];
        }

    }

    public static void main(String args[]) {
        int[] arr = {6, 2, 0, 7, 5, 3};
        System.out.println("Unsorted:" + Arrays.toString(arr));
        sortItems(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }
}
