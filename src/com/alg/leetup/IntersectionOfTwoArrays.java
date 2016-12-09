/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
* 
* Solution 1:
* 1) Using two nested loops, check if the element in nums1 is present in nums2 - O(n^2)
* 2) Add the number to a list - O(1)
* 3) after loop is ended, return unique values from the list - O(n)
* 
* Runtime: O(n^2)
* 
* Solution 2:
* 
* 1)Scan through all the elements of nums1 and add the count in a hash - O(n)
* 2) Scan through all the elements of nums2 and reduce the count in the hash - O(n) (or we can use arraylist as well)
* 3) Iterate through the hash to return the keys with count zero
* 
* Runtime: O(n) which will be very large if the sizes of the array are really big
 * 
 * @author rbaral
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return new int[0];
        }else{
            Map<Integer,Integer> numsCount = new HashMap<Integer,Integer>();
            for(int i=0;i<nums1.length;i++){
                if(numsCount.containsKey(nums1[i])){
                    numsCount.put(nums1[i], numsCount.get(nums1[i])+1);
                }else{
                    numsCount.put(nums1[i], 1);
                }
            }
            int matchCount = 0;
            //reduce the count
            for(int i=0;i<nums2.length;i++){
                if(numsCount.containsKey(nums2[i]) && numsCount.get(nums2[i])>0){ //if found and has not been matched before
                    //this is a match
                    matchCount++;
                    numsCount.put(nums2[i], 0);
                }
            }
            int match[] = new int[matchCount];
            int matchedIndex = 0;
            //now look for the first element with count zero
            for(int n:numsCount.keySet()){
                if(numsCount.get(n)==0){
                    match[matchedIndex] = n;
                    matchedIndex++;
                }
                if(matchCount==matchedIndex)
                    break;
            }
            //System.out.println(""+numsCount.keySet());
            return match;
        }
    }
    
    public static void main(String args[]){
        int [] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        nums1 = new int[]{1};
        nums2 = new int[] {1,1};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        nums1 = new int[]{1};
        nums2 = new int[] {1,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        nums1 = new int[] {1,2,2,1};
        nums2 = new int[] {2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
