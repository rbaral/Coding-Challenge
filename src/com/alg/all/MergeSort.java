/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

/**
 *Implementation of basic merge sort algorithm
 * complexity; O(nlogn)
 * @author rbaral
 */
public class MergeSort {
    
    /**
     * does the recursive mergesort operation
     * @param arr
     * @param helper
     * @param low
     * @param high 
     */
    public static void mergeSort(int[] arr, int[] helper, int low, int high){
        if(low<high){
            int mid = (low+ high)/2;
            mergeSort(arr, helper, low, mid);
            mergeSort(arr, helper, mid+1, high);
            merge(arr, helper, low, mid, high);
        }
    }
    /**
     * does the merging of two sorted arrays
     * @param arr
     * @param helper
     * @param low
     * @param mid
     * @param high 
     */
    public static void merge(int[] arr, int[] helper, int low, int mid, int high){
        //copy all the elements of arr in the range of low to high to the helper array
        for(int i=low; i<=high; i++){
            helper[i] = arr[i];
        }
        int helperLeft = low; //starting index of left array to be merged
        int helperRight = mid+1; //starting index of right array to be merged
        int curr = low; //the current index of arr that will be updated
        while(helperLeft<= low && helperRight<=high){
            if(helper[helperLeft] <= helper[helperRight]){
                //copy to the arr
                arr[curr] = helper[helperLeft];
                helperLeft++;
            }else{
                arr[curr] = helper[helperRight];
                helperRight++;
            }
            curr++;
        }
        //there might be some leftover on the left array to be merged
        int leftOver = mid - helperLeft;
        for(int i=0; i<=leftOver; i++){
            arr[curr+i] = helper[helperLeft +i];
        }
        //the leftover in the right array is already present in arr so we do not need to copy from helper array
    }
    public static void main(String args[]){
        int [] arr = {5,6,8,1,2,0};
        System.out.println("Before sorting");
        for(Integer i:arr)
            System.out.println(i);
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
        System.out.println("after sorting");
        for(Integer i:arr)
            System.out.println(i);
        
    }
    
}
