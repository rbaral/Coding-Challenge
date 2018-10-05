/**
Pancake sort
Given an array arr and a number k (1<= k< arr.length), 
write a method to flip the order of first k numbers of the array.

Use the flip(int[] arr, int k) method you wrote to sort a given array

Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.

flip(arr, i): Reverse array from 0 to i 
Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, the goal is to sort the sequence in as few reversals as possible.
*/
import java.util.*;
public class PanCakeSort{

	/**
	flips first k elments of the given array
	*/
	public static void flip(int[] nums, int k){
		//base case
		if(nums==null || nums.length<k){
			return;
		}
		int start = 0, end = k;
		while(start<end){
			//flip the two ends
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	//repeatedly call flip() method to sort the given array
	public static int[] pancakeSort(int[] nums){
		int arrsize = nums.length-1;
		while(arrsize>=1){
			//find the max element in the range
			int maxindex = findLargestIndex(nums, 0, arrsize);
			//flipt the first maxindex elements so that the max element in that range comes first
			flip(nums, maxindex);
			//now flip the numbers from beginning to the end, so that the max element goes to the end
			System.out.println("after a flip:"+Arrays.toString(nums));
			flip(nums, arrsize);
			//shrink the array size so that the max element is retained in its correct position
			arrsize--;
		}
		return nums;
	}
	
	//starting from the start and end index, find the index of largest element
	public static int findLargestIndex(int[] nums, int start, int end){
		int max = start;
		for(int i=start;i<=end;i++){
			if(nums[i]>nums[max]){
				max = i;
			}
		}
		System.out.println(Arrays.toString(nums)+" has maxinde is:"+max);
		return max;
	}
	
	
	public static void main(String args[]){
		int[] nums = new int[]{1,2,4,6,3,5};
		//nums = new int[]{2,3,6,-1,4};
		System.out.println("before sorting:"+Arrays.toString(nums));
		nums = pancakeSort(nums);
		System.out.println("after sorting:"+Arrays.toString(nums));
	}
	
	

}