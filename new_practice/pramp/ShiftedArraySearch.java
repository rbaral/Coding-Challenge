/**
#Shifted Array Search

Find a given number num in a sorted array arr:

arr = [2, 4, 5, 9, 12, 17]

If the sorted array arr is shifted left by an unknown offset and you don't have a pre-shifted copy of it, how would you modify your method to find a number in the shifted array?

shiftArr = [9, 12, 17, 2, 4, 5]

Explain and code an efficient solution and analyze its runtime complexity if num doesn't exist in the array, return -1
*/
import java.util.*;

public class ShiftedArraySearch{

	/**
	-Brute force approach is to sort the array again and find in the sorted array
	-another approach is the find the index at which the elements break the ordering and again restart the ordering.
	-then find which half to search for the given element
	-the main challenge is when the left half has repeated elements and the element to be searched is on the right half
	-if an element is found, return its index in the shifted array, else return -1
	*/
	public static int findShiftedArray(int[] nums, int n){
		//base case
		if(nums==null || nums.length<1){
			return -1;
		}
		return doBinarySearch(nums, 0, nums.length-1, n);
		
	}
	
	public static int doBinarySearch(int[] nums, int start, int end, int n){
		System.out.println("searching on index starting from:"+start+" to:"+end);
		int mid = (end + start)/2;
		if(nums[mid]==n){
			return mid;
		}
		if(end<start){
			return -1;
		}
		//if the left half is in correct order
		if(nums[start] < nums[mid]){
			//check on the left half
			if(nums[start]<=n && n<=nums[mid])
				return doBinarySearch(nums, start, mid-1, n);
			//check on the right half
			else
				return doBinarySearch(nums, mid+1, end, n);
			
		}else if(nums[mid]<nums[start]){//right half is in correct order
			if(nums[mid]<=n && n<=nums[end]){
				return doBinarySearch(nums, mid+1, end, n);
			}
			else{
				return doBinarySearch(nums, start, mid-1, n);
			}
		}else if(nums[start]==nums[mid]){//left half is all duplicates
			if(nums[mid]!=nums[end]){//rightmost item is different
				return doBinarySearch(nums, mid+1, end, n);
			}else{
				//check on both halves
				int index = doBinarySearch(nums, start, mid-1, n);
				if(index>=0){
					return index;
				}else{
					return doBinarySearch(nums, mid+1, end, n);
				}
			}
		}
		return -1;
	}

	public static void main(String args[]){
		int [] nums = new int[]{9, 12, 17, 2, 4, 5};
		nums = new int[]{2,2,2, 3,4, 2};
		//nums = new int[]{2, 4, 5, 9, 12, 17};
		//nums = new int[]{};
		//nums = new int[]{1,3};
		//nums = new int[]{4,5,6,7,0,1,2};
		//nums = new int[]{3,1};
		int n = 4;
		int index = findShiftedArray(nums, n);
		System.out.println("found "+n+" at index:"+index+" of array:"+Arrays.toString(nums));
	}
}