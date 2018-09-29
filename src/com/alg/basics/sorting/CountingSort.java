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
public class CountingSort {
    
    
    static int[] performCountingSort(int[] input, int k){
        int[] count = new int[k+1]; //array to store the count of elements in input array
        //store the count of each element in its corresponding index, e.g., count[2] stores the count for element 2
        for(int i = 0; i<input.length; i++){
            count[input[i]]= count[input[i]]+1;
        }
        
        //now update the count by including the count of elements less than or equal to the element
        //e.g., count[5] should contain the count of all elements less than or equal 5
        //this helps identify the position of 5 in the sorted array
        for(int i=1;i<=k;i++){
            count[i]=count[i]+count[i-1]; 
        }
        //count[i] contains the element less than or equal to i
        int [] output = new int[input.length];
        System.out.println("counts:"+Arrays.toString(count));
        for(int j = input.length-1; j>=0;j--){//for every input element
            //the position of an element in the output is determined by the count of elements less than or equal to it
            output[count[input[j]]-1] = input[j];
            //as we included the item already, reduce the count for elements upto input[j]
            count[input[j]]--;// = count[input[j]]-1;
        }
        return output;
    }
    
    /**
     * this approach only works with positive numbers,
     * we can extend it by using the minimum number and using the array index of count array
     * to store the count of negative numbers
     * https://stackoverflow.com/questions/40476521/using-counting-sort-with-negative-values-descending-order
     * @param args 
     */
    public static void main(String args[]){
        int [] a = {1,3,9,1,5,2,12,15,4,6};
        System.out.println("Unsorted: "+Arrays.toString(a));
        int k = 15; // assume that the elements are in the range 0 to k
        int [] sorted = performCountingSort(a, k);
        System.out.println("Sorted: "+Arrays.toString(sorted));
        
    }
}
