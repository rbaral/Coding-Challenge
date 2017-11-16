/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

package com.alg.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author rbaral
 *
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        List<Integer> keysList = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            keysList.add(nums[i]);
        }
        int diff=0;
        int indices[] = new int[2];
        indices[0]=-1;
        indices[1]=-1;
        for(int j=0;j<nums.length;j++){
            diff = target - nums[j];
            if(diff==nums[j])
                keysList.remove(Integer.valueOf(nums[j]));//to exclude itself from comparison, for cases like 2+2=4
            if(keysList.contains(diff)){
                System.out.println("Target:"+target+" found at:"+j);
                indices[0] = j+1;
                break;
            }
            //get back to original state
            if(diff==nums[j])
                keysList.add(nums[j]);
        }
        //find the second index by iterating the array
        for(int k=0;k<nums.length;k++){
            if(nums[k]==diff){
                indices[1]=k+1;
                //break;
            }
        }
        return indices;
    }
}
