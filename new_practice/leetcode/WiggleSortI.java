/**
Given an unsorted array of integers, sort the array into a wave like array. An array arr[0..n-1] is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= ....
Examples:

 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                 {20, 5, 10, 2, 80, 6, 100, 3} OR
                 any other array that is in wave form

 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                 {10, 8, 20, 2, 6, 4} OR
                 any other array that is in wave form

 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                 any other array that is in wave form

 Input:  arr[] = {3, 6, 5, 10, 7, 20}
 Output: arr[] = {6, 3, 10, 5, 20, 7} OR
                 any other array that is in wave form
*/

import java.util.*;

public class WiggleSortI{

	/**
	Method 1:
	-sort the array
	-use two pointers one pointing to start and another to end of the array
	-build the new array using the elements at two end so that they maintain the order
	O(nlogn) for sorting, O(n) space for new array
	*/
	public static void wiggleSort1(int[] nums) {
		Arrays.sort(nums);
		int start = 0, end = nums.length-1;
		while(start<end){
			//swap the elements the two extreme ends
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			//advance the start and end index twice because the order of wave should be maintained
			start+=2;
			end-=2;
		}
	}
	
	/**
	can we do something without sorting?
	-we just check the following constraint with every even indexed element, because we need to maintain the wiggle order
	on the even index and that will be fine:
	--if an even indexed element is smaller than the previous odd indexed element, swap them
	--if and even indexed element is smaller than the next odd indexed element, swap them
	O(n) time, and O(1) space
	*/
	public static void wiggleSort2(int[] nums) {
		//todo:handle base case
		for(int i=0;i<nums.length; i+=2){
			//check if previous odd is valid and is smaller than it
			if((i-1)>=0 && nums[i] <  nums[i-1]){
				//swap them
				int temp = nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = temp;
			}
			//check if the next odd is valid and is smaller than it
			if((i+1)<nums.length && nums[i]<nums[i+1]){
				//swap them
				int temp = nums[i+1];
				nums[i+1] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
	public static void main(String[] args){
		int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		System.out.println("before:"+Arrays.toString(arr));
		wiggleSort2(arr);
		System.out.println("after:"+Arrays.toString(arr));
	}
}