/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.Arrays;

/**
 *You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order
* 
 * @author rbaral
 */
public class MergeSortedArray {
    
    /**
     * given the bigger array a with enough buffer to hold array b,
     * this method merges the two arrays into array a and returns
     * the final array (a itself but now full) in sorted form
     * 
     * we start from the end of array a and move the elements
     * to the position equal to the size of a plus size of b
     * @param a
     * @param b 
     * @param k - the index till where the array a is full (a.length - k is buffer)
     */
    static int[] merge(int[] a, int[] b, int k){
        int indexOfA = k-1;
        int indexOfB = b.length-1;
        int finalIndex = a.length-1;
        //now we compare  the arrays from the right end and find the proper position of the items
        while(indexOfA>=0 && indexOfB>=0){
            //check which element will move
            if(a[indexOfA]>b[indexOfB]){ //a will be shifted to the finalIndex
                a[finalIndex] = a[indexOfA];
                finalIndex--; //update the index to point to the next position to update
                indexOfA--; //update the index to point to next element of a
            }else{
                a[finalIndex] = b[indexOfB];
                finalIndex--;
                indexOfB--;
            }
        }
        //it might be the case that array a is exhausted before array b (elements of a greater than elements of b), 
        //so we need to insert all the elements of b into the array a, starting from the finalIndex
        System.out.println("finalIndex is "+finalIndex);
        System.out.println(""+Arrays.toString(a));
        while(indexOfB>=0){
            a[finalIndex] = b[indexOfB];
            finalIndex--;
            indexOfB--;
        }
        return a;
    }
    
    public static void main(String args[]){
        int[] a= {1,2,3,4,5, 0, 0, 0, 0}; //0 is for the buffer
        int[] b = {-3,-2,-1,7};
        System.out.println(""+Arrays.toString(a));
        a = merge(a, b, 5);
        System.out.println(""+Arrays.toString(a));
    }
}
