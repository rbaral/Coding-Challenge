/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * implement counting sort
 */
/**
 * Solution: works by find the occurences/count of items in a given array. It
 * uses the count of an item and the count of previous item to find the position
 * of an item. After getting this updated count, it places the items to the
 * index given by this count and reduces the value of count by 1. NOTE: counting
 * and putting the count in the respective index does not work when the array
 * has negative numbers.
 */
import java.util.Arrays;

public class CountingSortDemo {

    public static int[] doCountingSort(int[] arr) {
        //find the largest element in the given array to get the size of counting array
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] countArr = new int[max + 1];
        //now count each element and update the value in its respective index
        for (int i = 0; i < arr.length; i++) {
            //update the count in the counting array
            countArr[arr[i]]++;
        }
        //update the count by adding the count of previous element
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        //now place the items back
        int[] outArr = new int[max + 1];
        System.out.println("counting arr:" + Arrays.toString(countArr));
        for (int i = 0; i < arr.length; i++) {
            //put the item back to the output array
            outArr[countArr[arr[i]]-1] = arr[i];
            --countArr[arr[i]];
        }
        return outArr;
    }

    public static void main(String args[]) {
        int[] arr = {1, 7, 2, 9, 3, 1};
        System.out.println("before sorting:" + Arrays.toString(arr));
        //now sort

        System.out.println("after sorting:" + Arrays.toString(doCountingSort(arr)));

    }

}
