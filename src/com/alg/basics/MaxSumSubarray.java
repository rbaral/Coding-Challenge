/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 
 * 
 * @author rbaral
 */
public class MaxSumSubarray {
    
    public static int findMaximumSubarray(List<Integer> A) {
        int minSum = 0, sum = 0, maxSum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum < minSum) {
                minSum = sum;
            }
            if (sum - minSum > maxSum) {
                maxSum = sum - minSum;
            }
            System.out.println("maxsum is:"+maxSum+ " minsum is "+minSum);
        }
        return maxSum;
    }
    
    public static void main(String args[]){
        Integer[] a = { 1,4,5,-11,11,-1,-2};
        List<Integer> listInt = Arrays.asList(a);
        System.out.println("max sum is:"+findMaximumSubarray(listInt));
    }
}
