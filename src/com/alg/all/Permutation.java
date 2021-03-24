/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ] 
 * 
 * Solution 1: 
 *1) if the array length is n, there are n distinct elements which can be organized in n! ways
 * 2)we start from k = 0 to array.length
 * 3)keep the first k numbers constant and get the permutation of numbers from index (k+1) to array.length
 * 3 a) repeat the index advancing process till we reach k=n
 *  b) when k=n, we simply add all the elements to the list because this is also one combination
 * 4) return the list
 *
 *
 * Ref: http://faculty.cse.tamu.edu/djimenez/ut/utsa/cs3343/lecture25.html
 */
public class Permutation {

    static void swap(int v[], int i, int j) {
        int t;

        t = v[i];
        v[i] = v[j];
        v[j] = t;
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms =new ArrayList<List<Integer>>();
        perm(nums, perms, 0,  nums.length);
        System.out.println("perm length:"+perms.size());
        return perms;
    }

    /* recursive function to generate permutations */
    static void perm(int v[], List<List<Integer>> perms, int i, int n) {

        /* this function generates the permutations of the array
	 * from element i to element n-1
         */
        int j;

        /* if we are at the end of the array, we have one permutation
	 * we can use (here we print it; you could as easily hand the
	 * array off to some other function that uses it for something
         */
        List<Integer> list = new ArrayList<Integer>();
        if (i == n) {
            for (j = 0; j < n; j++) {
                list.add(v[j]);
            }
            perms.add(list);
        } else /* recursively explore the permutations starting
		 * at index i going through index n-1
         */ {
            for (j = i; j < n; j++) {

                /* try the array with i and j switched */
                swap(v, i, j);
                perm(v, perms, i+1, n);

                /* swap them back the way they were */
                swap(v, i, j);
            }
        }
    }
    
    public static void main(String args[]){
        int [] nums = {1,2,3,4};
        System.out.println(permute(nums));
    }
}
