/**
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

public class ArraySingleDuplicate{

	/**
	-use the concept of binary search
	*/
	public static int findDuplicate(int[] nums) {
		int low = 1, high = nums.length-1;
		int mid = 0;
		while(low<high){
			int count = 0;
			mid = (low+high)/2;
			for(int i:nums){
				if(i<=mid){
					count++;
				}
			}
			if(count<=mid){//because the expected elements on the left to mid are less than or equal to mid
				low = mid+1;
			}else{
				high = mid;
			}
		}
		return low;
	}
	
	public static void main(String args[]){
		int nums [] = new int[]{1,3,4,2,2};
		System.out.println("dup is:"+findDuplicate(nums));
	}
}