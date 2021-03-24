/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

import java.util.Arrays;

/**
 *
 * @author rbara012
 * 
 * Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.
* 
 * 
 */
public class RangeAddition {
    
    static int[] getModifiedArray(int length, int [][] triplets){
        int[] result = new int[length];
        
        if(triplets==null || triplets.length<1)
            return result;
        
        for(int i=0;i<triplets.length;i++){
            result[triplets[i][0]]+= triplets[i][2];
            if(triplets[i][1]<length-1){
            /**
             * if the triplet's range is within the range of the array, 
             * then reduce the last element in the triplet's range by the increment value.
             * We reduce the value so that the following triplet will increase one less for the beginning
             * and when we start increasing from the beginning of the whole array we don't increase more
             */
                result[triplets[i][1]+1]-=triplets[i][2];
            }
            
        }
        int v = 0;
        for(int i = 0; i<length;i++){
            v+=result[i];
            result[i] = v;
        }
        return result;
    }
    
    public static void main(String args[]){
        int[][] triplets = new int[2][3];
        triplets[0][0] = 0;
        triplets[0][1] = 2;
        triplets[0][2] = 1;
        
        triplets[1][0] = 3;
        triplets[1][1] = 4;
        triplets[1][2] = 1;
        int[] arr = getModifiedArray(5, triplets);
        System.out.println(Arrays.toString(arr));
    }
}
