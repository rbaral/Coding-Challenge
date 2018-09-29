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
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

public class ArrayDuplicateNumber{

	/**
	Method1:
	Ref1: https://leetcode.com/problems/find-the-duplicate-number/discuss/72844/Two-Solutions-(with-explanation):-O(nlog(n))-and-O(n)-time-O(1)-space-without-changing-the-input-array
	-use binary search
	Ref2: http://keithschwarz.com/interesting/code/?dir=find-duplicate
	-use two pointers slow and fast
	*/
	public static int findDuplicate(int[] nums) {
		//TODO: handle base cases
		if(nums==null || nums.length<1)
			return 0;
		/*
        int slow = nums.length -1;
		int fast = nums.length - 1;
		//keep advancing slow by one step and fast by two steps until they meet inside a loop
		while(true){
			slow = nums[slow];
			fast = nums[nums[fast]];
			if(slow==fast){
				break;
			}
		}
		//start another pointer from the end and advance towards begining
		int newpt = nums.length-1;
		while(true){
			slow = nums[slow];
			newpt = nums[newpt];
			if(slow==newpt){
				return slow;
			}
		}
		*/
		int low =1;
		int high = nums.length-1;
		int mid = 0;
		while(low<high){
			mid = low + (high-low)/2;
			int count = 0;
			for(int i:nums){
				if(i<=mid)
					count++;
			}
			if(count<=mid){
				low=mid+1;
			}else{
				high = mid;
			}
		}
		return low;
    }
	
	public static void main(String args[]){
		int nums[] = new int[]{1,3,4,2,2};
		//nums = new int[] {3,1,3,4,2};
		System.out.println("duplicate is:"+findDuplicate(nums));
	}

}