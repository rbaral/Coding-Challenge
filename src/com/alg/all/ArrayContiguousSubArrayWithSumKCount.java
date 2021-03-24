/**
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
import java.util.*;
public class ArrayContiguousSubArrayWithSumKCount{
	
	/**
	we use two nested loops and check if the interval gives the sum
	O(n^2)
	*/
	public static int findContiguousSubArraySumK1(int[] nums, int k){
		int count = 0;
		for(int i=0;i<nums.length; i++){
			int sum = nums[i];
			if(sum==k){
				count++;
			}
			for(int j = i+1; j<nums.length; j++){
				sum+=nums[j];
				if(sum==k){
					count++;
				}
			}
		}
		return count;
	}

	/**
	use hashmap to store the count so far and check if the complement sum-k is found, if so, use the index of the current item and the sum-k complement to define the interval.
	O(n), Space O(n)
	*/
	public static int findContiguousSubArraySumK2(int[] nums, int k){
		int cursum = 0;
		int count = 0;
		HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length; i++){
			cursum+=nums[i];
			if(!maps.containsKey(cursum-k)){
				maps.put(cursum, i);
			}else{
				//we already found its complement in the range maps.get(cursum-k) and i
				count++;
			}
		}
		return count;
	}
		
	public static void main(String[] args){
		int[] nums = new int[]{1,1,1};
		int k =2;
		System.out.println(findContiguousSubArraySumK1(nums, k));
		System.out.println(findContiguousSubArraySumK2(nums, k));
	}
}