/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Given an array of integers, write a method to organize it in a way that all
 * even numbers come in the begining and all the odd numbers come in the end.
 * Can you try without additional storage?
 *
 * Sol: -create two pointers p1 and p2. p1 points to begining of the array and
 * p2 to the end. -repeat while p1<p2 --if index p1 has even element, increaes
 * p1 --if index p2 has odd element, decrease p2 --if index p1 has odd element,
 * we need to send it to right by swapping with the even item on right --if
 * index p2 has even element, we need to bring it to left by swapping with the
 * odd in the left
 */
import java.util.Arrays;

public class ArrayEvenOddSorting {

    public static void doEvenOddSorting(int[] arr) {
        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 < p2) {
            if (arr[p1] % 2 == 0) {//is even
                p1++;
            }
            if (arr[p2] % 2 != 0) {//is odd
                p2--;
            }
            if (arr[p1] % 2 != 0 && arr[p2] % 2 == 0) {
                //odd is in the left point and even is in the right point, so swap them
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                //advance the pointers
                p1++;
                p2--;
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 5, 7, 0, 9, 12, 11};
        doEvenOddSorting(arr);
        System.out.println("after sorting:" + Arrays.toString(arr));
    }

}
