/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 *
 * @author rbaral
 */
public class SubsetSum {
    
    public static boolean isSubsetSum(int[] arr, int start, int end, int sum){
        if(end<start || arr==null || arr.length==0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(arr.length==1 && arr[0]!=sum){
            return false;
        }else if(arr.length==1 && arr[0]==sum){
            return true;
        }
        //can be using the last number or without using it
        return isSubsetSum(arr, start, end-1, sum-arr[end]) || isSubsetSum(arr, start, end-1, sum);
    }
    
    public static void main(String[] args){
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("found?"+isSubsetSum(arr, 0, arr.length-1, sum));
    }
}
