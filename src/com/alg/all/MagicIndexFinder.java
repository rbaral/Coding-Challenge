/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Given a sorted array with distinct integers, find the magic index, i.e.
 * A[i]==i, if one exists.
 *
 * FOLLOW UP: What if the numbers are not unique (can be duplicate numbers)
 */
/**
 * Sol1: -scan the array and check if A[i]==i for each and every value -O(n)
 *
 * Sol2: -we use the given information, i.e. the arrray is sorted and the
 * numbers are distinct - so we, check from the middle of the array, --if A[i]==
 * i, we are done -- if A[i]<i, the value is less than the index, the more we go on right, the index will increase by
 * one and the value should increase by at least one, so the right side does not have the magic index,
 * hence we search on the left half
 * -- if A[i]>i, we search on the right half
 */
public class MagicIndexFinder {

    public static int getIndexDistinct(int[] a, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == mid) {
            return mid;
        } else if (a[mid] > mid) { //look the left half
            return getIndexDistinct(a, start, mid - 1);
        } else {//look on the right half
            return getIndexDistinct(a, mid + 1, end);
        }
    }

    /**
     * if the values are duplicate, it is simply difficult to check which side
     * to search we check: -if a[midIndex] == midValue, if so return midIndex -
     * find leftEnd = Math.min(midIndex -1, midvalue), and scan from start to
     * leftEnd //this can help us skip some comparisons on the left - find
     * rightStart = Math.max(mindIndex+1, midValue), and scan from rightStart to
     * end --this can help us skip some comparisons on the right
     *
     */
    public static int getIndexDuplicates(int[] a, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == mid) {
            return mid;
        }
        int leftEnd = Math.min(mid - 1, a[mid]);
        int rightStart = Math.max(mid + 1, a[mid]);
        int leftIndex = getIndexDuplicates(a, start, leftEnd);
        //if we found, return the magicindex
        if (leftIndex >= 0) {
            return leftIndex;
        }
        //if not found, check the right half
        return getIndexDuplicates(a, rightStart, end);

    }

    public static void main(String args[]) {
        int[] a = new int[]{-5, -2, 1, 3, 6, 7, 9};
        System.out.println("magic index is at:" + getIndexDistinct(a, 0, a.length - 1));
        System.out.println("magic index is at:" + getIndexDuplicates(a, 0, a.length - 1));
        System.out.println("*********");
        a = new int[]{-5, -2, 1, 2, 6, 7, 9};
        System.out.println("magic index is at:" + getIndexDistinct(a, 0, a.length - 1));
        System.out.println("magic index is at:" + getIndexDuplicates(a, 0, a.length - 1));
        System.out.println("*********");

        a = new int[]{-5, 2, 2, 2, 5, 7, 9};
        System.out.println("magic index is at:" + getIndexDistinct(a, 0, a.length - 1));
        
        System.out.println("magic index is at:" + getIndexDuplicates(a, 0, a.length - 1));
        System.out.println("*********");
    }

}
