/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class MergeSortedArrays {

    public static void mergeArrays(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexM = lastA + lastB - 1;
        //add the larger element to the end of the merged list
        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] >= b[indexB]) {
                a[indexM] = a[indexA];
                indexA--;
            } else {
                a[indexM] = b[indexB];
                indexB--;
            }
            indexM--;
        }
        //if a is exhausted then all of its elements found the right position
        //if b still has some elements,we just add them to the front of a
        while (indexB >= 0) {
            a[indexM] = b[indexB];
            indexB--;
            indexM--;
        }

    }

    public static void main(String[] args) {
        int[] a = {11, 15, 100, 500, 700, -1, -1, -1, -1, -1};//-1 for empty space
        int[] b = {1, 22, 55, 400, 900};
        int lastA = 5;
        int lastB = 5;
        mergeArrays(a, b, lastA, lastB);
        for (Integer val : a) {
            System.out.print(val + " ");
        }
    }

}
