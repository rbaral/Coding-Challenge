/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.searching;

/**
 * Implements the classic binary search algorithm The idea is to check the
 * element with the middle element of a sorted array. If the target element is
 * less than the middle element of the array, we search on the left half of the
 * array, else we search on the right half of the array. We repeat recursively
 * until the array has some elements or the match is found.
 *
 * @author rbaral
 */
public class BinarySearch {

    /**
     * a classic binary search with the integer array and the target element as
     * the parameters.
     *
     * @param a - the given array
     * @param x - the target element
     * @return -1 if not found, else return the index
     */
    static int search(int[] a, int x) {
        //lets handle the base cases first
        //if the array is empty return -1
        if (a == null || a.length < 1) {
            return -1;
        } else if (a.length == 1) {//has one element
            return (a[0] == x) ? 0 : -1;
        } else {//has more than one elements
            //lets find the mid index
            int start = 0;
            int end = a.length - 1;
            int mid = (start + end) / 2;
            while (((end - start) > 1) && end < a.length) {
                //check if found in middle
                if (a[mid] == x) {
                    return mid;
                } else if (a[mid] > x) {//need to check on left side
                    end = mid - 1; //move left, start point is same
                } else {//need to check on right side
                    start = mid; //move right, end is same
                }
                mid = (start + end) / 2;
                //System.out.println(start+","+mid+","+end);
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        //lets create an array
        int[] a = {1, 5, 6, 9, 10, 11, 15, 19, 21};
        int x = 0;
        int matchedIndex = search(a, x);
        System.out.println("the index for " + x + " is:" + matchedIndex);
    }

}
