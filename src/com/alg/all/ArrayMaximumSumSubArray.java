/**
MAximum sum subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
import java.util.*;

public class ArrayMaximumSumSubArray{

	 /**
	 -we use the dp approach and save the maximum sum if the sum is to be ended on that item
	 */
	 public static int maxSubArray(int[] nums) {
		int sum[] = new int[nums.length];
		sum[0] = nums[0];
		int maxsum = sum[0];
		for(int i=1;i<nums.length; i++){
			sum[i] = Math.max(sum[i-1] + nums[i], nums[i]);
			if(sum[i]>maxsum){
				maxsum = sum[i];
			}
		}
		return maxsum;
	 }

	public static void main(String[] args){
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(Arrays.toString(nums)+" has max sum subarray as:"+maxSubArray(nums));
	}

}