/**
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class MaxProductSubArray{

	public static int maxProdSubArray(int[] nums){
		if(nums==null || nums.length<1)
			return 0;
		if(nums.length==1)
			return nums[0];
		int min = nums[0], max = nums[0], res = nums[0];
		for(int i=1;i<nums.length; i++){
			int lastMax = max;
			max = Math.max(lastMax*nums[i], Math.max(min*nums[i], nums[i]));
			min = Math.min(lastMax*nums[i], Math.min(min*nums[i], nums[i]));
			if(max>res){
				res = max;
			}
		}
		return res;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{2,3,-2,4};
		System.out.println(maxProdSubArray(nums));
	}
}