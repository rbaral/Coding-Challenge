/**
Given an array arr and a number k (1<= k< arr.length), 
write a method to flip the order of first k numbers of the array.

Use the flip(int[] arr, int k) method you wrote to sort a given array



Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.

flip(arr, i): Reverse array from 0 to i 
Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, the goal is to sort the sequence in as few reversals as possible.

The idea is to do something similar to Selection Sort. We one by one place maximum element at the end and reduce the size of current array by one.

Following are the detailed steps. Let given array be arr[] and size of array be n.
1) Start from current size equal to n and reduce current size by one while it’s greater than 1. Let the current size be curr_size. Do following for every curr_size
……a) Find index of the maximum element in arr[0..curr_szie-1]. Let the index be ‘mi’
……b) Call flip(arr, mi)
……c) Call flip(arr, curr_size-1)
*/

import java.util.*;

public class PancakeSort{
	
	/**
	Flips k elements starting from index start to end
	- create a pointer low that points to 0 and high that points to k
	- repeatedly swap the items at index low and high till low<high
	O(high-low) = O(k) complexity, O(1) space
	*/
	public static void flip(int[] arr, int k){
		//handle base cases
		if(arr==null || arr.length<2 || k<1){
			return;
		}
		int low = 0;
		int high = k;
		while(low<high){
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
	
	/**
	-sorting needs to send the largest/smallest element at the last/first
	-start with low = 0
	-find the index of the smallest/largest element and flip the order of items from start to minindex/maxindex
	-advance low by 1 and repeat till low<arr.length
	*/
	public static int[] pancakeSort(int[] arr){
		
		for(int arrsize=arr.length-1; arrsize>1; arrsize--){
			int maxindex = findLargestInArray(arr, 0, arrsize);
			flip(arr, maxindex);
			
			flip(arr, arrsize);
			System.out.println("after a flip:"+Arrays.toString(arr));
		}
		return arr;
	}
	
	//finds the index of smallest element, starting from start and ending at index end
	public static int findLargestInArray(int[] arr, int start, int end){
		int sindex = start;//lets suppose
		while(start<end){
			if(arr[sindex]<arr[start]){
				sindex = start;
			}
			start++;
		}
		return sindex;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,5,4,3,2, 0};
		arr = new int[]{2,3,6,-1,4};
		System.out.println("before the array is:"+Arrays.toString(arr));
		//flip(arr, 5);
		//System.out.println("Flipped array is:"+Arrays.toString(arr));
		System.out.println("Sorted array is:"+Arrays.toString(pancakeSort(arr)));
	}

}