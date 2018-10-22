/**
Maximum product subarray

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
import java.util.*;

public class ArrayMaximumProductSubArray{

	/**
	-can we try using the dp approach similar to the max sum subarray
	-here as negative*negative gives a positive number which will be in turn higher value, we
	can retain the maximum and minimum value of the previous product and find the maximum among those two and the cur array value
	
	*/
	public static int getMaxProdSubArray(int[] nums){
		if(nums==null || nums.length<1){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int max = nums[0], min = nums[0], result = nums[0];
		for(int i=1; i<nums.length; i++){
			int temp = max;
			max = Math.max(max*nums[i], Math.max(min*nums[i], nums[i]));
			//the max so far with a negative number can yield min value so we use the max (here temp)
			min = Math.min(temp*nums[i], Math.min(min*nums[i], nums[i]));
			if(max>result){
				result = max;
			}
		}
		return result;
	}

	public static void main(String[] args){
		int[] nums = new int[]{2,3,-2,4};
		nums = new int[]{-2,0,-1};
		nums = new int[]{-2, 3, -4};
		System.out.println(Arrays.toString(nums)+" has max product subarray as:"+getMaxProdSubArray(nums));
	}
}