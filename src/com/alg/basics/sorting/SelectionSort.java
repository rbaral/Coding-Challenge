/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.sorting;

/**
 *
 * @author rbaral
 * 
 * Implementing Selection Sort
 * 
 * 1)Split the list into sorted (on left side) and unsorted (on the right side). 
 * By default, the sorted list is empty at the beginning
 * 2)find the smallest from the unsorted portion, swap it with the leftmost element in the unsorted portion (this will give the correct position for the smallest element of this iteration)
 * 3)update the index that separates the sorted and unsorted portion
 * 4)repeat 2-3 until the unsorted portion has some elements
 * 
 * The list gets sorted from the left side. Its noted for its simplicity when the auxiliary memory is limited.
 * NOTE:
 * 
 * Best case: O(n^2)
 * Worst case: O(n^2)
 * Space: O(n)
 * 
 * NOTE:
 * Heap sort will first order the elements of an array into the Heap Order (just converting the Heap tree into an array - where the left child of element
 * at index i will be at index 2*i+1 and the right child of element at index i will be at index 2*i+2.
 * The rest is same as in Selection Sort
 * Worst Case: O(n^2)
 * Best Case: O(n^2)
 * 
 */
public class SelectionSort {
    
    public static void main(String args[]){
        int a[] = {8,5,4,6,3,1,9, 2,0, 7, 6, -1};
        
        int unsortedIndex = 0; // the unsorted portion starts from 0 onwards initially
        int smallestIndex;
        while(unsortedIndex<a.length){//till the unsorted portion has some elements
            //lets assume the first one from the unsorted portion is the smallest one
            smallestIndex = unsortedIndex;
            for(int i=unsortedIndex;i<a.length;i++){//find the smallest from the unsorted portion
                if(a[i]<a[smallestIndex]){
                    smallestIndex = i; //yet another smallest was there
                }
            }
            //we have found the smallest from the unsorted list
            //now we swap this with the element on the leftmost index of the unsorted portion
            //swap the elements in the smallestIndex and the unsortedIndex
            //we swap without using the temp variable
            //no swapping needed if the element is in the leftmost of the unsorted portion
            if(smallestIndex!=unsortedIndex){
                a[smallestIndex] = a[smallestIndex] + a[unsortedIndex];
                a[unsortedIndex] = a[smallestIndex] - a[unsortedIndex];
                a[smallestIndex] = a[smallestIndex] - a[unsortedIndex];
            }
            //now update the unsortedIndex as we moved one element to the sorted portion
            unsortedIndex++;
        }
        //print the list
        System.out.println("after sorting");
        for(int b:a){
            System.out.print(" "+b);
        }
    }
}
