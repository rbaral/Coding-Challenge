/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

public class ArraySearchInRotated{

	/**
	-use the concept of binary search
	*/
	 public static int search(int[] nums, int n) {
		//first lets find the peak in the array
		int index = 0;
		while((index+1)<nums.length && nums[index] < nums[index+1]){
			index++;
		}
		//either we have found the index, or we have exhausted the array
		int start = 0, end = nums.length-1;
		if(index==nums.length-1){
			return doBinarySearch(start, end, nums, n);
		}else if(n<nums[end]){
			System.out.println("searching right from "+(index+1)+"to:"+end);
			//search right
			return doBinarySearch(index+1, end, nums, n);
		}else if(n> nums[start] && n<nums[index]){
			System.out.println("searching left from "+start+"to:"+index);
			//search left
			return doBinarySearch(start, index, nums, n);
		}else{
			System.out.println("searching both");
			//may be duplicates, search on both
			int val = doBinarySearch(start, index, nums, n);
			if(val>=0){
				return val;
			}
			return doBinarySearch(index+1, end, nums, n);
		}
	 }
	 
	 public static int doBinarySearch(int start, int end, int[] nums, int tar){
		 if(end<start){
			 return -1;
		 }
		 int mid;
		 while(start<=end){
			 mid = (start+end)/2;
			 if(nums[mid]==tar){
				 return mid;
			 }else if(nums[mid] <tar){
				 start = mid+1;
			 }else{
				 end = mid-1;
			 }
		 }
		 return -1;
	 }
	 
	 public static void main(String[] args){
		 int[] nums = {4,5,6,7,0,1,2};
		 int n = 0;
		 System.out.println(n+" is found at index:"+search(nums, n));
		 nums = new int[]{4,5,6,7,0,1,2};
		 n = 3;
		 System.out.println(n+" is found at index:"+search(nums, n));
		 nums = new int[]{1, 3};
		 n = 1;
		 System.out.println(n+" is found at index:"+search(nums, n));
	 }

}