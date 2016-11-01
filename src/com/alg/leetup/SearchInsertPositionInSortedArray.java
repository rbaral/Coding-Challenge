/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 --> 2
[1,3,5,6], 2 --> 1
[1,3,5,6], 7 --> 4
[1,3,5,6], 0 --> 0
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 * @author rbaral
 *
 */
public class SearchInsertPositionInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = new int[]{1,3,5,6};
		int target = 2;
		System.out.println(Arrays.toString(nums)+"... target:"+target);
		System.out.println(searchInsert(nums, target));

	}
	
	/**
	 * find the position of the target in the given sorted array with unique elements, if it already exist
	 * if not, find the position where it should be inserted
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		//base cases
		if(nums==null || nums.length==0)
			return 0;
		if(nums.length==1){
			if(nums[0]<target)
				return 1;
			else
				return 0;
		}
		
		int start=0, end =0;
		int mid = nums.length/2;
		//find the searching direction - the left half or the right half
		if(nums[mid]==target){
			return mid;
		}else if(nums[mid]<target){//focus on right half, mid to nums.length
			start = mid+1;
			end = nums.length -1;
		}else if(nums[mid]>target){//focus on left half, 0 to mid
			start =0;
			end = mid;
		}
		while(start<=end){
			if(nums[start]==target){
				return start;
			}
			else if(nums[start]<target){
				start++;
			}else if(nums[start]>target){
				return start;
			}
		}
		return start;
	}

}
