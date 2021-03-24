/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * Solution 1:
 * 
 * O(n^2) by having two nested loops and catching every match between the two arrays
 * 
 * Solution 2:
 * 1)sort the arrays
 * 2)scan every element of one array on the other using binary search
 * 3) if a match is found, record it's index so that it is  not compared again
 * 4)return the elements whose index has been recorded in step (3)
 * 
 * complexity: O(nlogn)
 * 
 * Solution 3:
 * 
 * Similar to the IntersectionOfTwoArrays.java where we just avoid duplicates, the difference is here we retain the duplicates
 * 
 * @author rbaral
 */
public class IntersectionOfTwoArraysII {
     public static int[] intersect1(int[] nums1, int[] nums2) {
         if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return new int[0];
        }else{
            Map<Integer,Integer> matchedIndex = new HashMap<Integer,Integer>();
            for(int i=0;i<nums1.length; i++){
                for(int j = 0; j<nums2.length;j++){
                    if (nums1[i]==nums2[j] && !matchedIndex.containsKey(j)){ //a match but j is not used before
                        matchedIndex.put(j, nums2[j]);
                        break;
                    }
                }
            }
            
            int [] matches = new int[matchedIndex.size()];
            int id= 0;
            for(int index:matchedIndex.keySet()){
                matches[id] = matchedIndex.get(index);
                id++;
            }
            return matches;
        }
    }
     
    public static int[] intersect(int[] nums1, int[] nums2) {
         if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return new int[0];
        }else{
            Map<Integer,Integer> matchedIndex = new HashMap<Integer,Integer>();
            //sort the arrays
            //Arrays.sort(nums1);
            Arrays.sort(nums2);
            for(int i=0;i<nums1.length;i++){
                int start = 0;
                int end = nums2.length-1;
                int mid = (start+end)/2;
                while(start<=end){
                    if(nums2[mid] == nums1[i] && !matchedIndex.containsKey(mid)){
                        matchedIndex.put(mid, nums2[mid]);
                        break;
                    }else if(nums2[mid] == nums1[i]){
                        if(nums2.length>2){
                            end--;
                        }else{
                            start++;
                        }
                    }
                    else if(nums2[mid]<nums1[i]){
                        start++;
                    }else if(nums2[mid]>nums1[i]){
                        end--;
                    }
                    mid = (start+end)/2;
                    
                }
            }
            int [] matches = new int[matchedIndex.size()];
            int id= 0;
            for(int index:matchedIndex.keySet()){
                matches[id] = matchedIndex.get(index);
                id++;
            }
            return matches;
        }
    } 
     
     
     public static void main(String args[]){
         int [] nums1 = {1, 1, 2, 2};
        int[] nums2 = {2, 2, 3};
        
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        nums1 = new int[]{1};
        nums2 = new int[] {1,1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        nums1 = new int[]{1};
        nums2 = new int[] {1,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        nums1 = new int[] {1,2,2,1};
        nums2 = new int[] {2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        
        nums1 = new int[]{};
        nums2 = new int[]{};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

        nums1 = new int[] {93,57,18,68,93,31,36,11,27,82,3,91,58,36,21,26,72,53,15,9,56,68,89,37,54,40,87,61,82,24,8,68,80,36,31,11,51,45,66,78,70,93,44,45,19,23};
        nums2 = new int[] {24,30,85,26,19,82,20,92,34,31,15,43,83,40,15,0,87,60,11,2,0,26,49,14,19,18,55,21,96,68,30,50,11,59,8,89,51,59,76,16,59,28,88,3,87,94,0,36,70,80,8,65,84,88,28,91,96};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        /**
         * Output:
        [51,3,8,68,11,70,80,82,15,18,87,19,21,24,89,91,26,31,36,40]
        Expected:
        [18,68,31,36,11,82,3,91,21,26,15,89,40,87,24,8,80,11,51,70,19]
         */
     }
}
