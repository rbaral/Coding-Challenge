/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class ArrayMaximumSumSubArray{

	/**
	-use dp
	-for each array element, record the subarray sum including itself or not including itself
	*/
	public static int maxSubArray(int[] nums){
		if(nums==null || nums.length<1)
			return 0;
		int sum[] = new int[nums.length];
		int max = 0;
		sum[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			sum[i] = Math.max(sum[i-1] + nums[i], nums[i]);
			if(sum[i]>max){
				max = sum[i];
			}
		}
		return max;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}