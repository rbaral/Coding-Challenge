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

/**
NOTE: This question is either incomplete or the test cases in leetcode are not correct.
*/
public class MissingNumber{
	
	/**
	Method1:
	-use formula sum = n(n+1)/2 to find the actual sum
	-in single pass find the sum of the items in the array
	-the difference is the missing number
	O(n)
	*/
	public static int missingNumber1(int[] nums){
		if(nums== null || nums.length<1){
			return -1;
		}
		int actualsum = 0;
		for(int i=0;i<nums.length; i++){
			actualsum+=nums[i];
		}
		int n = nums.length; //because one item is missing
		int diff = (n*(n+1)/2) - actualsum;
		return diff;
	}

	public static void main(String args[]){
		int[] nums = new int[] {3,0,1};
		nums = new int[] {9,6,4,2,3,5,7,0,1};
		nums = new int[]{2};
		System.out.println("Missing number1 is:"+missingNumber1(nums));
	}
}