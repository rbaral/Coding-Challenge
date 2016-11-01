/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 * @author rbaral
 *
 */
public class SearchForRangeInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target))+"... for target:"+target);

	}
	
	/**
	 * find the range or occurence of target in the sorted array - nums
	 * we can also have a list from the nums array and find the first occurence
	 * of target and the last occurence and return the indices
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];//to hold the start and end range
        range[0] = -1; range[1]=-1;
        
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=target)
        		continue;
        	else{
        		if(range[0]==-1){//found the first occurence
        			range[0] = i;
        		}
        		range[1] = i;
        	}
        }
        return range;
    }

}
