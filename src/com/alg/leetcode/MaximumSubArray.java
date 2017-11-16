/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package com.alg.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rbaral
 *
 */
public class MaximumSubArray {
	private static DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(format.format(new Date()));
		System.out.println(maxSubArray(nums));
		System.out.println(format.format(new Date()));
		System.out.println(maxSubArrayDP(nums));
		System.out.println(format.format(new Date()));

	}

	public static int maxSubArray(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int sum =0;
		for(int start = 0; start<nums.length;start++){
			sum =0;
			for(int subArrSize =1;subArrSize<=nums.length;subArrSize++){
				//make sure that we have a valid index/range for the array
				if(start+subArrSize>nums.length)
					break;
				//accumulate the sum for the subarray with size of subArrSize
				sum+= nums[start+subArrSize -1];
				//if adding the next element increases the ans, then do so
				ans = Math.max(ans,sum);
			}
		}
		return ans;
	}
	
	public static int maxSubArrayDP(int[] nums){
		return maxSubArrayDPR(nums);
		
	}
	
	public static int maxSubArrayDPR(int[] nums){
		if(nums.length == 1){
			return nums[0];
		}
		int m = (nums.length)/2;
		int[] newArr = new int[m-1];
		System.arraycopy(nums, 0, newArr, 0, m-1);
		int leftMax = maxSubArrayDPR(newArr);
		newArr = new int[nums.length -m];
		System.arraycopy(nums, m, newArr, 0, nums.length -m);
		int rightMax = maxSubArrayDPR(newArr);
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum =0;
		for(int i=m; i<nums.length;i++){
			sum+= nums[i];
			rightMax = Math.max(sum, rightMax);
		}
		
		for(int i=m-1; i>=0;i--){
			sum+= nums[i];
			leftMax = Math.max(sum, leftMax);
		}
		int ans = Math.max(leftMax, rightMax);
		ans = Math.max(ans,leftSum);
		return Math.max(ans,rightSum);
	}
}
