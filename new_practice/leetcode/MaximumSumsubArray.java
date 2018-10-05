/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
import java.util.*;
public class MaximumSumsubArray{

	/**
	Method1:
	-we use dynamic programming to keep track of the sum ending to a particular element, so we check the maximum sum we can get if a particular element is included in the sum
	*/
	public static int maxSubArray(int[] diff) {
		int[] sum = new int[diff.length];
		sum[0] = diff[0];
		int max = sum[0];
		for(int i =1;i<diff.length; i++){
			sum[i] = Math.max(sum[i-1] + diff[i], diff[i]);
			if(sum[i]>max){
				max = sum[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("for the array:"+Arrays.toString(nums)+" the maxsubarray sum is:"+maxSubArray(nums));
	}
}