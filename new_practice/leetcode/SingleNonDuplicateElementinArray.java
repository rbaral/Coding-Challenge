/**
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.
*/
import java.util.*;

public class SingleNonDuplicateElementinArray{
	
	/**
	Method1:
	keep track of the count of numbers in a hash, iterate through the hash and return the one with single count.
	This solution is O(n) time and O(n) space
	
	Can we do better?
	-we use the concept of binary search and try to find the first even-index that is not followed by same number
	Ref:https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100759/Java-Binary-Search-O(log(n))-Shorter-Than-Others
	*/
	public static int singleNonDuplicate(int[] nums) {
		int low = 0, high = nums.length/2;
		while(low<high){
			int mid = (low+high)/2;
			if(nums[2*mid]!=nums[2*mid+1]){
				high = mid;
			}else{
				low = mid+1;
			}
		}
		return nums[2*low];
	}

	public static void main(String[] args){
		//input is sorted and has every element appear twice except one
		int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
		nums = new int[]{1,1,2,2,3,3,4,4,8};
		System.out.println("for array:"+Arrays.toString(nums)+" the first nondup is:"+singleNonDuplicate(nums));
	}
}