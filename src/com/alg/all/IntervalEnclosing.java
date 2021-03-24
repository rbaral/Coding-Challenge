/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.searching;

import java.util.Arrays;

/**
 *Variant: Write a program which takes a sorted array A of integers, and an integer k, and returns
the interval enclosing k, i.e., the pair of integers L and U such that L is the first occurrence of k in
A and U is the last occurrence of k in A. If k does not appear in A, return [-1;-1]. For example if
A = [1; 2; 2; 4; 4; 4; 7; 11; 11; 13] and k = 11, you should return [7; 8].
* 
* Solution 1:
* 1)First check if the given number is present, if not then return [-1,-1]
* 2) if found, skew the array on the left and right by copying the left and right portion of array and operating on those copies
* 3)if found on the left copy, simply update the left range because this is the left index in the whole original array as well
* 4) if found on the right copy, add the new index to the index found in original array because this index starts after the original index
* 5)return the updated interval
* 
 * @author rbaral
 */
public class IntervalEnclosing {
    public static int[] findInterval(int[] a, int n){
        int[] range = {-1,-1};
        //lets find the first catch by the binary search
        int index = Arrays.binarySearch(a, n);
        if(index==-1){ //didn't find any
            return range;
        }else{//found one, there might be other too
            range[0] = index;
            range[1] = index;
            int lIndex = index;
            int rIndex = index;
            int[] newArr = Arrays.copyOfRange(a, 0, a.length);
            while(lIndex>=0){
                newArr = Arrays.copyOfRange(newArr, 0, lIndex);
                System.out.println("lindex is:"+lIndex);
                lIndex = Arrays.binarySearch(newArr, n);
                if(lIndex>=0)
                    range[0] = lIndex;
            }
            newArr = Arrays.copyOfRange(a, 0, a.length);
            while(rIndex>=0 && rIndex<a.length){
                newArr = Arrays.copyOfRange(newArr, rIndex+1, a.length);
                System.out.println("rindex is:"+rIndex+" looking in range:"+(rIndex+1)+".."+a.length);
                rIndex = Arrays.binarySearch(newArr, n);
                if(rIndex>=0)
                    range[1]+= rIndex+1; //the new index found on the right side will be actually the counted from the original index onwards
            }
        }
        return range;
    }
    
    public static void main(String args[]){
        int a[] = {1, 2, 2, 4, 4, 4, 7, 11, 11, 13};
        int num = 11;
        int [] range = findInterval(a, num);
        System.out.println("in a, the interval for "+num+" is:"+range[0]+" "+range[1]);
    }
}
