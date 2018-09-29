/**
#Array of Array Products

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

Solve without using division and analyze the runtime and space complexity

    Example: given the array [2,  7,  3,  4]
your function would return: [84, 24, 56, 42]  
    (by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3])
*/
import java.util.*;

public class ArrayofArrayProducts{

	/**
	-we find the prodct from the left
	-we find the product from the right
	-use the two products computed above to find the product for a given index
	O(n), space O(n)
	*/
	public static int[] getArrayProducts(int[] nums){
		//base case
		if(nums==null || nums.length<2){
			return nums;
		}
		int[] res = new int[nums.length];
		int prod = 1;
		//find the products from left
		for(int i=0;i<nums.length; i++){
			res[i]= prod;
			prod*=nums[i];
		}
		//find the products from right
		prod = 1;
		for(int i=nums.length-1; i>=0;i--){
			res[i]*=prod;
			prod*=nums[i];
		}
		return res;
	}
	
	public static void main(String[] args){
		int nums [] = new int[]{2,  7,  3,  4};
		System.out.println("original array is:"+Arrays.toString(nums));
		int[] prods = getArrayProducts(nums);
		System.out.println("prod array is:"+Arrays.toString(prods));
	}
}