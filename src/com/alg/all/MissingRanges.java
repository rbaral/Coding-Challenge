/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges. 
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]

Example Questions Candidate Might Ask:

Q: What if the given array is empty?
A: Then you should return [“0->99”] as those ranges are missing.
Q: What if the given array contains all elements from the ranges?
A: Return an empty list, which means no range is missing.
* 
* Solution 1:
* 1)As the given array is sorted, we can scan the elements and check if the consecutive elements differ by more than 1
* 2 a) if differ by 1, continue
* 2 b) if differ by more than one, the range will be [smaller+1, larger-1]
* 
* Complexity: O(n)
 * 
 * Ref:https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.8.html
 */
public class MissingRanges {
    
    
    public static List<String> findMissingRanges(int[] nums, int start, int end){
        List<String> ranges = new ArrayList<String>();
        //handle base cases
        //TODOs: check if the start and end lies within the range of the first and the last element in the array
        if(nums==null || nums.length==0){
            ranges.add(start+"->"+end);
            return ranges;
        }else{
            //check if the start and end are addressed
            int expected = start;
           for(int i=0;i<nums.length;i++){
               if(expected!=nums[i]){
                   ranges.add(expected+"->"+(nums[i]-1));
               }
               expected = nums[i] +1;
           }
           //check if the given end number is taken care by the current expected number
           if(end-expected>=0){
               ranges.add(expected+"->"+end);
           }
        }
        return ranges;
    }
    
    public static void main(String args[]){
        int nums[] = {0,1,3,50,75,105}; //range is inclusive 0-99
        int start = 0, end = 105; //the range can be customized by the start and end variables
        List<String> ranges = findMissingRanges(nums, start, end);
        for(String s: ranges){
            System.out.println(s);
        }
        System.out.println("");
        
    }
    
}
