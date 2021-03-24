/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

/**
 * implements a simple quick sort
 * 
 * complexity: O(n^2) in worst case
 *
 * @author rbaral
 */
public class QuickSortSimple {
    
    public static int partition(int[] arr, int left, int right){
        //lets assume the middle one gives the partition
        int pivot = arr[(left+right)/2];
        //arrange elements in the desired order for this partition
        while(left<=right){
            //narrow down the window for the parition
          while(arr[left]< pivot){
            left++;
          }
          while(arr[right]> pivot){
              right--;
          }
         if(left<=right){
             //swap the elements as they break the order
             int temp = arr[left];
             arr[left] = arr[right];
             arr[right] = temp;
             left++;
             right--;
         }
         
        }
        return left;
    }
    
    public static void quickSort(int[] arr, int left, int right){
        //find the index that partitions this array with left side all less than the element at index and right side all greater than it
        int partIndex = partition(arr, left, right);
        if(left<partIndex-1)
            quickSort(arr, left, partIndex-1);
        if(right>partIndex)
            quickSort(arr, partIndex, right);
        
    }
    
    public static void main(String args[]){
        int [] arr = {5,6,8,1,2,0, 3};
        System.out.println("Before sorting");
        for(Integer i:arr)
            System.out.print(i+" ");
        quickSort(arr, 0, arr.length-1);
        System.out.println("\nafter sorting\n");
        for(Integer i:arr)
            System.out.print(i+" ");
    }
    
}
