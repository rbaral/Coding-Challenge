/**
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6

Example 2:
Input: [1,2,3,4]
Output: 24

Example 3:
Input
[-4,-3,-2,-1,60]
Output:720

Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
*/
import java.util.Arrays;

public class ArrayMaxProductThreeNumbers{

	/**
	Method1 - use three loops and keep track of the max product, O(n^3) time
	
	Method2:
	*/
	public static int maxProduct(int[] nums){
		if(nums==null || nums.length<3){
			return 0;
		}
		Arrays.sort(nums);
		int len = nums.length-1;
		//if there are negative numbers then the earlier number contribute to the max product
		int max1 = nums[0]*nums[1]*nums[len];
		int max2 = nums[len] *nums[len-1] * nums[len-2];
		return Math.max(max1, max2);
		
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3};
		System.out.println(maxProduct(nums));
		System.out.println(maxProduct(new int[]{1,2,3,4}));
		System.out.println(maxProduct(new int[]{-4,-3,-2,-1,60}));
		
	}
}