/**
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class ArrayDuplicatesII{

	/**
	Method1:
	-use nested loops and if duplicates are found, check the difference between the indices of the two loops
	O(n^2) time
	*/
	public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for(int i=0;i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if((nums[i] == nums[j]) && (Math.abs(j-i)<=k)){
					return true;
				}
			}
		}
		return false;
    }
	
	/**
	Method2:
	-iterate through the array and use auxiliary space to store the number and its index
	-if already stored number is equal to current number and the index<=k return true
	O(n), Space O(n)
	*/
	public static boolean containsNearbyDuplicate2(int[] nums, int k){
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int index = 0;
		for(int i:nums){
			if(indexMap.containsKey(i) && Math.abs(indexMap.get(i)-index)<=k ){
				return true;
			}
			indexMap.put(i, index++);
		}
		return false;
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{1,2,3,1};
		int k = 3;
		nums = new int[]{99, 99};
		k =2;
		System.out.println("containsNearbyDuplicate1: "+containsNearbyDuplicate1(nums, k));
		System.out.println("containsNearbyDuplicate2: "+containsNearbyDuplicate2(nums, k));
	}
}