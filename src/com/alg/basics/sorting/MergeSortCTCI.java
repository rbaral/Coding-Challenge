/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

/**
 *
 * @author rbaral
 */
public class MergeSortCTCI {
    
    static void mergeSort(int[] arr){
        int[] helperArr = new int[arr.length];
        mergeSort(arr, helperArr, 0, arr.length-1);
    }
    
    /**
     * divide and conquer till the array has more than one element
     * @param arr
     * @param helpeArr
     * @param low
     * @param high 
     */
    static void mergeSort(int[] arr, int[] helpeArr, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr, helpeArr, low, mid);
            mergeSort(arr, helpeArr, mid+1, high);
            merge(arr, helpeArr, low, mid, high);
        }
    }
    
    /**
     * merge the sorted list
     * @param arr
     * @param helperArr
     * @param low
     * @param mid
     * @param high 
     */
    static void merge(int[] arr, int[] helperArr, int low, int mid, int high){
        //copy both the halves into the helperArray
        for(int i=low;i<=high;i++){
            helperArr[i] = arr[i];
        }
        
        /**
         * create two pointers helpLeft and helpRight
         * that point to the beginning of the two halves
         * we compare the values at those index and the smaller
         * of the two goes to the original array
         */
        int helpLeft = low;
        int helpRight = mid+1;
        int currentIndex = low;
        /**
         * now we iterate through the helper array
         * and compare it's left and right portion (which are the two arrays to be merged)
         * the smaller will go the the target array first
         */
        while(helpLeft<=mid && helpRight<=high){
            if(helperArr[helpLeft]<=helperArr[helpRight]){
                arr[currentIndex] = helperArr[helpLeft];
                helpLeft++;
            }else{
                arr[currentIndex] = helperArr[helpRight];
                helpRight++;
            }
            //advance the index for the target array
            currentIndex++;
        }
        /**
             * if there are any remaining elements in the left
             * array, we copy them to the target array
             */
            int remainingElements = mid - helpLeft;
            for(int i=0;i<=remainingElements;i++){
                arr[currentIndex+i] = helperArr[helpLeft+i];
            }
            
            /**
             * we don't need to copy the right portion because
             * the right portion is already in the target array
             */
    }
    
    
    public static void main(String args[]){
        int a[] = {8,5,4,6,3,1,9,0, 2, 7, 6, -1};
        //print the list
        System.out.println("Before sorting");
        for(int b:a){
            System.out.print(" "+b);
        }
       mergeSort(a); 
       System.out.println("\nafter sorting");
        for(int b:a){
            System.out.print(" "+b);
        }
        
        
    }
}
