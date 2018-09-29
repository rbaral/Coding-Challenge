/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class LargestSumcontiguoussubarray {

    public static void main(String[] args) {
        int[] a = {5, 2, -1, -4, -2, 5};
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int startIndex = 0; int endIndex = 0; int temps = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                startIndex = temps;
                endIndex = i;
            }
            if (max_ending_here <= 0) {
                max_ending_here = 0;
                temps= i+1;
            }
        }
        System.out.println("start: "+startIndex+" end:"+endIndex+" sum:"+max_so_far);
        return max_so_far;
    }
    
}
