/**
Given an array nums of n integers where n > 1,  return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra 
space for the purpose of space complexity analysis.)
*/

import java.util.Arrays;

public class ArrayProductExceptSelf{

	/**
	Method1:
	-find the product from right in the first pass and assign to the current index
	-find the product from left in the second pass and assign to the current index
	*/
	public static int[] productExceptSelf1(int[] nums) {
		//base case
        if(nums==null || nums.length<2)
			return nums;
		int[] res = new int[nums.length];
		int prod = 1;
		for(int i=0;i<nums.length; i++){
			res[i] = prod;
			prod*= nums[i];
		}
		prod = 1;//reset it to start from the right end
		for(int i=nums.length-1; i>=0;i--){
			res[i]*= prod;
			prod*=nums[i];
		}
		return res;
    }
	
	public static void main(String args[]){
		int[] nums = new int[]{1,2,3,4};
		//nums = new int[]{0,0};
		System.out.println("product1 is: "+Arrays.toString(productExceptSelf1(nums)));
		
	}
}