/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class HeapSort {
    
    public static int getLeft(int i){
        return 2*i+1; //for zero index use +1, else use + 0
    }
    
    public static int getRight(int i){
        return 2*i + 2; //for zero index, use + 2, else use + 1
    }
    
    public static int heapSize(int [] arr){
        return arr.length-1;
    }
    public static void maxHeapify(int[] arr, int i){
        int left = getLeft(i);
        int right = getRight(i);
        int largest;
        if(left<= heapSize(arr) && arr[left]>arr[i]){
            largest = left;
        }else{
            largest = i;
        }
        if(right <=heapSize(arr) && arr[right]>arr[largest]){
            largest = right;
        }
        if(largest!=i){ //if something else was largest, swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest);
        }
    }
    
    public static void buildMaxHeap(int [] arr){
        for(int i= (int)Math.floor(arr.length/2); i>=0; i--){
            maxHeapify(arr, i);
        }
    }
    
    public static void heapSort(int [] arr){
        buildMaxHeap(arr);
        for(int i = arr.length-1; i>=1; i--){
            //as the max element is in arr[0], we send it to the last position
            //and repeat the heapify step for 1...n-1
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, 0);
        }
    }
    
    public static void main(String[] args){
        int[] arr = {1, 2, 5, 9, 3, 4};
        System.out.println("Before sorting:"+Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After sorting:"+Arrays.toString(arr));
    }
}
