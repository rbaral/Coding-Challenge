/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

/**
 *
 * @author rbaral
 * 
 * Objec­tive: The longest Increas­ing Sub­se­quence (LIS) prob­lem is to find the length of the longest sub­se­quence 
 * in a given array such that all ele­ments of the sub­se­quence are sorted in increas­ing order.

OR

Given a array A[1,2,.…..,n] , cal­cu­late B[1,2.…m] with B[i]<B[i+1] where i=1,2,3,.…,m such that m is maximum.

Exam­ple:

int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };

length of LIS is 7 and LIS is {1, 12, 23, 52, 61, 69, 70}.
 * 
 * 
 * Solution:
 * 
 * 
 * Ref:http://algorithms.tutorialhorizon.com/dynamic-programming-longest-increasing-subsequence/
 * 
 * Ref: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * 
 */
public class LongestIncreasingSubSequence {

    /**
     * this prints the list also but is O(n^2)
     * @param arrA 
     */
    
    public static void findSubsequence(int[] arrA) {
        int[] LIS = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                // check if previous elements > current element
                if (arrA[i] > arrA[j]) {
                    // update the max from the previous entries
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                // means none of the previous element has smaller than arrA[i]
                max = 1;
            }
            LIS[i] = max;
        }
        // find the max in the LIS[]
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }
        // Print the result
        // Start moving backwards from the end and
        String path = arrA[index] + " ";
        int res = result - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (LIS[i] == res) {
                path = arrA[i] + " " + path;
                res--;
            }
        }
        System.out.println("Longest Increasing subsequence: " + result);
        System.out.println("Actual Elements: " + path);
    }


    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = (l+r) / 2;
            if (A[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size) {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot
        
        
        tailTable[0] = A[0];
        
       
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0]) // new smallest value
            {
                tailTable[0] = A[i];
            } else if (A[i] > tailTable[len - 1]) // A[i] wants to extend largest subsequence
            {
                tailTable[len] = A[i];
               
                len++;
            } else /*If A[i] is in between, we will find a list with 
                largest end element that is smaller than A[i]. 
                Clone and extend this list by A[i]. We will discard all
                other lists of same length as that of this modified list.
              */
            {
                int index = CeilIndex(tailTable, -1, len - 1, A[i]);
                tailTable[index] = A[i];
               
            }
        }
        
        return len;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int A[] = {2, 5, 3, 7, 11, 8, 10, 13, 6, 1};
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "
                + LongestIncreasingSubsequenceLength(A, n));
    }
}
