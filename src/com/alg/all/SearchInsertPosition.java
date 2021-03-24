/**
search insert position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/
import java.util.*;

public class SearchInsertPosition{

	/**
	Method1:
	-iteratively scan the array and keep on iterating till the element is less than the given target
	-return the index when the current element is larger than the target or the array is exhausted
	*/
	public static int searchInsert1(int[] nums, int target) {
        int i = 0;
		for(i=0;i<nums.length; i++){
			if(nums[i]<target){
				continue;
			}else{
				return i;
			}
		}
		return i;
    }
	
	/**
	we can use binary search to find the index
	*/
	public static int searchInsert2(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		int mid = (start+end)/2;
		//find the direction to search
		if(nums[mid]==target){
			return mid;
		}
		else if(nums[mid]<target){
			start = mid+1;
		}else{
			end = mid-1;
		}
		while(start<=end){
			if(nums[start]==target){
				return start;
			}else if(nums[start]<target){
				start++;
			}else{
				return start;
			}
		}
		return start;
	}
	public static void main(String[] args){
		int[] nums = new int[]{1,3,5,6};
		int k = 1;
		k = 5;
		k = 7;
		k = 0;
		k = 2;
		System.out.println("in array:"+Arrays.toString(nums)+" the item "+k+" goes to index: "+searchInsert1(nums, k));
		System.out.println("in array:"+Arrays.toString(nums)+" the item "+k+" goes to index: "+searchInsert2(nums, k));
	}
}