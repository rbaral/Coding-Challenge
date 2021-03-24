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
 * implementation of Bubble Sort:
 * Assuming the list to be sorted will be in ascending order:
 * 1)starting from the left, compare the leftmost element with the one adjacent to it
 * 2) if they don't satisfy the order, swap them else proceed
 * 3) now compare the second and third element and swap if they don't satisfy the order
 * 4) repeat until no swap is required
 * 
 * NOTE:
 * The list is sorted from the right side i.e. the largest element find its correct position in first iteration 
 * (this holds if we swap from the beginning of the list)
 * 
 * Worst performance O(n^2)
 * Best O(n) when no swap is required at all (the list is already sorted)
 * Space: O(1)
 * Not good when n is very large
 * 
 */
public class BubbleSort {
    
    
    static int[] performSort1(int [] a){
        for(int i=0;i<a.length; i++){
            for(int j = a.length-1; j>i; j--){
                if(a[j]<a[j-1]){
                    //swap
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    System.out.println("after swapping");
                    for(int b:a){
                        System.out.print(" "+b);
                    }
                    System.out.println("\n");
                }
            }
        }
        return a;
    }
	
	public static int[] performSort(int[] nums){
		boolean swapped = true;
		int n = nums.length;
		int i = 1;
		while(swapped){
			swapped = false;
			for(i=1; i<n; i++){
				if(nums[i]<nums[i-1]){
					swapped = true;
					int temp = nums[i];
					nums[i] = nums[i-1];
					nums[i-1] = temp;
				}
			}
			n = i;
		}
		return nums;
	}
    
    public static void main(String args[]){
        int a[] = {8,5,4,6,3,1};
        //print the list
        System.out.println("Before sorting");
        for(int b:a){
            System.out.print(" "+b);
        }
        System.out.println("\n");
        
        a = performSort(a);
       //print the list
        System.out.println("after sorting");
        for(int b:a){
            System.out.print(" "+b);
        }
    }
    
}
