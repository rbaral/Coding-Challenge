/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
package com.alg.leetup;

/**
 * @author rbaral
 *
 */
public class RemoveDuplicatesFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2,2,3};
		nums=new int[]{1,1};
		nums = new int[]{1,1,2};
		System.out.println(removeDuplicates(nums));
	}
	
	/**
	 * remove duplicates from a sorted array, in-place (without using extra array or extra space)
	 * as we cannot remove the elements from an array once the array is created,
	 * we just count the number of unique elements in the array and arrange the unique elements
	 * within that count. The rest of the elements in the array is simply ignored.
	 * @param nums
	 * @return
	 */
	 public static int removeDuplicates(int[] nums) {
		//ref:https://leetcode.com/discuss/76166/java-1ms-solution-simple-solution-two-pointers
		//base cases
			if (nums == null || nums.length == 0) return 0;
			if(nums.length==1) return 1;
	        int j = 0; //a pointer to keep track of previous element and the number of unique elements found so far
	        for(int i=1;i<nums.length; i++){
	            if(nums[i] > nums[j]){
                        //compare if the current element and the previous are unique, 
                        //if so, then add the unique element to the proper position
	                nums[++j] = nums[i];
	            }
	        }
	        return j+1;//the number of unique elements in the array
	 }
}
