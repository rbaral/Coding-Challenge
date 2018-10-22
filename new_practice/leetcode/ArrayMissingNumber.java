/**
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
import java.util.*;

public class ArrayMissingNumber{

	/**
	method 1:
	iterate through the array elements and store the items in hash, in second pass iterate through 0 to n and check
	if the item is found in the hash or not, if not found that is the missing number
	O(n), Space O(n)
	
	Can we do better?
	-do the xor of number in the given array
	-do the xor of the numbers from 0 to n
	-as the xor of same elements cancel out, whatever is left should be the missing element
	O(n), Space O(1)
	*/
	public static int missingNumber(int[] nums) {
		//handle base case
		if(nums==null || nums.length<1){
			return -1;
		}
		int xor = nums[0];
		int n = nums.length+1;
		for(int i=1; i<nums.length; i++){
			xor^=nums[i];
		}
		for(int i=0; i<n; i++){
			xor^=i;
		}
		//whatever is left in xor is the required number
		return xor;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{3,0,1};
		nums = new int[]{9,6,4,2,3,5,7,0,1};
		System.out.println("for array:"+Arrays.toString(nums)+" missing num is:"+missingNumber(nums));
	}
}