/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rbaral
 */
public class MaxAdjacentIndices {
   
    /**
     *function to return  maximum distance
     * between indices of the array that have adjacent values
     * Return -1 if no adjacent indices exist.
     * Adjacent values in A[]
     * are defined as:
     * A[p1], A[p2] s.t. A[p1] <>A[p2] and there is no value
     * in the array that is between A[p1] and A[p2]
     * 
     * Expected complexity: O(nlogn)
     * space: O(n)
     * 
     */
    public static int solution(int[] A) {
        Map<Integer,Integer> indices = new HashMap<Integer,Integer>();//store the index and its adjacent index
        for(int i=0;i<A.length; i++){
            indices.put(A[i], i);
        }
        //sort the array
        Arrays.sort(A);
        int maxDiff = -1;
        for(int i=1;i<A.length;i++){
            //there will be adjacent values in the consecutive positions, so we just check their index in the original array    
            int ind1 = indices.get(A[i-1]);
            int ind2 = indices.get(A[i]);
            //these are the original indices of the two elements now find the diff
            if(ind1!=ind2){
                int diff = Math.abs(ind1-ind2);
                System.out.println("indices are:"+ind1+","+ind2+" diff is:"+diff);
                if(diff>maxDiff)
                    maxDiff = diff;
            }
            
        }
        return maxDiff;
    }
    
    public static void main(String args[]){
        int[] a = {1,4,7,3,3,5};
        //System.out.println("max adjacency:"+solution(a));
        a = new int[]{0,3,3,1,5,3,11,1};
        System.out.println("max adjacency:"+solution(a));
    }
}
