/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/
import java.util.Arrays;

public class ArraySearchInRotatedII{

	/**
	-use the concept of binary search
	*/
	 public static boolean search(int[] nums, int n) {
		//first lets find the peak in the array
		int index = 0;
		while((index+1)<nums.length && nums[index] <= nums[index+1]){
			index++;
		}
		//either we have found the index, or we have exhausted the array
		int start = 0, end = nums.length-1;
		if(index==nums.length-1){
			return doBinarySearch(start, end, nums, n);
		}else if(n<nums[end] && n> nums[index]){
			System.out.println("searching right from "+(index+1)+"to:"+end);
			//search right
			return doBinarySearch(index+1, end, nums, n);
		}else if(n> nums[start] && n<nums[index]){
			System.out.println("searching left from "+start+"to:"+index);
			//search left
			return doBinarySearch(start, index, nums, n);
		}else{
			System.out.println("searching both "+start+" to:"+index+" and:"+(index+1)+" to :"+end);
			//may be duplicates, search on both
			if(doBinarySearch(start, index, nums, n)){
				return true;
			}
			return doBinarySearch(index+1, end, nums, n);
		}
	 }

	public static boolean doBinarySearch(int start, int end, int[] nums, int tar){
		 if(end<start){
			 return false;
		 }
		 int mid;
		 while(start<=end){
			 mid = (start+end)/2;
			 if(nums[mid]==tar){
				 return true;
			 }else if(nums[mid] <tar){
				 start = mid+1;
			 }else{
				 end = mid-1;
			 }
		 }
		 return false;
	 }
	 
	 public static void main(String[] args){
		 int[] nums = {4,5,6,7,0,1,2};
		 int n = 0;
		 System.out.println(n+" is found in "+Arrays.toString(nums)+":"+search(nums, n));
		 nums = new int[]{4,5,6,7,0,1,2};
		 n = 3;
		 System.out.println(n+" is found in "+Arrays.toString(nums)+":"+search(nums, n));
		 nums = new int[]{1, 3};
		 n = 1;
		 System.out.println(n+" is found in "+Arrays.toString(nums)+":"+search(nums, n));
		 nums = new int[]{0,2,2};
		 n = 0;
		 System.out.println(n+" is found in "+Arrays.toString(nums)+":"+search(nums, n));
		 nums = new int[]{2,2,2,0,1};
		 n = 0;
		 System.out.println(n+" is found in "+Arrays.toString(nums)+":"+search(nums, n));
	 }

}