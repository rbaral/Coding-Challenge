/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class MaximumSumSubArray{
	public int maxSubArray(int[] diff) {
        //base case
        if(diff.length==1){
            return diff[0];
        }
        int sum[] = new int[diff.length];
        sum[0] = diff[0];
		for(int i=1;i<diff.length; i++){
			sum[i] = Math.max(diff[i], sum[i-1] +diff[i]); 
		}
		//System.out.println(Arrays.toString(sum));
		//find the maximum from the sum array
		int maxsum = Integer.MIN_VALUE;
		for(Integer cursum:sum){
			if(cursum>maxsum)
				maxsum = cursum;
		}
		return maxsum;
    }
}