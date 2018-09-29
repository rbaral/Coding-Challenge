/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class HeapSort {

    public static void heapify(int[] arr, int arrsize, int itemindex){
        //lets assume the given itemindex is largest one
        int largest = itemindex;
        int left = 2*largest+1; //position of left child when the heap is stored in an array
        int right = 2*largest+2;//position of right child when the heap is stored in an array
        
        //if left child is larger than the largest
        if(left<arrsize && arr[left]> arr[largest]){
            largest = left;
        }
        //if the right child is larger than the largest
        if(right<arrsize && arr[right]>arr[largest]){
            largest = right;
        }
        //check if the largest index is changed
        if(largest!=itemindex){
            //swap
            int temp = arr[largest];
            arr[largest] = arr[itemindex];
            arr[itemindex] = temp;
            //heapify the subtrees
            heapify(arr, arrsize, largest);
        }
    }
    public static int[] sortItems(int[] arr) {
        int arrsize = arr.length;
        //first we build a heap
        for(int i=arrsize/2-1; i>=0;i--){
            heapify(arr, arrsize, i);
        }
        //now extract the element from the heap
        for(int i=arrsize-1; i>=0;i--){
            //extract the root item
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //after we extract the item, need to maintain the heap again, so call the heapify again
            heapify(arr, i, 0);
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] a = {1, 3, 9, 1, 5, 2, 12, 15, 4, 6};
        System.out.println("Unsorted: " + Arrays.toString(a));
        int[] sorted = sortItems(a);
        System.out.println("Sorted: " + Arrays.toString(sorted));

    }
}
