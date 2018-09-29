/**
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
import java.util.Arrays;

public class ArrayDuplicates{
	/**
	Method1:
	-use two nested loops and check if an element in outer loop is also catched by the one in inner loop
	O(n^2)
	*/
	public static boolean isduplicate1(int[] nums){
		for(int i=0;i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i]==nums[j]){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	Method2:
	-sort array and check if the consecutive elements are duplicate
	O(nlogn) with faster sorting algorithms + O(n) for checking the consecutive for duplicates
	*/
	public static boolean isduplicate2(int[] nums){
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1; i++){
			if(nums[i]==nums[i+1])
				return true;
		}
		return false;
	}
	
	/**
	Method3:
	-store the elements in auxiliary storage (e.g., hashmap) and check if the item was already found
	O(n) time, Space O(n)
	*/
	public static boolean isduplicate3(int[] nums){
		return false;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{1,2,3,1};
		System.out.println("duplicate1:"+isduplicate1(nums));
		System.out.println("duplicate2:"+isduplicate2(nums));
	}
}