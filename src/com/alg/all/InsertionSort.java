/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

/**
 *
 * Implements the InsertionSort algorithm Ref:
 * https://en.wikipedia.org/wiki/Insertion_sort
 *
 * 1) Iteratively remove one element from the list and find the correct location
 * for it within the sorted list, and insert it there. 2) Repeat until no input
 * element remains.
 *
 * The sorted list grows behind an element.
 *
 * Its just like sorting the cards in the hand (while playing the bridge game).
 *
 * NOTE: 1) It is stable sort - doesn't change the original order of elements
 * with same key 2) It is inplace - only requires a constant space (O(1)) to
 * perform the sorting 3) It can perform online 4) It is simple and efficient
 * for small list 5) For large list, it's performance is not good in comparison
 * to QuickSort, MergeSort, HeapSort
 *
 *
 *
 * Best case: O(n) Worst case: O(n^2)
 *
 * Space: O(n)
 *
 * @author rbaral
 */
public class InsertionSort {

    static void sort(int[] a) {
        //start from the beginning
        for (int i = 1; i < a.length; i++) {
            //lets take the second element and compare it with the first element
            int x = a[i];
            //set another index which is the element just before x
            int j = i - 1;
            //repeat till the previous elements are greater than element at current index
            //every element greater than the current element are shifted right
            while (j >= 0 && a[j] > x) {
                //swap
                a[j + 1] = a[j];
                j--;
            }
            //now j+1 has created the right position for the current element
            a[j + 1] = x;
        }
    }

    public static void main(String args[]) {
        int a[] = {8, 5, 4, 6, 3, 1, 9, 2, 7, 6, -1};
        //print the list
        System.out.println("Before sorting");
        for (int b : a) {
            System.out.print(" " + b);
        }
        sort(a);
        //print the list
        System.out.println("\n");
        System.out.println("after sorting");
        for (int b : a) {
            System.out.print(" " + b);
        }
    }
}
