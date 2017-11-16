/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
package com.alg.leetcode;

/**
 * @author rbaral
 *
 */
public class FirstMissingPositiveIntegerInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = new int[]{-1,-2,0};
		System.out.println(firstMissingPositive(nums));

	}
	
	/**
	 * finds the first missing integer in the given unsorted array
	 * constraints:
	 * a) should run in linear time
	 * b) should use constant space
	 * @param nums
	 * @return
	 * ref:http://www.lifeincode.net/programming/leetcode-first-missing-positive-java/
	 */
	 public static int firstMissingPositive(int[] nums) {
		 //base cases
		 if(nums==null||nums.length==0)
			 return 1;
		 else if(nums.length ==1){
			 if(nums[0]<=0 || nums[0]>1)
				 return 1;
			 else
				 return 2;
		 }
		
		int i = 0, tmp;
		while (i < nums.length) {
			/**
			 * check if : 
			 * a) the element is greater than 0 (we are not counting 0 as positive integer) 
			 * b) the elements are in their bucket order
			 * c) put the element with value i to the position i � 1
			 * and then maintain the order of the elements
			 */
			if (nums[i] > 0 && nums[i] != i + 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			} else
				i++;
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)//if the element's value and the bucket/position doesn't match then there is some value missing
				return i + 1;
		}
		return nums.length + 1;
	 }
}
